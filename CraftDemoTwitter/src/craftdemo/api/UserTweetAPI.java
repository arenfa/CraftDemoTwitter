package craftdemo.api;

 
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import craftdemo.model.Tweet;
import craftdemo.model.UserFollow;
import craftdemo.model.UserTweet;
import craftdemo.model.UserTweets;
import craftdemo.model.Users;
import craftdemo.service.UserTweetService;

 
/**
 * @author arenfakhourian
 *
 */
@Path("/usertweet")
@Component
public class UserTweetAPI {
	
	private static final Logger log = LoggerFactory.getLogger(UserTweetAPI.class);
	
	@Autowired
	private UserTweetService userTweetService;
	
	@GET
	@Path("/feed")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	//@RolesAllowed("ROLE_USER")
	public UserTweets feed(@QueryParam("StartAtDate") String startAtDate) throws WebApplicationException {
		UserTweets userTweets = new UserTweets();
		
		try {
			List<UserTweet> userTweetList = userTweetService.getFeed();
			userTweets.getUserTweet().addAll(userTweetList);
		} catch (Exception e) {
			log.error("API error", e);
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
		
		return userTweets;
	}
	
	@POST
	@Path("/follow")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	//@RolesAllowed("ROLE_USER")
	public Response follow(UserFollow userFollow) throws WebApplicationException {
		try {
			if(userFollow.isFollow()) {
				userTweetService.follow(userFollow.getUsername());
			} else {
				userTweetService.unfollow(userFollow.getUsername());
			}
		} catch (Exception e) {
			log.error("API error", e);
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
		return Response.ok("{\"Success\" : \"Ok\"}").build();
	}

	@GET
	@Path("/followers")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Users getFollowers() throws WebApplicationException {
		return null;
	}

	@GET
	@Path("/following")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Users getFollowingUsers() throws WebApplicationException {
		return null;
	}
	

	@POST
	@Path("/tweet")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response tweet(Tweet tweet) throws WebApplicationException {
		try {
			userTweetService.tweet(tweet.getTweetMessage());
		} catch (Exception e) {
			log.error("API error", e);
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
		return Response.ok("{\"Success\" : \"Ok\"}").build();
	}
	

}
