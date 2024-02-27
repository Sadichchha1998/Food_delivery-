package com.masai.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.masai.model.Item;
import com.masai.service.itemsService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

public class itemcontroller {
	@PostMapping("/items")
	public Item createItem(@Valid @RequestBody Item item) {

	    Item savedItem = itemsService.save(item);
	    return savedItem;
	}
	@GetMapping("/items/{itemId}")
	public Item getItem(@PathVariable Long itemId) {

	    return itemsService.findById(itemId);  
	}
	@PutMapping("/items/{itemId}")
	public Item updateItem(@PathVariable Long itemId, @Valid @RequestBody Item item) {

	    Item updatedItem = itemsService.update(itemId, item);
	    return updatedItem;
	}
	@DeleteMapping("/items/{itemId}")
	public ResponseEntity<?> deleteItem(@PathVariable Long itemId) {

	    itemsService.deleteById(itemId);
	    return ResponseEntity.noContent().build();
	}
}
