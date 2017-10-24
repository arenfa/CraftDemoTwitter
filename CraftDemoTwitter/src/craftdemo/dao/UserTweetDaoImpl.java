package craftdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import craftdemo.model.User;
import craftdemo.model.UserTweet;

/**
 * @author arenfakhourian
 *
 */
@Repository("userTweetDAO")
public class UserTweetDaoImpl implements UserTweetDao {

	// we can do in memory db here
	
	@Override
	public List<UserTweet> getFeed() throws Exception {
		List<UserTweet> usertweets = new ArrayList<UserTweet>();
		
		UserTweet userTweet1 = new UserTweet();
		userTweet1.setUsername("aren from dao");
		userTweet1.setTweetMessage("hey was up");
		
		UserTweet userTweet2 = new UserTweet();
		userTweet2.setUsername("aren2 new");
		userTweet2.setTweetMessage("hey was up 2");
		
		usertweets.add(userTweet1);
		usertweets.add(userTweet2);
		
		return usertweets;
	}

	@Override
	public void follow(String username) throws Exception {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void tweet(String message) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
