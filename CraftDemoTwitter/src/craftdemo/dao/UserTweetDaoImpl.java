package craftdemo.dao;

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

	@Override
	public List<UserTweet> getFeed() throws Exception {
		// TODO Auto-generated method stub
		return null;
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
