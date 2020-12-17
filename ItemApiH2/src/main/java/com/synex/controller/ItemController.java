package com.synex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.synex.model.Item;
import com.synex.model.Status;
import com.synex.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	ItemService ser;
	
	@PostMapping(value = "/app/item")
	public ResponseEntity<Item> saveitem(@RequestBody Item it){
		System.out.println(it.getItemId());
		
		Item findit = ser.findbyid(it.getItemId());
		System.out.println(findit);
		if(findit == null) {
			
			it = ser.save(it);
			return new ResponseEntity<Item>(it, HttpStatus.CREATED);
			
		}else {
			return new ResponseEntity<Item>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/app/item/g")
	public ResponseEntity<?> gitem(){
		System.out.println("get");
		return new ResponseEntity<String>("get",HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping("/app/item/{itemId}")
	public ResponseEntity<Item> updateitem(@PathVariable int itemId, @RequestBody Item it){
		Item findit = ser.findbyid(itemId);
		if(findit != null) {
			it = ser.save(it);
			return new ResponseEntity<Item>(it, HttpStatus.OK);
		}else {
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/app/item/{itemId}")
	public ResponseEntity<Item> deleteitembyid(@PathVariable int itemId){
		Item findit = ser.findbyid(itemId);
		if(findit != null) {
			ser.delete(itemId);
			return new ResponseEntity<Item>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Item>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/app/item")
	public ResponseEntity<Item> deleteitem(@RequestBody Item it){
		
		ser.deleteall();
		
		return new ResponseEntity<Item>(HttpStatus.OK);
	}
	
	
	@GetMapping("/app/item/{itemId}")
	public ResponseEntity<Item> getitem(@PathVariable int itemId){
		Item findit = ser.findbyid(itemId);
		if(findit != null) {
			return new ResponseEntity<Item>(findit, HttpStatus.OK);
		}
		return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/app/item")
	public ResponseEntity<List<Item>> getallitem(){
		List<Item> itemlist= ser.getallitems();
		return new ResponseEntity<List<Item>>(itemlist, HttpStatus.FOUND);
	}
	
//	@GetMapping(value="/app/item", params = {"itemStatus", "itemEnterByUser"})
//	public ResponseEntity<List<Item>> getitemByStatusAndUser(@RequestParam(value="itemStatus") Status status, @RequestParam("itemEnterByUser") String nameuser){
//		System.out.println(status + " " + nameuser);
//		List<Item> it = ser.findbyStatsUser(status, nameuser);
//		System.out.println(it);
//		return new ResponseEntity<List<Item>>(it, HttpStatus.OK);
//	}
//
//	@GetMapping(value="/app/item", params = {"pageSize", "page", "sortBy"})
//	public ResponseEntity<?> getitempage(@RequestParam("pageSize") int pagesize, @RequestParam("page") int page, @RequestParam("sortBy") String sortby){
//		System.out.println(page + " " + pagesize + " " + sortby);
//		Pageable pageable;
//		pageable = PageRequest.of(page, pagesize, Sort.Direction.ASC, sortby);
//		Page<Item> pageofitems = ser.getallitems(pageable);
//		List<Item> items = pageofitems.getContent();
//		System.out.println(items);
//		return new ResponseEntity<List<Item>>(items, HttpStatus.FOUND);
//	}

}
