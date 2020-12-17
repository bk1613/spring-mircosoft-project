$(document).ready(function() {

	$("#searchBtn").click(function() {
		$("tr").not(".header").remove();
//		var hotelName = $("#searchLocation").val();
//		var hotelDetails = {
//				"hotelName":hotelName
//		};
		var hotelSearch = $("#searchLocation").val();
		var hotelDetails = {
				"searchHotel":hotelSearch
		};

	    $.ajax({
	    		type: "POST",
	    		contentType: "application/json",
	    		url: "http://localhost:8282/gethotel",
	    		dataType: "json",	
	    		data: JSON.stringify(hotelDetails),	
	    		cache: false,
	    		//present the response in the html content dynamically 
	    		success: function(result){
	    		var hotelArr = new Array();
	    		var count =0;
	    		$.each(result.listHotel, function(key,value) {	
	    			
	    			var amenities = [...value.amenities].map(a=>a.name).join(", ");
	    			$("#tablebody").append("<tr>"+
	    			"<td>"+value.hotelName+"(<a href='#' class='view-QA' data-hotelId='"+ value.hotelId +"'>QA</a>)</td>"+
					"<td>"+value.address+ " " + value.city + ", " + value.state +"</td>"+
					"<td>"+value.averagePrice+"</td>"+
					"<td>"+value.discount+"</td>"+
					"<td>"+value.starRating+"</td>"+
					"<td>"+value.email+"</td>"+
					"<td>"+value.mobile+"</td>"+
					"<td>"+value.description+"</td>"+
					"<td>"+amenities+"</td>"+
					"<td><img style='width:200px; height:200px;' src='"+value.imageURL+"'/></td>"+
					"<td><a href='#' class='view-hotel' data-hotelId='"+ value.hotelId +"' data-hotelname='"+ value.hotelName +"'>View</a></td>" +
					"<td><a href='#' class='show-review' data-hotelId='"+ value.hotelId +"' data-hotelname='"+ value.hotelName +"'>Reviews</a> </td>"+
					"</tr>");
					count+=1;
		    		});
	    				 
	    		},
	    		error: function(e){
	    			alert("Error!");
	    			console.log("ERROR: ", e);
	    	}
	    });
	       

	});
	
	$("#filterBtn").click(function() {
		$("#tablebody").children("tr").show();
		var selectedRatings = $(".star_rating:checked");
		var star = selectedRatings.length>0?true:false;
		
		var selectedprice = parseFloat($("#priceValue").text());
		
//		var amenties = $("input[type='checkbox']:checked");
		var selectedamenties = $(".hotel_amenity:checked");
		var checkedAmen = selectedamenties.length>0?true:false;
		
		
		$.each($("#tablebody").children("tr"),function(){
			//Rating
			
			var hotelStar = $(this).children("td").eq(4).text();

			var starFlag = 0;
			$.each(selectedRatings, function(){
				var selectedRating;
				
				if($(this).prop("checked")){
					selectedRating= $(this).val();
				}
				
				if(hotelStar == selectedRating){
					starFlag = 1;
				}
			
			})
		
			var amenty = $(this).children("td").eq(8).text();
			
			
			
			var amenFlag = 0;
			$.each(selectedamenties, function(){
				var amen;
				if($(this).prop("checked")){
					amen = $(this).val().toLowerCase();
				}
				
				if(amenty.includes(amen)){
					amenFlag = 1;
				}
				
				
			})
		
			//Price
			var hotelprice = parseFloat($(this).children("td").eq(2).text());

			if((starFlag==0 && star>0) || hotelprice > selectedprice || (amenFlag==0 && checkedAmen >0)){
				$(this).hide();
			}
			
			
			
		})
		
		
		
	});	
});	


$(document).on('click', '.view-hotel', function(){
	$("#roomtablebody").children().remove();
	var roomSearch = $(this).attr("data-hotelId");
	var hotelname = $(this).attr("data-hotelname");
	
	
	var checkinDate = new Date($("#checkInDate").val());
	   checkinDate = checkinDate.getFullYear()+'-'+(checkinDate.getMonth()+1)+'-'+checkinDate.getDate();
	   var checkoutDate = new Date($("#checkOutDate").val());
	   checkoutDate = checkoutDate.getFullYear()+'-'+(checkoutDate.getMonth()+1)+'-'+checkoutDate.getDate();
	    	  
	   
	
	var roomDetails = {
			"checkInDate":checkinDate,
			"hotelId":roomSearch
	};
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "http://localhost:8282/getroom",
		dataType: "json",	
		data: JSON.stringify(roomDetails),	
		cache: false,
		success: function(result){
			var hotelroom = new Array();
			$.each(result.listHotelRoom, function(key,value){
				var amenities = [...value.amenities].map(a=>a.name).join(", ");
				$("#roomtablebody").append("<tr>"+
				"<td>"+value.roomId+"</td>"+
				"<td>"+value.area +"</td>"+
				"<td>"+value.price+"</td>"+
				"<td>"+value.discount+"</td>"+
				"<td>"+value.description+"</td>"+
				"<td>"+value.policy+"</td>"+
				"<td>"+value.totalroom+"</td>"+
				"<td><img style='width:200px; height:200px;' src='"+value.roomImage+"'/></td>"+
				"<td>"+value.type.name+"</td>"+
				"<td>"+amenities+"</td>"+
				"<td><a href='#' class='view-hotelroom' data-hotelId='"+ roomSearch +"' data-roomId='"+ value.roomId +"' data-roomtype='"+ value.type.name +
				"' data-hotelname='"+ hotelname +"' data-roomprice='"+ value.price +"' data-roomdiscount='"+ value.discount +"'>Book</a></td>"+
				"</tr>");
			});
			 
		},
		error: function(e){
			alert("Error!");
		console.log("ERROR: ", e);
	}
  });
	
	  
	 $("#perTicketModal").modal('toggle');
	
})

var bookingDetails = {
			
};
	

$(document).on('click', '.view-hotelroom', function(){
	
	console.log("confirm")
	$.ajax({
        type:"GET",
        contentType:"application/json",
        url:"validateBooking",
        cache:false,
        success: function(result){
        },
        error: function (error) {
           if (error.status==401){
               window.location.href="login";
           } 
        }
    })
	
	var today = new Date();
	var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
	
	var noRooms = $("#noRooms").val();
	var noGuests = $("#noGuests").val();
	var checkinDate = new Date($("#checkInDate").val());
	var checkoutDate = new Date($("#checkOutDate").val());
	var differenceofdate = (checkoutDate.getTime() - checkinDate.getTime())/(1000 * 3600 * 24);
	
	checkinDate = checkinDate.getFullYear()+'-'+(checkinDate.getMonth()+1)+'-'+checkinDate.getDate();
	checkoutDate = checkoutDate.getFullYear()+'-'+(checkoutDate.getMonth()+1)+'-'+checkoutDate.getDate();
	
	console.log(checkinDate + " " + checkoutDate);
	var hotelid = $(this).attr("data-hotelId");
	var roomid = $(this).attr("data-roomId");
	var roomtype = $(this).attr("data-roomtype");
	var name = $(this).attr("data-hotelname");
	var price = $(this).attr("data-roomprice");
	var discount = $(this).attr("data-roomdiscount");
	
////	alert(id+" "+noRooms + " " + noGuests + " " + differenceofdate);
//	})
	$("#booking_hotelId").val(hotelid);
	$("#booking_hotelRoomId").val(roomid);
	$("#booking_hotelName").val(name);
	$("#booking_noGuests").val(noGuests);
	$("#booking_noRooms").val(noRooms);
	$("#booking_checkInDate").val(checkinDate);
	$("#booking_checkOutDate").val(checkoutDate);
	$("#booking_roomType").val(roomtype);
	$("#booking_discount").text(discount);
	$("#booking_price").text((price * noRooms * noGuests * differenceofdate));
	$("#booking_hotelRoomprice").val(price);
	//
	$("#bookingHotelRoomModal").modal('toggle');
	
	bookingDetails["hotelId"] = hotelid;
	bookingDetails["hotelRoomId"] = roomid;
	bookingDetails["checkInDate"] = checkinDate;
	bookingDetails["checkOutDate"] = checkoutDate;
	bookingDetails["price"] = price;
	bookingDetails["discount"] = discount;
	
	bookingDetails["roomType"] = roomtype;
	bookingDetails["bookedOnDate"] = date;
	bookingDetails["noRooms"] = noRooms;
	bookingDetails["NoGuests"] = noGuests;
	bookingDetails["hotelname"] = name;
	
	
	$(".booking-update").blur(function(){
		
		var norooms = $("#booking_noRooms").val();
		var guestrooms = $("#booking_noGuests").val();
		var checkin = new Date($("#booking_checkInDate").val());
		var checkout = new Date($("#booking_checkOutDate").val());
		
		var nodays = (checkout.getTime() - checkin.getTime())/(1000 * 3600 * 24);
		
		bookingDetails["checkInDate"] = checkin.getFullYear()+'-'+(checkin.getMonth()+1)+'-'+checkin.getDate();
		bookingDetails["checkOutDate"] = checkout.getFullYear()+'-'+(checkout.getMonth()+1)+'-'+checkout.getDate();
		
		var price = $("#booking_hotelRoomprice").val();
		$("#booking_price").text((nodays * price * norooms * guestrooms));
	})
	
})

$(document).on('click', '.btn-confirm-booking', function(){
	$("#guesttablebody").children().remove();
	bookingDetails["customerMobile"] = $("#booking_customerMobile").val();
	bookingDetails["email"] = $("#booking_email").val();
	
	console.log(bookingDetails);
	
	for(var i = 0; i < bookingDetails["NoGuests"]; i++){
		$("#guesttablebody").append("<tr>"+
				"<td><input type='text' name='firstName' value=''></td>"+
				"<td><input type='text' name='lastName' value=''></td>"+
				"<td><input type='text' name='age' value=''></td>"+
				"<td><input type='text' name='gender' value=''></td>"+
				"</tr>");
	}
	
	$("#GuestModal").modal('toggle');
})


$(document).on('click', '.continue-booking', function(){
	var allGuestinfo = []
	$.each($("#guesttablebody").children("tr"), function(){
		var guestInfo = {};
		$(this).find("input").each(function(){
			guestInfo[$(this).attr('name')] = $(this).val();
		})
		
		allGuestinfo.push(guestInfo);
	})
	bookingDetails["guests"] = allGuestinfo;

	
	
	$("#hotelname").replaceWith( bookingDetails["hotelname"]+"<br/>" );
	$("#noRooms").replaceWith(bookingDetails["noRooms"]+"<br/>");
	$("#checkin").replaceWith(bookingDetails["checkInDate"]+"<br/>");
	$("#checkout").replaceWith(bookingDetails["checkOutDate"]+"<br/>");
	$("#roomtype").replaceWith(bookingDetails["roomType"]+"<br/>");
	$("#moblie").replaceWith(bookingDetails["customerMobile"]+"<br/>");
	$("#discount").replaceWith(bookingDetails["discount"]+"<br/>");
	$("#price").replaceWith(bookingDetails["price"]+"<br/>");
	
	
	
	$("#GuestModal").modal('toggle');
	$("#bookingHotelRoomModal").modal('toggle');
	$("#hotelRoomsModal").modal('toggle');
})

$(document).on('click', '.booking-confirmed', function(){

	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "http://localhost:8282/savebooking",
		dataType: "json",	
		data: JSON.stringify(bookingDetails),	
		cache: false,
		success: function(result){
			console.log(result.HotelRoom)
			window.location.href="/";
		},
		error: function(e){
			alert("Error!");
		console.log("ERROR: ", e);
		}
	});
});

$(document).on('click', '.book-history', function(){
	$("#historytablebody").children().remove();
	
	$.ajax({
        type:"GET",
        contentType:"application/json",
        url:"getBooking",
        dataType: "json",
        cache:false,
        success: function(result){
        	$.each(result.listofbooks, function(key,value){// when not usng datatype
        		var status = "";
        		var today = new Date();
        		var todaydate = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
        		var checkinDate = value.checkInDate;
        		if(value.status=="canceled"){
        			status = "<td>Canceled</td>";
        		}else if(checkinDate < todaydate){
        			status = "<td>Completed (<a href='#' class='review-hotel' data-hotelId='"+ value.hotelId +"'>Review</a>) </td>";
        		}else{
        			status = "<td>Reserved(<a href='#' class='cancel-booking' data-bookingid='"+value.bookingId+"' data-hotelName='"+value.hotelName+"'> Cancel</a>)</td>";
        		}
        		$("#historytablebody").append("<tr>"+
    					"<td>"+value.bookingId+"</td>"+
    					"<td>"+value.hotelName+"</td>"+
    					"<td>"+value.hotelRoomId+"</td>"+
    					"<td>"+value.userName+"</td>"+
    					"<td>"+value.noRooms+"</td>"+
    					"<td>"+value.roomType+"</td>"+
    					"<td>"+value.checkInDate+"</td>"+
    					"<td>"+value.checkOutDate+"</td>"+
    					status+
    					"</tr>"
    			);
    		});
        	
        	
        },
        error: function (error) {
          
        }
    })
	
	
	$("#HistoryModal").modal('toggle');
});


$(document).on('click', '.cancel-booking', function(){
	
	console.log($(this).attr("data-bookingId"))
	
	var currentBookingRow = $(this).parent().parent();
	var bookingUpdateDetail = {
	         
	         "bookingId":$(this).attr("data-bookingId"),
	         "status":"canceled",
	         "hotelName": $(this).attr("data-hotelName")
	}
	
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "updateBookingStatus",
        dataType: "json",
        data: JSON.stringify(bookingUpdateDetail),
        cache: false,
        success: function(result){
               var value =  result.bookingupdated;
              $(currentBookingRow).children("td").eq("8").text("Canceled");
        },
        error: function (error) {
           alert("Error at findBooking API call");
           console.log("Error:" + error)
        }
    })
	return false;
})

$(document).on('click', '.review-hotel', function(){
	$("#ReviewModal").modal('toggle');
	var hotelid = $(this).attr("data-hotelId");
	$("#review_hotelId").val(hotelid);
})

$(document).on('click', '.btn-review', function(){
	
	reviewdetail = {
			"hotelId": $("#review_hotelId").val(),
			"reviewDate": $("#review_Date").val(),
			"roomRating": $(".room_rating:checked").val(),
			"foodRating": $(".food_rating:checked").val(),
			"cleanlinessRating": $(".cleanliness_rating:checked").val(),
			"valueRating": $(".value_rating:checked").val(),
			"serviceRating": $(".service_rating:checked").val(),
			"description": $("#descrip").val()
	}
	
	$.ajax({
        type: "POST",
        contentType: "application/json",
        url: "reviewHotel",
        dataType: "json",
        data: JSON.stringify(reviewdetail),
        cache: false,
        success: function(result){
        	$("#ReviewModal").modal('toggle');
        	$("#reviewForm").trigger("reset");
        },
        error: function (error) {
           alert("Error at findBooking API call");
           console.log("Error:" + error)
        }
    })
    
   
})

$(document).on('click', '.show-review', function(){
	$("#reviewtablebody").children().remove();
	$("#ReviewsModal").modal('toggle');
	
	var hotelid = $(this).attr("data-hotelId");
	var name = $(this).attr("data-hotelname")
	reviewdetail = {
			"hotelId":$(this).attr("data-hotelId"),
	}
	
	$.ajax({
        type: "POST",
        contentType: "application/json",
        url: "getHotelreview",
        dataType: "json",
        data: JSON.stringify(reviewdetail),
        cache: false,
        success: function(result){
        	$.each(result.listofreviews, function(key,value) {	
    			$("#reviewtablebody").append("<tr>"+
				"<td>"+name+"</td>"+
				"<td>"+((value.roomRating + value.foodRating + value.cleanlinessRating + value.valueRating + value.serviceRating)/5)+"</td>"+
				"<td>"+value.description+"</td>"+
				"</tr>");
	    		});
        },
        error: function (error) {
           alert("Error at findBooking API call");
           console.log("Error:" + error)
        }
    })
})

$(document).on('click', '.closeReview', function() {
            $("#reviewForm").trigger("reset");
})

var hotelId;

$(document).on('click', '.view-QA', function(){
	$("#QAbody").children().remove();
	hotelId= $(this).attr("data-hotelId");
	var hotelidtoQA = {
			"hotelid": hotelId
	}
	
	$.ajax({
        type: "POST",
        contentType: "application/json",
        url: "getuserQAs",
        dataType: "json",
        data: JSON.stringify(hotelidtoQA),
        cache: false,
        success: function(result){
        	console.log(result);
        	$.each(result.listuserQA, function(key,value) {	
        		
    			$("#QAbody").append(
				"<div>"+value.question+"?</div>"+
				"<div>"+value.answer+"</div>"+
				"<br/>"
	    		);
        	})
        },
        error: function (error) {
           alert("Error at findBooking API call");
           console.log("Error:" + error)
        }
    })
    $("#QAModal").modal('toggle');
})

$(document).on('click', '.view-QA-admin', function(){
	$("#adminQAbody").children().remove();
//	hotelId= $(this).attr("data-hotelId");
//	var hotelidtoQA = {
//			"hotelid": hotelId
//	}
	
	$.ajax({
        type: "GET",
        contentType: "application/json",
        url: "getadminQAs",
        dataType: "json",
       
        cache: false,
        success: function(result){
        	console.log(result);
        	$.each(result.listadminQA, function(key,value) {	
        		
    			$("#adminQAbody").append(
    			"<div><input class='form-control' type='hidden' id='quesansid' value='"+value.qaId+"'/></div>"+
    			"<div><input class='form-control' type='hidden' id='hoteldataid' value='"+value.hotelid+"'/></div>"+
    			"<div><input class='form-control' type='hidden' id='question' value='"+value.question+"'/></div>"+
				"<div>"+value.question+"?</div>"+
				"<div class='col-12'>"+
				"<div><textarea class='form-control' rows='4' id='ansQA' name='QuestionAnswer'></textarea></div>"+
				"</div>"+
		        "<div style='margin-top:20px'>"+
		       		"<button class='btn-admin-QA btn btn-primary'>Submit</button>"+
		       	"</div>"+
				"<br/>"
	    		);
        	})
        },
        error: function (error) {
           alert("Error at findBooking API call");
           console.log("Error:" + error)
        }
    })
    $("#AdminQAModal").modal('toggle');
})

$(document).on('click', '.btn-user-QA', function() {
	
	
	QAdetail = {
		"hotelid": hotelId,
		"question": $("#QA").val()
	};
	
	$.ajax({
        type: "POST",
        contentType: "application/json",
        url: "saveQA",
        dataType: "json",
        data: JSON.stringify(QAdetail),
        cache: false,
        success: function(result){
        	console.log(result);
        	window.location.href="/";
//        	$.each(result.listQA, function(key,value) {	
//    			$("#QAbody").append(
//				"<div>"+value.question+"?</div>"+
//				"<div>"+value.answer+"</div>"+
//				"<br/>"
//	    		);
//        	})
        },
        error: function (error) {
           alert("Error at findBooking API call");
           console.log("Error:" + error)
        }
    })
	
})

$(document).on('click', '.btn-admin-QA', function() {
	
	
	QAdetail = {
		"qaId": $("#quesansid").val(),
		"question": $("#question").val(),
		"answer": $("#ansQA").val(),
		"hotelid": $("#hoteldataid").val()
	};
	
	$.ajax({
        type: "POST",
        contentType: "application/json",
        url: "saveQA",
        dataType: "json",
        data: JSON.stringify(QAdetail),
        cache: false,
        success: function(result){
        	console.log(result);
//        	$.each(result.listQA, function(key,value) {	
//    			$("#QAbody").append(
//				"<div>"+value.question+"?</div>"+
//				"<div>"+value.answer+"</div>"+
//				"<br/>"
//	    		);
//        	})
        	window.location.href="/";
        },
        error: function (error) {
           alert("Error at findBooking API call");
           console.log("Error:" + error)
        }
    })
	
})

/*
 * "<td>"+value.hotelName+"(<a href='#' class='view-QA' data-hotelId='"+ value.hotelId +"'>QA</a>)"+"</td>"+
 * var hotelId;
$(document).on('click', '.view-QA', function(){
	$("#QAbody").children().remove();
	hotelId= $(this).attr("data-hotelId");
	var hotelidtoQA = {
			"hotelid": hotelId
	}
	
	$.ajax({
        type: "POST",
        contentType: "application/json",
        url: "getQAs",
        dataType: "json",
        data: JSON.stringify(hotelidtoQA),
        cache: false,
        success: function(result){
        	console.log(result);
        	$.each(result.listQA, function(key,value) {	
        		
    			$("#QAbody").append(
				"<div>"+value.question+"?</div>"+
				"<div>"+value.answer+"</div>"+
				"<br/>"
	    		);
        	})
        },
        error: function (error) {
           alert("Error at findBooking API call");
           console.log("Error:" + error)
        }
    })
    $("#QAModal").modal('toggle');
})

$(document).on('click', '.btn-QA', function() {
	
	alert($("#QA").val());
	QAdetail = {
		"hotelid": hotelId,
		"question": $("#QA").val()
	};
	
	$.ajax({
        type: "POST",
        contentType: "application/json",
        url: "saveQA",
        dataType: "json",
        data: JSON.stringify(QAdetail),
        cache: false,
        success: function(result){
        	console.log(result);
//        	$.each(result.listQA, function(key,value) {	
//    			$("#QAbody").append(
//				"<div>"+value.question+"?</div>"+
//				"<div>"+value.answer+"</div>"+
//				"<br/>"
//	    		);
//        	})
        },
        error: function (error) {
           alert("Error at findBooking API call");
           console.log("Error:" + error)
        }
    })
	
})*/
