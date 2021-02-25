$(document).ready(function() {

    $('#additem').click(function() {
        
    	var name = $("#name").val();
    	var type = $("#type").val();
    	var rate = $("#rate").val();
		var item = {
				"name":name,
				"type":type,
				"rate":rate
		};
		console.log(item);
		 $.ajax({
	    		type: "POST",
	    		contentType: "application/json",
	    		url: "http://localhost:8086/saveitem",
	    		dataType: "json",	
	    		data: JSON.stringify(item),	
	    		cache: false,
	    		//present the response in the html content dynamically 
	    		success: function(result){
	    				 
	    		},
	    		error: function(e){
	    			alert("Error!");
	    			console.log("ERROR: ", e);
	    	}
	    });
		
    });

});