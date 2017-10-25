package craftdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import craftdemo.dao.UserTweetDao;
import craftdemo.model.User;
import craftdemo.model.UserTweet;

/**
 * @author arenfakhourian
 *
 */
@Service("userTweetService")
public class UserTweetServiceImpl implements UserTweetService {
	
	@Autowired
	@Qualifier("userTweetCassandraDAO")
	private UserTweetDao userTweetDao;

	@Override
	public List<UserTweet> getFeed() throws Exception {
		return userTweetDao.getFeed();
	}

	@Override
	public void follow(String username) throws Exception {
		userTweetDao.follow(username);
	}

	@Override
	public void unfollow(String username) throws Exception {
		userTweetDao.unfollow(username);
	}

	@Override
	public List<User> getFollowers() throws Exception {
		return userTweetDao.getFollowers();
	}

	@Override
	public List<User> getFollowingUsers() throws Exception {
		return userTweetDao.getFollowingUsers();
	}

	@Override
	public void tweet(String message) throws Exception {
		userTweetDao.tweet(message);
	}


}
