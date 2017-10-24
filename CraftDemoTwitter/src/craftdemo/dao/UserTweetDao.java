package craftdemo.dao;

import java.util.List;

import craftdemo.model.User;
import craftdemo.model.UserTweet;

/**
 * @author arenfakhourian
 *
 */
public interface UserTweetDao {

	List<UserTweet> getFeed() throws Exception;
	void follow(String username) throws Exception;
	void unfollow(String username) throws Exception;
	List<User> getFollowers() throws Exception;
	List<User> getFollowingUsers() throws Exception;
	void tweet(String message) throws Exception;
}
