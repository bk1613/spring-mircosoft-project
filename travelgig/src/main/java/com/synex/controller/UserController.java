package com.synex.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.synex.domain.Role;
import com.synex.domain.User;
import com.synex.service.RoleService;
import com.synex.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleservice;
	
	@GetMapping("/login")
	public String login(
			@RequestParam(value="logout", required=false) String logout,
			@RequestParam(value="error", required=false) String error,
			HttpServletRequest request, HttpServletResponse response,
			Model model
			) {
		System.out.println("login");
		String message = null;
		if(error != null) {
			message = "Your login credientials are not OK.";
		}
		
		if(logout != null) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if(authentication != null) {
				new SecurityContextLogoutHandler().logout(request, response, authentication);
			}
			message ="You have been Logged out successfully.";
			model.addAttribute("message", message);
			return "login";
		}
		
		return "login";//view name
		
	}
	
	@RequestMapping(value ="/signupform", method = RequestMethod.GET)
	public String viewsignup() {
		System.out.println(userService.findAll());
	
		return "user";
	}
	
	@PostMapping("/saveuser")
	public ResponseEntity<String> saveuser(@RequestBody String jsonString) throws JSONException, JsonProcessingException {
		
		JSONObject jsonUser = new JSONObject(jsonString);
		
		User user = new User();
		user.setUsername(jsonUser.getString("username"));
		user.setPassword(jsonUser.getString("password"));
		user.setEmail(jsonUser.getString("email"));
		
		Object userresponse = userService.save(user);
		JSONObject jsonResponseObject = new JSONObject();
		jsonResponseObject.put("User", userresponse);
		
		
		return new ResponseEntity<String>(jsonResponseObject.toString(), HttpStatus.OK);
	}
}
