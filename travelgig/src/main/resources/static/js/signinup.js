$(document).ready(function() {
	
//	$("#loginBtn").click(function() {
//		var user = $("#username").val();
//		var password = $("#password").val();
//		alert(user + password);
//		
//		var login = {
//				"username": user,
//				"password": password
//		}
		
		console.log("confirm")
//		$.ajax({
//        type:"GET",
//        contentType:"application/json",
//        url:"login",
//        dataType: "json",	
//		data: JSON.stringify(login),
//        cache:false,
//        success: function(result){
//        },
//        error: function (error) {
//           
//        }
//    })
//	})
	
	$("#signBtn").click(function() {
		
		var user = $("#username").val();
		var password = $("#password").val();
		var email = $("#email").val();
		
		var signin = {
				"username": user,
				"password": password,
				"email": email
		}
		
		console.log("confirm")
		$.ajax({
	        type:"POST",
	        contentType:"application/json",
	        url:"saveuser",
	        dataType: "json",	
			data: JSON.stringify(signin),
	        cache:false,
	        success: function(result){
	        	window.location.href="login";
	        },
	        error: function (error) {
	        }
	    })
	})
	
	
})