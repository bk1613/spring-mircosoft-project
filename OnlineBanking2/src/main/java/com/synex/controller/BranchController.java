package com.synex.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.synex.domain.Address;
import com.synex.domain.Branch;
import com.synex.service.BranchService;
import com.synex.validation.BranchValidator;

@Controller
public class BranchController {

	@Autowired
	BranchService branchService;
	
	@Autowired
	BranchValidator branchValidator;
	
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.addValidators(branchValidator);
		
	}
	@PreAuthorize(value = "hasAuthority('User') || hasAuthority('Manager')")
	@RequestMapping("/branches")
	public String Branchs(Branch branch, Model model) {
		System.out.println("BranchForm");
		System.out.println("list of BRanches " + branchService.findAll());
		model.addAttribute("branchs", branchService.findAll());
		return "branches";
	}
	@PreAuthorize(value = "hasAuthority('Manager')")
	@RequestMapping("/branchform")
	public String BranchForm(Branch branch, Model model) {
		System.out.println("BranchForm");
		System.out.println("list of BRanches " + branchService.findAll());
//		model.addAttribute("branchs", branchService.findAll());
		return "branchform";
	}
	
	@RequestMapping(value="createBranch")
	public ResponseEntity<Branch> CreateBranch(@RequestParam String branchName, @RequestParam String al1, @RequestParam String al2, @RequestParam String city, @RequestParam String state) {
		Address address = new Address(al1,al2,city,state);
		Branch branch = new Branch();
		branch.setBranchName(branchName);
		branch.setBranchAddress(address);
		Branch brachfromdb = branchService.save(branch);
		
		return new ResponseEntity<Branch>(brachfromdb, HttpStatus.CREATED);
	}
	
	@PostMapping(value="savebranch")
	public String saveBranch(@Valid @ModelAttribute Branch branch, BindingResult br, Model model) {
		if(!br.hasErrors()) {
			System.out.println("saveBranch");
			Branch brachfromdb = branchService.save(branch);
			model.addAttribute("Branch", brachfromdb);
			
		}
		model.addAttribute("branchs", branchService.findAll());
		return "branches";
	}
	
	@RequestMapping(value="updateBranch")
	public String updateBranch(Branch branch, @RequestParam long id, Model model) {
		System.out.println("updateBanch");
		branch = branchService.findBranchByid(id);
		model.addAttribute("Branch", branch);
		
		return "branchform";
	}
	
	
	@RequestMapping(value="deleteBranch")
	public String deleteBranch(Branch branch, @RequestParam long id, Model model) {
		System.out.println("deleteBranch");
		branchService.deleteBranchById(id);
		model.addAttribute("branchs", branchService.findAll());
		return "branches";
	}
}
