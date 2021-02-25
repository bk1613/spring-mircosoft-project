package com.prac;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class GetAuthorArticle2 {

	public static List<String> getArticleTitles(String s) throws Exception{
		List<String> titles = new ArrayList<>();
		URL url = new URL("https://jsonmock.hackerrank.com/api/articles?author=" + s);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
	
		InputStream input;
	
		input = con.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		StringBuilder response = new StringBuilder();
		String currentLine;
		
		while((currentLine = br.readLine()) != null) {
			response.append(currentLine);
		}
		
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject)parser.parse(response.toString());
		
		System.out.println(((JSONObject)obj).get("data"));
		
		JSONArray jsonArtilces = (JSONArray) obj.get("data");
		
		return titles;
	}
	
	
	public static void main(String[] args) throws Exception {
		
		getArticleTitles("epaga");
	}
	
	
}
