package com.synex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.synex.domain.User;
import com.synex.service.PointService;

@Controller
public class PointController {
	//store data in service memory, not database
	@Autowired
	PointService pointService;
	
	@PostMapping("adduser")
	public ResponseEntity<User> addUser(@RequestBody User user){
		
		User finduser = pointService.findUser(user.getId());
		if(finduser != null) {
			System.out.println(finduser.getPoints()+user.getPoints());
			if((finduser.getPoints()+user.getPoints())<0) {
				user.setPoints(finduser.getPoints()+user.getPoints()*-1);
				user.setPreponts(finduser.getPoints());
			}else {
				user.setPoints(finduser.getPoints()+user.getPoints());
				user.setPreponts(finduser.getPoints());
			}
			
		}else {
			user.setPreponts(user.getPoints());
		}
		
		user = pointService.addUser(user);
		
		return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("getallusers")
	public ResponseEntity<List<User>> findallUsers(){
		
		List<User> users = pointService.findall();
		for(User u: users ) {
			System.out.println(u.getPreponts());
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.FOUND);
	}
	
	@GetMapping("deductpoints/{points}")
	public ResponseEntity<List<User>> deductpoints(@PathVariable int points){
		
		List<User> users = pointService.findall();
		
		int deduct = 0;
		for(int i = 0; i < users.size(); i++) {
			if(i == users.size()-1) {
				
				int result = points - deduct;
				if(result < users.get(i).getPoints()) {
					users.get(i).setPoints(users.get(i).getPoints()-result);
				}
				
				
			}else {
				if(users.get(i).getPoints() > 0) {
					users.get(i).setPoints(users.get(i).getPoints()-users.get(i).getPreponts());
				}
				
				deduct += users.get(i).getPreponts();
			}
			pointService.addUser(users.get(i));
		}
		
		return new ResponseEntity<List<User>>(users, HttpStatus.FOUND);
	}
	
}
