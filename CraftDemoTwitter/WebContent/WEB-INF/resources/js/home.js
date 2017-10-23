$( document ).ready(function() {
    console.log( "ready!" );
	// http://localhost:8080/CraftDemoTwitter/rest/usertweet/feed
	var PATH="rest/usertweet/";
	
	function getFeed(){
		  $.ajax({
			type: "GET",
			dataType: "json",
			cache: false,
			url: PATH + "feed",
			success: function(data) {
				$('#sub-container').empty();
				$.each(data.UserTweet, function(i, item) {
		    			$("#sub-container").append(createFeed(item.Username, item.TweetMessage));
				});
			}
		});
		//bindEvents(); 
	}
	
	function createFeed(username, message) {
		var result = '<p><label>' + username +'</label><br/>';
		result += '<label>' + message +'</label><br/></p>';
		return result;
	};
	
	function tweet(){
		$.ajax({
			type: "POST",
			cache: false,
			contentType:"application/json; charset=utf-8",
			dataType: "json",
			data: JSON.stringify({"TweetMessage":"heyyyyyyy"}),
			url: PATH + "tweet",
			success: function(data) {
			    
			}
		});	
	}
	
	
	
//	function bindEvents(){
//		$(document).off('click','.img-start');
//		$(document).on('click','.img-start', function(e){
//			 e.preventDefault();
//			 tweet();
//		});
//
//	}
		  

	getFeed();
	
});