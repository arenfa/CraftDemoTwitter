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
		bindEvents(); 
	}
	
	function createFeed(username, message) {
		var result = '<p><label>' + username +'</label><br/>';
		result += '<label>' + message +'</label><br/></p>';
		return result;
	};
	
	function tweet(){
		var data1 ='{"TweetMessage" :"'+$.trim($('#tweetarea').val())+'"}';

		$.ajax({
			type: "POST",
			cache: false,
			contentType:"application/json; charset=utf-8",
			dataType: "json",
			data: data1,
			url: PATH + "tweet",
			success: function(data) {
				$('#tweetarea').val('');
				//getFeed();
			}
		});	
	}
	
	function follow(){
		var data1 ='{"Username" :"'+$.trim($('#followbox').val())+'" ,"Follow" : true}';

		$.ajax({
			type: "POST",
			cache: false,
			contentType:"application/json; charset=utf-8",
			dataType: "json",
			data: data1,
			url: PATH + "follow",
			success: function(data) {
				$('#followbox').val('');
				//getFeed();
			}
		});	
	}
	
	function bindEvents(){
//		$(document).off('click','.postMessage');
//		$(document).on('click','.postMessage', function(e){
//			 e.preventDefault();
//			 tweet();
//		});
		
		$("#tweetForm").submit(function( event ) {
			  event.preventDefault();
			  tweet();
		});
		
		$(document).on('click','.followlink', function(e){
			 e.preventDefault();
			 follow();
		});

	}
		  

	getFeed();
	
});