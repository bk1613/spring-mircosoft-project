package com.synex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RestClient {

	public static void getall() {
		try {
			URL url = new URL("http://localhost:8092/findallProducts");
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			InputStream input = con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			StringBuilder response = new StringBuilder();
			String currentLine;
			
			while((currentLine = br.readLine()) != null) {
				response.append(currentLine);
			}
			
			JSONParser parser = new JSONParser();
			JSONArray jsonarray = (JSONArray) parser.parse(response.toString());
			System.out.println("{ ");
			for(Object obj: jsonarray) {
				System.out.println("  { ");
				System.out.println("    name:" + ((JSONObject)obj).get("name"));
				System.out.println("    price:" + ((JSONObject)obj).get("price"));
				System.out.println("    expireDate:" + ((JSONObject)obj).get("expireDate"));
				System.out.println("    vendor:" + ((JSONObject)obj).get("vendor"));
				System.out.println("  } ");
				System.out.println();
			}
			System.out.println("} ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getid(int id) {
		try {
			URL url = new URL("http://localhost:8092/findproduct/"+id);
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
			Object obj = (JSONObject)parser.parse(response.toString());
			System.out.println("  { ");
			System.out.println("    name:" + ((JSONObject)obj).get("name"));
			System.out.println("    price:" + ((JSONObject)obj).get("price"));
			System.out.println("    expireDate:" + ((JSONObject)obj).get("expireDate"));
			System.out.println("    vendor:" + ((JSONObject)obj).get("vendor"));
			System.out.println("  } ");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ParseException e) {
		
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		//getall();
		getid(1);
		
	}
	
	
}
