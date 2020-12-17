package com.synex.restclient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class HotelRestClient {
	final String uri = "http://localhost:8383";
	final String uri2 = "http://localhost:8484";
	public JSONObject getHotel(JSONObject jsonObject) throws JSONException, JsonProcessingException{
		
		System.out.println("Hotel Name received ............."+ jsonObject.get("searchHotel").toString());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<String>(jsonObject.toString(), headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object[]> responseEntity = restTemplate.postForEntity(uri+"/getHotelBySearch", request, Object[].class);
		
		Object[] listHotelObject = responseEntity.getBody();
		
		JSONArray jsonArray = new JSONArray();
		
		for(Object obj : listHotelObject){
			ObjectMapper mapper = new ObjectMapper(); 
			JSONObject jsonObj = new JSONObject(mapper.writeValueAsString(obj));
			jsonArray.put(jsonObj);
		}
		
		JSONObject jsonResponseObject = new JSONObject();
		jsonResponseObject.put("listHotel", jsonArray);
		
		return jsonResponseObject;
	}
	
	public JSONObject getHotelRoom(JSONObject jsonObject) throws JSONException, JsonProcessingException{
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<String>(jsonObject.toString(), headers);
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Object[]> responseEntity = restTemplate.postForEntity(uri2+"/bookGuest", request, Object[].class);

		Object[] listocuppiedroomsObject = responseEntity.getBody();
		
		JSONArray jsonArray = new JSONArray();
		
		for(Object obj : listocuppiedroomsObject){
			ObjectMapper mapper = new ObjectMapper(); 
			JSONObject jsonObj = new JSONObject(mapper.writeValueAsString(obj));
			jsonArray.put(jsonObj);
		}

		HttpEntity<String> request1 = new HttpEntity<String>(jsonArray.toString(), headers);
		JSONObject jsa = new JSONObject();
		jsa.put("req1", request.getBody());
		jsa.put("req2", request1.getBody());
		
		ResponseEntity<Object[]> responseEntity1 = restTemplate.postForEntity(uri+"/getHotelRoomsById", jsa.toString(), Object[].class);
		
		Object[] listhotelroomsObject = responseEntity1.getBody();
		
		JSONArray jsonHotelroomArray = new JSONArray();
		
		for(Object obj : listhotelroomsObject){
			ObjectMapper mapper = new ObjectMapper(); 
			JSONObject jsonObj = new JSONObject(mapper.writeValueAsString(obj));
			jsonHotelroomArray.put(jsonObj);
		}
		
		JSONObject jsonResponseObject = new JSONObject();
		jsonResponseObject.put("listHotelRoom", jsonHotelroomArray);
	
		System.out.println("list of hotel room: "+jsonResponseObject);
		
		return jsonResponseObject;
	}
	
	public JSONObject bookHotelRoom(JSONObject jsonObject) throws JSONException, JsonProcessingException{
		
		System.out.println("Hotel Name received ............."+ jsonObject.get("userName").toString());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<String>(jsonObject.toString(), headers);
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Object> responseEntity = restTemplate.postForEntity(uri2+"/bookhotel", request, Object.class);
		
		Object roomObject = responseEntity.getBody();

//		for(Object obj : listHotelObject){
//			ObjectMapper mapper = new ObjectMapper(); 
//			JSONObject jsonObj = new JSONObject(mapper.writeValueAsString(obj));
//			jsonArray.put(jsonObj);
//		}
		
		JSONObject jsonResponseObject = new JSONObject();
		jsonResponseObject.put("HotelRoom", roomObject);
	
		System.out.println(jsonResponseObject);
		
		return jsonResponseObject;
	}
	
	public JSONObject checkBook(JSONObject jsonObject) throws JSONException, JsonProcessingException{
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<String>(jsonObject.toString(), headers);
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Object[]> responseEntity = restTemplate.postForEntity(uri2+"/bookGuest", request, Object[].class);
		
		Object[] listHotelObject = responseEntity.getBody();
		
		JSONArray jsonArray = new JSONArray();
		
		for(Object obj : listHotelObject){
			ObjectMapper mapper = new ObjectMapper(); 
			JSONObject jsonObj = new JSONObject(mapper.writeValueAsString(obj));
			jsonArray.put(jsonObj);
		}
		
		ResponseEntity<Object> responseEntity1 = null;
		for(var ja: jsonArray) {
			HttpEntity<String> request1 = new HttpEntity<String>(ja.toString(), headers);
			responseEntity1 = restTemplate.postForEntity(uri+"/changeAvailableRooms", request1, Object.class);
		}
		
		JSONObject jsonResponseObject = new JSONObject();
		jsonResponseObject.put("Occupiedrooms", jsonArray);
	
		
		System.out.println("list of hotel room: "+jsonResponseObject);
		
		return jsonResponseObject;
	}
	
	public JSONObject getBook(JSONObject jsonObject) throws JSONException, JsonProcessingException{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<String>(jsonObject.toString(), headers);
		RestTemplate restTemplate = new RestTemplate();
	
		ResponseEntity<Object[]> responseEntity = restTemplate.postForEntity(uri2+"/booklist", request, Object[].class);
		
		Object[] listbookObject = responseEntity.getBody();
		
		JSONArray jsonArray = new JSONArray();
		
		for(Object obj : listbookObject){
			ObjectMapper mapper = new ObjectMapper(); 
			JSONObject jsonObj = new JSONObject(mapper.writeValueAsString(obj));
			jsonArray.put(jsonObj);
		}
		
		JSONObject jsonResponseObject = new JSONObject();
		jsonResponseObject.put("listofbooks", jsonArray);
		
		return jsonResponseObject;
		
	}
	
	public JSONObject updateBooking(JSONObject jsonObject) throws JSONException, JsonProcessingException{
		
		System.out.println("Hotel Name received ............."+ jsonObject.get("userName").toString());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<String>(jsonObject.toString(), headers);
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Object> responseEntity = restTemplate.postForEntity(uri2+"/updatebook", request, Object.class);
		
		Object roomObject = responseEntity.getBody();

//		for(Object obj : listHotelObject){
//			ObjectMapper mapper = new ObjectMapper(); 
//			JSONObject jsonObj = new JSONObject(mapper.writeValueAsString(obj));
//			jsonArray.put(jsonObj);
//		}
		
		JSONObject jsonResponseObject = new JSONObject();
		jsonResponseObject.put("bookingupdated", roomObject);
	
		System.out.println(jsonResponseObject);
		
		return jsonResponseObject;
	}
	
	public JSONObject reviewHotel(JSONObject jsonObject) throws JSONException, JsonProcessingException{
		
		System.out.println("Hotel Name received ............."+ jsonObject.get("roomRating").toString());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<String>(jsonObject.toString(), headers);
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Object> responseEntity = restTemplate.postForEntity(uri+"/ReviewHotel", request, Object.class);
		
		Object roomObject = responseEntity.getBody();

		
		JSONObject jsonResponseObject = new JSONObject();
		jsonResponseObject.put("hotelReviewed", roomObject);
	
		System.out.println(jsonResponseObject);
		
		return jsonResponseObject;
	}
	
	public JSONObject getHotelReview(JSONObject jsonObject) throws JSONException, JsonProcessingException{
		System.out.println("getreview");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<String>(jsonObject.toString(), headers);
		RestTemplate restTemplate = new RestTemplate();
	
		ResponseEntity<Object[]> responseEntity = restTemplate.postForEntity(uri+"/getHotelReview", request, Object[].class);
		
		Object[] listreviewObject = responseEntity.getBody();
		
		JSONArray jsonArray = new JSONArray();
		
		for(Object obj : listreviewObject){
			ObjectMapper mapper = new ObjectMapper(); 
			JSONObject jsonObj = new JSONObject(mapper.writeValueAsString(obj));
			jsonArray.put(jsonObj);
		}
		
		JSONObject jsonResponseObject = new JSONObject();
		jsonResponseObject.put("listofreviews", jsonArray);
		
		return jsonResponseObject;
		
	}
	
	public JSONObject getuserlistQA(JSONObject jsonObject) throws JSONException, JsonProcessingException{
		
		System.out.println("Hotel Name received ............."+ jsonObject.get("hotelid").toString());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<String>(jsonObject.toString(), headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object[]> responseEntity = restTemplate.postForEntity(uri+"/getuserlistQA", request, Object[].class);
		
		Object[] listQAObject = responseEntity.getBody();
		
		JSONArray jsonArray = new JSONArray();
		
		for(Object obj : listQAObject){
			ObjectMapper mapper = new ObjectMapper(); 
			JSONObject jsonObj = new JSONObject(mapper.writeValueAsString(obj));
			jsonArray.put(jsonObj);
		}
		
		JSONObject jsonResponseObject = new JSONObject();
		jsonResponseObject.put("listuserQA", jsonArray);
		
		return jsonResponseObject;
	}
	
public JSONObject getadminlistQA(JSONObject jsonObject) throws JSONException, JsonProcessingException{
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<String>(jsonObject.toString(), headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object[]> responseEntity = restTemplate.postForEntity(uri+"/getadminlistQA", request, Object[].class);
		
		Object[] listQAObject = responseEntity.getBody();
		
		JSONArray jsonArray = new JSONArray();
		
		for(Object obj : listQAObject){
			ObjectMapper mapper = new ObjectMapper(); 
			JSONObject jsonObj = new JSONObject(mapper.writeValueAsString(obj));
			jsonArray.put(jsonObj);
		}
		
		JSONObject jsonResponseObject = new JSONObject();
		jsonResponseObject.put("listadminQA", jsonArray);
		
		return jsonResponseObject;
	}
	
	public JSONObject saveQues(JSONObject jsonObject) throws JSONException, JsonProcessingException{
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<String>(jsonObject.toString(), headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity = restTemplate.postForEntity(uri+"/saveQuestion", request, Object.class);
		
		Object listQAObject = responseEntity.getBody();
		
		
		
		JSONObject jsonResponseObject = new JSONObject();
		jsonResponseObject.put("QuestionSaved", listQAObject );
		
		return jsonResponseObject;
	}
	
}
