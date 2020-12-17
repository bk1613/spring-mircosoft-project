package com.synex.controller;

import java.io.*;
import java.math.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import org.springframework.http.ResponseEntity;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
//import com.google.gson.Gson;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
import  org.json.simple.JSONArray;
import  org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import  org.json.simple.parser.JSONParser;
class Result{
	
	public static List<String> getArticleTitles(String author){
		List<String> titles = new ArrayList<>();
		int count = 0;
		try {

		HttpClient client = HttpClient.newHttpClient();
		
		String url = "https://jsonmock.hackerrank.com/api/articles?author=" + author;
		
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
		
		HttpResponse<String> response;
		
		response = client.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.println(response.body());

		JSONObject jsonObject = (JSONObject) JSONValue.parse(response.body());
		
		JSONArray jsonArtilces = (JSONArray) jsonObject.get("data");
		
		long total = (long) jsonObject.get("total");
		long page = (long) jsonObject.get("page");
		long total_pages = (long) jsonObject.get("total_pages");
		long per_page = (long) jsonObject.get("per_page");
		
		List<JSONArray> jslist = new ArrayList<>();
		jslist.add(jsonArtilces);
		
		long temp = page;
		long tempper = per_page;
		
		while(count <= total) {
			count++;
			if(count > tempper) {
				tempper += per_page;
				temp++;
				url = "https://jsonmock.hackerrank.com/api/articles?author=" + author+"&page="+temp;
		
				request = HttpRequest.newBuilder().uri(URI.create(url)).build();
		
				response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
				jsonObject = (JSONObject) JSONValue.parse(response.body());
				
				jsonArtilces = (JSONArray) jsonObject.get("data");
				
				System.out.println(response.body());
				jslist.add(jsonArtilces);
			}
			
		}
		count = 0;
		for(JSONArray jsonArt: jslist) {
				for(Object js: jsonArt) {
					count++;
					if(count > per_page) {
						count=0;
						page++;
					}
					
					JSONObject jsonartile = (JSONObject) JSONValue.parse(js.toString());
					String title = (String) jsonartile.get("title");
					String story_title = (String) jsonartile.get("story_title");
					if(title != null) {
						titles.add("title: " +title + " page: " +page);
					}else if(story_title != null) {
						titles.add("story title: " +story_title + " page: " +page);
					}
				
			
			}
		}
		
		
		
//		JsonParser parser = new JsonParser();
//		JsonElement jsonTree = parser.parse(response.body());
//		
//		if(jsonTree.isJsonObject()) {
//			JsonObject jsonObject = jsonTree.getAsJsonObject();
//			
//			JsonElement page = jsonObject.get("page");
//			JsonElement perpage = jsonObject.get("per_page");
//			JsonElement total = jsonObject.get("total");
//			JsonElement total_pages = jsonObject.get("total_pages");
//			JsonElement data = jsonObject.get("data");
//			
//			//System.out.println(data.getAsJsonArray());
//			for(JsonElement oj: data.getAsJsonArray()) {
//				jsonObject = oj.getAsJsonObject();
//				JsonElement title = jsonObject.get("title");
//				JsonElement story_title = jsonObject.get("story_title");
//				
//				if(title != null) {
//					titles.add(title.getAsString());
//				}else if(story_title != null) {
//					titles.add(story_title.getAsString());
//				}
//			}
//		}
		
		
		
		
		}catch(IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return titles;
	}
}

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		String author = bufferedReader.readLine();
		
		List<String> result = Result.getArticleTitles(author);
		
		for(String s: result) {
			System.out.println(s);
		}
		
		bufferedReader.close();
	}
}
