package com.synex;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class NeutronRestClient {
	
	public static void increaseneutrons() {
		
		String neutron = "{}";
		JSONObject jsonObject = new JSONObject(neutron);
		
		jsonObject.put("noOfNeutron", 500000);
		
		System.out.println(jsonObject);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<String>(jsonObject.toString(), headers);
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			ResponseEntity<Object> responseEntity = restTemplate.postForEntity("http://localhost:8180/increaseBombardment", request, Object.class);
			Object neutronObject = responseEntity.getBody();
			System.out.println(neutronObject);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static void decreaseneutrons() {
		
		String neutron = "{}";
		JSONObject jsonObject = new JSONObject(neutron);
		
		jsonObject.put("noOfNeutron", 500000);
		
		System.out.println(jsonObject);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<String>(jsonObject.toString(), headers);
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Object> responseEntity = restTemplate.postForEntity("http://localhost:8180/decreaseBombardment", request, Object.class);
		Object neutronObject = responseEntity.getBody();
		System.out.println(neutronObject);
	}
	
	public static void main(String[] args) {
		increaseneutrons();
	}
}
