package craftdemo.cassandra.model;



import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class FollowingFollow {

	@PrimaryKey
	private String followerUserId;
	private String followingUserId;

	/**
	 * @return the followingUserId
	 */
	public String getFollowingUserId() {
		return followingUserId;
	}
	/**
	 * @param followingUserId the followingUserId to set
	 */
	public void setFollowingUserId(String followingUserId) {
		this.followingUserId = followingUserId;
	}
	/**
	 * @return the followerUserId
	 */
	public String getFollowerUserId() {
		return followerUserId;
	}
	/**
	 * @param followerUserId the followerUserId to set
	 */
	public void setFollowerUserId(String followerUserId) {
		this.followerUserId = followerUserId;
	}


	

}
