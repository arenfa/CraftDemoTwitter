package craftdemo.service;

import java.util.ArrayList;
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
	public void follow(long userId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unfollow(long userId) throws Exception {
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
		userTweetDao.tweet(message);
	}


}
