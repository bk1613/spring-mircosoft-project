package com.synex.controller;

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

public class CountryPopulation {

	public static int getCountries(String s, int p) throws Exception {
		System.out.println(p);
		int count = 0;
		
		String url = "https://jsonmock.hackerrank.com/api/countries/search?name="+s;
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
		
		HttpResponse<String> response;
		
		response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		JSONObject jsonObject = (JSONObject) JSONValue.parse(response.body());
		
		System.out.println(response.body());
		
		JSONArray jsonArtilces = (JSONArray) jsonObject.get("data");
		long total = (long) jsonObject.get("total");
		long page = (long) jsonObject.get("page");
		long total_pages = (long) jsonObject.get("total_pages");
		long per_page = (long) jsonObject.get("per_page");
		
		System.out.println(page);
		
		List<JSONArray> jslist = new ArrayList<>();
		jslist.add(jsonArtilces);
		
		long temp = 0;
		long tempper = per_page;
		
		while(count <= total) {
			count++;
			if(count > tempper) {
				tempper += per_page;
				temp++;
				
				if(temp == page) {
					break;
				}
				
				url = "https://jsonmock.hackerrank.com/api/articles?author=" + s+"&page="+temp;
		
				request = HttpRequest.newBuilder().uri(URI.create(url)).build();
		
				response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
				jsonObject = (JSONObject) JSONValue.parse(response.body());
				
				jsonArtilces = (JSONArray) jsonObject.get("data");
				
				System.out.println(response.body());
				jslist.add(jsonArtilces);
			}
			
		}
		
		count = 0;
		int popcount = 0;
		
		for(JSONArray jsonArt: jslist) {
				System.out.println(jsonArt);
				for(Object js: jsonArt) {
					//System.out.println(js);
					count++;
					if(count > per_page) {
						count=0;
						page++;
					}
					
					JSONObject jsonartile = (JSONObject) JSONValue.parse(js.toString());
					long pop = (long) jsonartile.get("population");
					System.out.println(pop);
					if(pop > p) {
						popcount++;
					}
				}
		}
		return popcount;
	}
	
	public static void main(String[] args){
		// TODO Auto-generated method stub

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int res;
		String in;
		try {
			in = bufferedReader.readLine();
		}catch(Exception e) {
			in = null;
		}
		
		int _p = 0;
		
		try {
			_p = Integer.parseInt(bufferedReader.readLine().trim());
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			res = getCountries(in, _p);
			
		}catch(Exception e) {
			res = 0;
		}
		System.out.println(res);
	}

}
