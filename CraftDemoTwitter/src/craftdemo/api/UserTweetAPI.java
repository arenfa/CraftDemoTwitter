package craftdemo.api;

 
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import craftdemo.model.Tweet;
import craftdemo.model.User;
import craftdemo.model.UserFollow;
import craftdemo.model.UserTweet;
import craftdemo.model.UserTweets;
import craftdemo.model.Users;
import craftdemo.service.UserTweetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

 
/**
 * @author arenfakhourian
 *
 */
@Path("/home")
@Component
public class UserTweetAPI {
	
	private static final Logger log = LoggerFactory.getLogger(UserTweetAPI.class);
	
	@Autowired
	private UserTweetService userTweetService;
	
	@GET
	@Path("/feed")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public UserTweets feed() throws WebApplicationException {
		log.info("test");
		log.error("test error");
		UserTweets userTweets = new UserTweets();
		
		try {
			List<UserTweet> userTweetList = userTweetService.getFeed();
			userTweets.getUserTweet().addAll(userTweetList);
		} catch (Exception e) {
			// TODO log
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
		
		return userTweets;
	}
	
	@POST
	@Path("/follow")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response follow(UserFollow userFollow) throws WebApplicationException {
		try {
			userTweetService.follow(userFollow.getUserId());
		} catch (Exception e) {
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
		return Response.ok().build();
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
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
		return Response.ok().build();
	}
	
	@GET
	@Produces("application/xml")
	public String convertCtoF() {
 
		Double fahrenheit;
		Double celsius = 36.8;
		fahrenheit = ((celsius * 9) / 5) + 32;
 
		String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" + fahrenheit;
		return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>";
	}
 
	@Path("{c}")
	@GET
	@Produces("application/xml")
	public String convertCtoFfromInput(@PathParam("c") Double c) {
		Double fahrenheit;
		Double celsius = c;
		fahrenheit = ((celsius * 9) / 5) + 32;
 
		String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" + fahrenheit;
		return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>";
	}

}
