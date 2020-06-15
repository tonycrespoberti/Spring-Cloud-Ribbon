package com.cloud.netflix.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.netflix.item.model.Item;
import com.cloud.netflix.item.service.ItemService;



@RestController
public class ItemController {

	@Autowired
	//@Qualifier("serviceFeign") //Specifying a name, Spring knows which one to uses, because we have two classes that implement the same interface.
	@Qualifier("serviceRestTemplate")
	private ItemService itemService;
	
	//********
	
	@GetMapping(path = "/list/products")
	public List<Item> list(){
		
		return itemService.findAll();
	}
	
	@GetMapping(path = "/view/{id}/cantidad/{cantidad}")
	public Item detail(@PathVariable Long id, @PathVariable Integer cantidad) {
		
		return itemService.findById(id, cantidad);
	}
}
