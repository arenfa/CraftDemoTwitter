package craftdemo.cassandra.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import craftdemo.cassandra.model.FollowingFollow;
import craftdemo.cassandra.model.Tweet;
import craftdemo.dao.UserTweetDao;
import craftdemo.model.User;
import craftdemo.model.UserTweet;
import craftdemo.util.AuthenticationUtil;

@Repository("userTweetCassandraDAO")
public class UserTweetCassandraDaoImpl implements UserTweetDao {

	@Autowired
	private CassandraOperations cassandraOperations;
	
	@Override
	public List<UserTweet> getFeed() throws Exception {
		List<UserTweet> userTweets = new ArrayList<UserTweet>();
		List<User> followingUsers = getFollowingUsers();
		
		if(followingUsers == null || followingUsers.isEmpty()) {
			return userTweets;
		}
		
		StringBuilder users = new StringBuilder("");
		for(User user : followingUsers) {
			users.append("'").append(user.getUsername()).append("',");
		}
		String userList = users.deleteCharAt(users.length() - 1).toString();
		String cqlAll = "select * from tweet where userid in (" + userList + ") order by createdat desc limit 100";

		List<Tweet> results = cassandraOperations.select(cqlAll, Tweet.class);
		for (Tweet tweet : results) {
			UserTweet userTweet = new UserTweet();
			userTweet.setUsername(tweet.getUserId());
			userTweet.setTweetMessage(tweet.getTweetMessage());
			userTweets.add(userTweet);
		}
		return userTweets;
	}

	@Override
	public void follow(String username) throws Exception {
		String currentUserId = AuthenticationUtil.getCurrentUserId();
		FollowingFollow toFollow = new FollowingFollow();
		toFollow.setFollowingUserId(username);
		toFollow.setFollowerUserId(currentUserId);
		cassandraOperations.insert(toFollow);
	}

	@Override
	public void unfollow(String username) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getFollowers() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getFollowingUsers() throws Exception {
		String currentUserId = AuthenticationUtil.getCurrentUserId();
		List<User> users = new ArrayList<User>();
		String cqlAll = "select * from followingfollow where followeruserid='" + currentUserId + "'";

		List<FollowingFollow> results = cassandraOperations.select(cqlAll, FollowingFollow.class);
		for (FollowingFollow followingFollow : results) {
			User user = new User();
			user.setUsername(followingFollow.getFollowingUserId());
			users.add(user);
		}
		return users;
	}

	@Override
	public void tweet(String message) throws Exception {
		String currentUserId = AuthenticationUtil.getCurrentUserId();
		Tweet tweet = new Tweet();
		tweet.setId(UUID.randomUUID().toString());
		tweet.setTweetMessage(message);
		tweet.setUserId(currentUserId);
		tweet.setCreatedAt(new Date());
		cassandraOperations.insert(tweet);
	}

}


