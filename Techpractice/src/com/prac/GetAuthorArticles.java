package com.prac;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class GetAuthorArticles {

	public static List<String> getArticleTitles(String s) throws Exception{
		List<String> list = new ArrayList<>();
		
		String url = "https://jsonmock.hackerrank.com/api/articles?author=" + s;
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
		
		HttpResponse<String> response;
		
		response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		JSONObject jsonObject = (JSONObject) JSONValue.parse(response.body());
		
		//System.out.println(response.body());
		
		JSONArray jsonArtilces = (JSONArray) jsonObject.get("data");
		long total = (long) jsonObject.get("total");
		long page = (long) jsonObject.get("page");
		long total_pages = (long) jsonObject.get("total_pages");
		long per_page = (long) jsonObject.get("per_page");
		int count = 0;
		while(count < total_pages) {
			count++;
			url = "https://jsonmock.hackerrank.com/api/articles?author=" + s+"&page="+count;
			

			request = HttpRequest.newBuilder().uri(URI.create(url)).build();
	
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
	
			jsonObject = (JSONObject) JSONValue.parse(response.body());
			
			jsonArtilces = (JSONArray) jsonObject.get("data");
			
			for(Object js: jsonArtilces) {
			
				
				JSONObject jsonarticle = (JSONObject) JSONValue.parse(js.toString());
				//System.out.println(jsonarticle.get("title"));
				if(jsonarticle.get("title") != null) {
					list.add(jsonarticle.get("title").toString());
				}else if(jsonarticle.get("title") == null && jsonarticle.get("story_title") != null) {
					list.add(jsonarticle.get("story_title").toString());
				}else if(jsonarticle.get("title") == null && jsonarticle.get("story_title") == null) {
					continue;
				}
			}
		}
		
		
		
		return list;
	}
	
	public static void main(String[] args) throws Exception {
		
		for(String s: getArticleTitles("saintamh"))
			System.out.println(s);
	}

}
