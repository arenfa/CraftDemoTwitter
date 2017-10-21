package craftdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	private UserTweetDao userTweetDao;

	@Override
	public List<UserTweet> getFeed() throws Exception {
		List<UserTweet> usertweets = new ArrayList<UserTweet>();
		
		UserTweet userTweet1 = new UserTweet();
		userTweet1.setUsername("aren");
		userTweet1.setTweetMessage("hey was up");
		
		UserTweet userTweet2 = new UserTweet();
		userTweet2.setUsername("aren2 new");
		userTweet2.setTweetMessage("hey was up 2");
		
		usertweets.add(userTweet1);
		usertweets.add(userTweet2);
		
		return usertweets;
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
		// TODO Auto-generated method stub
		
	}


}
