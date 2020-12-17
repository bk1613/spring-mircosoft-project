package com.synex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.synex.domain.Role;
import com.synex.service.RoleService;

@Controller
public class RoleController {

	@Autowired
	RoleService roleService;
	@RequestMapping("/roleForm")
	public String roleForm(Role role, Model model) {
		System.out.println("roleform");
		model.addAttribute("roles", roleService.findAll());
		return "role";
	}
	
	@RequestMapping("/saverole")
	public String saveRole(Role role, Model model) {
		roleService.save(role);
		model.addAttribute("roles", roleService.findAll());
		return "role";
	}
	
	@RequestMapping("/deleterole")
	public String deleteRole(Role role, @RequestParam int id, Model model) {
		roleService.deletebyid(id);
		model.addAttribute("roles", roleService.findAll());
		return "role";
	}
}

