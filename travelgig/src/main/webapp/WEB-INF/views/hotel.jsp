<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page of Travel Gig</title>
<link href="css/jquery-ui.min.css" rel="stylesheet">
<script src="js/jquery-2.1.1.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/hotel.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery.dataTables.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- <link rel="stylesheet" type="text/css" href="home.css"> -->
<!-- <script>
	$(document).ready(function() {

	    $('#HistoryTable').DataTable( {
	        orderCellsTop: true,
	        fixedHeader: true,
	        paginate: true,
			"order": [[ 3 ]]
	    });

	});
</script> --> 
</head>
<body>



<div class="row" id='demo1Div'>
        <div class="col-6">
            <div class="container" style="margin-left: 100px">
                <h1>Welcome to Travel Gig</h1>
                <h2>Search your desired hotel</h2>
            </div>
        </div>
        <div class="col-6">
        	
            <div class="container" align="center" style="margin-left: 100px; margin-top: 50px">
                <c:choose>
        		<c:when test="${currentUser == 'anonymousUser'}">
        			<a href="login" class="btn btn-primary">Login</a> 
                	<a href="signupform" class="btn btn-primary">Create Account</a>
        		</c:when>
        		<c:otherwise>
        			Welcome <strong>${pageContext.request.userPrincipal.name}</strong>
        			<br/><a href="login?logout" class="btn btn-primary">Logout</a> 
        			<sec:authorize access="hasAuthority('admin')">
        			<a class="view-QA-admin btn btn-primary">Q&A</a> 
        			</sec:authorize>
        			<a class="book-history btn btn-primary">Booking History</a> 
        		</c:otherwise>
        	</c:choose>
            </div>
        </div>
    </div>


<div class="container border rounded" style="margin:auto;padding:50px;margin-top:50px;margin-bottom:50px">
	<h3>Narrow your search results</h3>
	<div class="form-row">
	<div class="col-3">
		Hotel/City/State/Address <input class="form-control" type="text" id="searchLocation" name="searchLocation"/>
	</div>
	<div class="col-2">
		No. Rooms: <input class="form-control" type="number" id="noRooms" name="noRooms"/>
	</div>
	<div class="col-2">
		No. Guests: <input class="form-control" type="number" id="noGuests" name="noGuests"/>
	</div>
	<div class="col">
	Check-In Date: <input type="date" id="checkInDate" name="checkInDate"/>
	</div>
	<div class="col">
	Check-Out Date: <input type="date" id="checkOutDate" name="checkOutDate"/>
	</div>
	<input class="btn-sm btn-primary sbtButton" type="button" id="searchBtn" value="SEARCH"/>
	</div>
</div>

<div class="row">
<div class="col-2 border rounded" style="margin-left:50px;padding:25px">
	
	<br>	
	<!--  Star Rating: 
	<select class="form-control" id="filter_starRating">
		<option value=0>Select</option>
		<option value=1>1</option>
		<option value=2>2</option>
		<option value=3>3</option>
		<option value=4>4</option>
		<option value=5>5</option>
	</select><br>--> 
	
	Star Rating:<br>
	<div class="form-check-inline">
		<label class="form-check-label">
			<input type="checkbox" class="star_rating form-check-input" id="1_star_rating" value=1>1
		</label>
	</div>
	<div class="form-check-inline">
		<label class="form-check-label">
			<input type="checkbox" class="star_rating form-check-input" id="2_star_rating" value=2>2		
		</label>
	</div>
	<div class="form-check-inline">
		<label class="form-check-label">
			<input type="checkbox" class="star_rating form-check-input" id="3_star_rating" value=3>3
		</label>
	</div>
	<div class="form-check-inline">
		<label class="form-check-label">
			<input type="checkbox" class="star_rating form-check-input" id="4_star_rating" value=4>4
		</label>
	</div>
	<div class="form-check-inline">
		<label class="form-check-label">
			<input type="checkbox" class="star_rating form-check-input" id="5_star_rating" value=5>5
		</label>
	</div><br><br>
	
	Range:
	<div class="slidecontainer">
  		<input type="range" min="1" max="500" value="500" class="slider" id="priceRange">
  		<p>Price: $<span id="priceValue"></span></p>
	</div>
	
	<div class="form-check">
		<input type="checkbox" class="hotel_amenity form-check-input" id="amenity_parking" value="PARKING"/>
		<label class="form-check-label" for="amenity_parking">Parking</label><br>
		
		<input type="checkbox" class="hotel_amenity form-check-input" id="amenity_checkin_checkout" value="CHECK-IN & CHECK-OUT TIMES"/>
		<label class="form-check-label" for="amenity_checkin_checkout">Check-In & Check-Out Times</label><br>
		
		<input type="checkbox" class="hotel_amenity form-check-input" id="amenity_breakfast" value="BREAKFAST"/>
		<label class="form-check-label" for="amenity_breakfast">Breakfast</label><br>
		
		<input type="checkbox" class="hotel_amenity form-check-input" id="amenity_bar_lounge" value="BAR OR LOUNGE"/>
		<label class="form-check-label" for="amenity_bar_lounge">Bar / Lounge</label><br>
		
		<input type="checkbox" class="hotel_amenity form-check-input" id="amenity_fitness_center" value="FITNESS CENTER"/>
		<label class="form-check-label" for="amenity_fitness_center">Fitness Center</label><br>
		
		<input type="checkbox" class="hotel_amenity form-check-input" id="amenity_pool" value="POOL"/>
		<label class="form-check-label" for="amenity_pool">Pool</label><br>
		
		<input type="checkbox" class="hotel_amenity form-check-input" id="amenity_restaurant" value="RESTAURANT"/>
		<label class="form-check-label" for="amenity_restaurant">Restaurant</label><br>
		
		<input type="checkbox" class="hotel_amenity form-check-input" id="amenity_spa" value="SPA"/>
		<label class="form-check-label" for="amenity_spa">Spa</label><br>
	</div>
	
	<input style="margin-top:25px" class="btn btn-primary" type="button" id="filterBtn" value="FILTER"/>	
</div>


<div class="col-8 border rounded" style="margin-left:50px;">
	<div style='text-align:center;font-size:20px;font-family:"Trebuchet MS", Helvetica, sans-serif'>List of Hotels:</div>	
	
	<div id="listHotel">
		<table id="hotelTable" class="table table-striped">
			<thead id="tablehead">
			<tr class="header">
				<th>Hotel Name</th>
				<th>Address</th>
				<th>Average Price</th>
				<th>Discount</th>
				<th>Rating</th>
				<th>Email</th>
				<th>Phone number</th>
				<th>Description</th>
				<th>Amenities</th>
				<th>Picture</th>
				<th>View</th>
				<th>Review</th>
			</tr>
			</thead>
			<tbody id="tablebody">
			</tbody>
		</table>
	</div>
	
</div>
</div>

<div class="modal" id="perTicketModal">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Search Hotel Rooms</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">        
        <div class="col">
        	<table id="roomTable" class="table table-striped">
        		<thead class="tablehead thead-dark">
					<tr class="header">
						<th>Room Id</th>
						<th>Area</th>
						<th>Price</th>
						<th>Discount</th>
						<th>Description</th>
						<th>Policy</th>
						<th>Total Room</th>
						<th>Room Image</th>
						<th>Room Type</th>
						<th>Amenities</th>
						<th>Book</th>
					</tr>
			</thead>
			<tbody id="roomtablebody">
			
			</tbody>
        	
        	</table>     	
        </div>
        
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>



<div class="modal" id="bookingHotelRoomModal">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title"></h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body" id="bookingRoom_modalBody">        
        	<div class="col">
       			<div><input class="form-control" type="hidden" id="booking_hotelId"/></div>
       			<div><input class="form-control" type="hidden" id="booking_hotelRoomId"/></div>
	        	<div>Hotel Name: <input readonly="true" class="form-control" type="text" id="booking_hotelName"/></div>
	        	<div>Customer Mobile: <input class="form-control" type="text" id="booking_customerMobile"/></div>
	        	<div>Email: <input class="form-control" type="text" id="booking_email"/></div>
       			<div id="noGuestsDiv">No. Guests: <input readonly="true" class="form-control booking-update " type="number" id="booking_noGuests"/></div>
       			<div>No. Rooms: <input readonly="true" class="form-control booking-update " type="number" id="booking_noRooms"/></div>
       			<div>Check-In Date: <input readonly="true" class="form-control booking-update " type="text" id="booking_checkInDate"/></div>
       			<div>Check-Out Date: <input readonly="true" class="form-control booking-update " type="text" id="booking_checkOutDate"/></div>
       			<div>Room Type: <input readonly="true" class="form-control" type="text" id="booking_roomType"/></div>
       			<div>Discount: $<span id="booking_discount"></span></div>
       			<div>Total Price: $<span id="booking_price"></span></div> 
       			<div><input class="form-control" type="hidden" id="booking_hotelRoomprice"/></div>      			
       			<div style='margin-top:20px'>
       				<button class='btn-confirm-booking btn btn-primary'>Continue Booking</button>
       			</div>
        	</div>          
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>

<div class="modal" id="GuestModal">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Guests</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body" id="guests_modalBody">        
              <table id="guestTable" class="table table-striped">
        		<thead class="tablehead thead-dark">
					<tr class="header">
						<th>First Name</th>
						<th>Last Name</th>
						<th>Age</th>
						<th>Gender</th>
					</tr>
				</thead>
				<tbody id="guesttablebody">
				
				</tbody>
        	
        	</table>
        	<div style='margin-top:20px'>
       				<button class='continue-booking btn btn-primary'>Continue Booking</button>
       		</div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
<div class="modal" id="hotelRoomsModal">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Are these details correct?</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body" id="hotelRooms_modalBody"> 
      		 <label>Hotel Name: </label>
      		 <div id="hotelname"></div> 
      		 
      		 <label>No. Rooms: </label>
      		 <div id="noRooms"></div>
      		 
      		 <label>Check-in: </label>
      		 <div id="checkin"></div>
      		 
      		 <label>Check-out: </label>
      		 <div id="checkout"></div>
      		 
      		 <label>Room Type: </label>
      		 <div id="roomtype"></div>
      		 
      		 <label>Mobile phone: </label>
      		 <div id="mobile"></div>
      		 
      		 <label>Discount: </label>
      		 <div id="discount"></div>
      		 
      		 <label>Price: </label>
      		 <div id="price"></div>
      		 
      		 <label>Guests: </label>
      		 <table id="guests">
      		 	<tbody id="guestinfos">
				
				</tbody>
      		 </table>
             <div style='margin-top:20px'>
       			<button class='booking-confirmed btn btn-primary'>Confirm Booking</button>
       		</div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>

<div class="modal" id="HistoryModal">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Search Hotel Rooms</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">        
        <div class="col">
        	<table id="HistoryTable" class="table table-striped">
        		<thead class="tablehead thead-dark">
					<tr class="historyheader">
						<th>Booking Id</th>
						<th>hotelName</th>
						<th>Hotel Room Id</th>
						<th>Username</th>
						<th>No. Rooms</th>
						<th>Room Type</th>
						<th>Check in Date</th>
						<th>Check Out Date</th>
						<th>Book Status</th>
						
					</tr>
			</thead>
			<tbody id="historytablebody">
			
			</tbody>
        	
        	</table>     	
        </div>
        
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="history-btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>

<div class="modal" id="ReviewModal">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title"></h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body" id="Review_modalBody">        
        	<div class="col">
        		<form id="reviewForm">
       			<div><input class="form-control" type="hidden" id="review_hotelId"/></div>
	     		
       			<div>Review Date: <input type="date" "form-control booking-update " type="text" id="review_Date"/></div>
       			
       			<div>
       				Room Rating:<br>
					<div class="form-check-inline">
						<label class="form-check-label">
							<input type="radio" name="room_rating" class="room_rating" id="1_star_rating" value=1> 1
						</label>
					</div>
					<div class="form-check-inline">
						<label class="form-check-label">
							<input type="radio" name="room_rating" class="room_rating" id="2_star_rating" value=2> 2		
						</label>
					</div>
					<div class="form-check-inline">
						<label class="form-check-label">
							<input type="radio" name="room_rating" class="room_rating" id="3_star_rating" value=3> 3
						</label>
					</div>
					<div class="form-check-inline">
						<label class="form-check-label">
							<input type="radio" name="room_rating" class="room_rating" id="4_star_rating" value=4> 4
						</label>
					</div>
					<div class="form-check-inline">
						<label class="form-check-label">
							<input type="radio" name="room_rating" class="room_rating" id="5_star_rating" value=5> 5
						</label>
					</div>
       			</div>
       			
       			<div>
       				Food Rating:<br>
					<div class="form-check-inline">
						<label class="form-check-label">
							<input type="radio" name="food_rating" class="food_rating form-check-input" id="1_star_rating" value=1>1
						</label>
					</div>
					<div class="form-check-inline">
						<label class="form-check-label">
							<input type="radio" name="food_rating" class="food_rating form-check-input" id="2_star_rating" value=2>2		
						</label>
					</div>
					<div class="form-check-inline">
						<label class="form-check-label">
							<input type="radio" name="food_rating" class="food_rating form-check-input" id="3_star_rating" value=3>3
						</label>
					</div>
					<div class="form-check-inline">
						<label class="form-check-label">
							<input type="radio" name="food_rating" class="food_rating form-check-input" id="4_star_rating" value=4>4
						</label>
					</div>
					<div class="form-check-inline">
						<label class="form-check-label">
							<input type="radio" name="food_rating" class="food_rating form-check-input" id="5_star_rating" value=5>5
						</label>
					</div>
       			</div>
       			
       			<div>
       				Cleanliness Rating:<br>
					<div class="form-check-inline">
						<label class="form-check-label">
							<input type="radio" name="cleaniness_rating" class="cleanliness_rating form-check-input" id="1_star_rating" value=1>1
						</label>
					</div>
					<div class="form-check-inline">
						<label class="form-check-label">
							<input type="radio" name="cleaniness_rating" class="cleanliness_rating form-check-input" id="2_star_rating" value=2>2		
						</label>
					</div>
					<div class="form-check-inline">
						<label class="form-check-label">
							<input type="radio" name="cleaniness_rating" class="cleanliness_rating form-check-input" id="3_star_rating" value=3>3
						</label>
					</div>
					<div class="form-check-inline">
						<label class="form-check-label">
							<input type="radio" name="cleaniness_rating" class="cleanliness_rating form-check-input" id="4_star_rating" value=4>4
						</label>
					</div>
					<div class="form-check-inline">
						<label class="form-check-label">
							<input type="radio" name="cleaniness_rating" class="cleanliness_rating form-check-input" id="5_star_rating" value=5>5
						</label>
					</div>
       			</div>
       			
       			<div>
       				Value Rating:<br>
					<div class="form-check-inline">
						<label class="form-check-label">
							<input type="radio" name="value_rating" class="value_rating form-check-input" id="1_star_rating" value=1>1
						</label>
					</div>
					<div class="form-check-inline">
						<label class="form-check-label">
							<input type="radio" name="value_rating" class="value_rating form-check-input" id="2_star_rating" value=2>2		
						</label>
					</div>
					<div class="form-check-inline">
						<label class="form-check-label">
							<input type="radio" name="value_rating" class="value_rating form-check-input" id="3_star_rating" value=3>3
						</label>
					</div>
					<div class="form-check-inline">
						<label class="form-check-label">
							<input type="radio" name="value_rating" class="value_rating form-check-input" id="4_star_rating" value=4>4
						</label>
					</div>
					<div class="form-check-inline">
						<label class="form-check-label">
							<input type="radio" name="value_rating" class="value_rating form-check-input" id="5_star_rating" value=5>5
						</label>
					</div>
       			</div>
       			
       			<div>
       				Service Rating:<br>
					<div class="form-check-inline">
						<label class="form-check-label">
							<input type="radio" name="service_rating" class="service_rating form-check-input" id="1_star_rating" value=1>1
						</label>
					</div>
					<div class="form-check-inline">
						<label class="form-check-label">
							<input type="radio" name="service_rating" class="service_rating form-check-input" id="2_star_rating" value=2>2		
						</label>
					</div>
					<div class="form-check-inline">
						<label class="form-check-label">
							<input type="radio" name="service_rating" class="service_rating form-check-input" id="3_star_rating" value=3>3
						</label>
					</div>
					<div class="form-check-inline">
						<label class="form-check-label">
							<input type="radio" name="service_rating" class="service_rating form-check-input" id="4_star_rating" value=4>4
						</label>
					</div>
					<div class="form-check-inline">
						<label class="form-check-label">
							<input type="radio" name="service_rating" class="service_rating form-check-input" id="5_star_rating" value=5>5
						</label>
					</div>
       			</div>
       			
       			<div>Description: <textarea id="descrip" rows="4" cols="10"></textarea></div>      			
       			<div style='margin-top:20px'>
       				<button class='btn-review btn btn-primary'>Submit</button>
       			</div>
       			</form>
        	</div>          
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="closeReview btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>

<div class="modal" id="ReviewsModal">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Search Hotel Rooms</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">        
        <div class="col">
        	<table id="reviewTable" class="table table-striped">
        		<thead class="reviewtablehead thead-dark">
					<tr class="header">
						<th>Hotel Name</th>
						<th>Avr. Rating</th>
						<th>description</th>
						
					</tr>
				</thead>
			<tbody id="reviewtablebody">
			
			</tbody>
        	
        	</table>     	
        </div>
        
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="history-btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>

<div class="modal" id="QAModal">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Search Hotel Rooms</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
       
        	
        		<div class="modal-body">        
		        <div id="QAbody" class="col">
		        	 	
		        </div>
		        
		        <div class="col-12">
					 <h6 class="modal-title">Ask a Question if the ones are not in the list</h6>
					<textarea class="form-control" rows="4" id="QA" name="QuestionAnswer"></textarea>
				</div>
		        <div style='margin-top:20px'>
		       		<button class='btn-user-QA btn btn-primary'>Submit</button>
		       	</div>
		      </div>
        		
        		
    <!--  <div class="modal-body">        
        <div id="QAbody" class="col">
        	 	
        </div>
        
        <div class="col-12">
			 <h6 class="modal-title">Ask a Question if the ones are not in the list</h6>
			<textarea class="form-control" rows="4" id="QA" name="QuestionAnswer"></textarea>
		</div>
        <div style='margin-top:20px'>
       		<button class='btn-QA btn btn-primary'>Submit</button>
       	</div>
      </div> -->
      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="QA-cancel-btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>


<div class="modal" id="AdminQAModal">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Search Hotel Rooms</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
       
        	
        		<div class="modal-body">        
		        <div id="adminQAbody" class="col">
		        	 	
		        </div>
		        
		       
        		
        		
    <!--  <div class="modal-body">        
        <div id="QAbody" class="col">
        	 	
        </div>
        
        <div class="col-12">
			 <h6 class="modal-title">Ask a Question if the ones are not in the list</h6>
			<textarea class="form-control" rows="4" id="QA" name="QuestionAnswer"></textarea>
		</div>
        <div style='margin-top:20px'>
       		<button class='btn-QA btn btn-primary'>Submit</button>
       	</div>
      </div> -->
      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="QA-cancel-btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>

<script>
var slider = document.getElementById("priceRange");
var output = document.getElementById("priceValue");
output.innerHTML = slider.value;
slider.oninput = function() {
	output.innerHTML = this.value;
}
</script>
</body>
</html>