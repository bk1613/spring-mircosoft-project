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
		model.addAttribute("roles", roleService.findAll());
		return "roleform";
	}
	
	@RequestMapping("/saverole")
	public String saveRole(Role role, Model model) {
		roleService.createRole(role);
		model.addAttribute("roles", roleService.findAll());
		return "roleform";
	}
	
	@RequestMapping("/deleterole")
	public String deleteRole(Role role, @RequestParam long id, Model model) {
		roleService.delete(id);
		model.addAttribute("roles", roleService.findAll());
		return "roleform";
	}
	
}
