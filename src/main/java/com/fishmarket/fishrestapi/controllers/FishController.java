package com.fishmarket.fishrestapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fishmarket.fishrestapi.models.Fish;
import com.fishmarket.fishrestapi.repositories.FishRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class FishController {

	@Autowired
	FishRepository fishRepository;
	
	@GetMapping("/sales")
	public List<Fish> getAllsales(){
		return fishRepository.findAll();
	}
	
	@PostMapping("/sales")
	public Fish createUser(@RequestBody Fish sale) {
		return fishRepository.save(sale);
	}
	
	@GetMapping(value="/sales/{id}")
	public ResponseEntity<Fish> getUserById(@PathVariable("id") String id){
		return fishRepository.findById(id).map(sale -> ResponseEntity.ok().body(sale)).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value="/sales/{id}")
    public ResponseEntity<Fish> updateTodo(@PathVariable("id") String id,
                                           @RequestBody Fish fish) {
        return fishRepository.findById(id)
                .map(fishData -> {
                	fishData.setFishName(fish.getFishName());
                    Fish updatedFish = fishRepository.save(fishData);
                    return ResponseEntity.ok().body(updatedFish);
                }).orElse(ResponseEntity.notFound().build());
    }
	
	@DeleteMapping(value="/sales/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id) {
        return fishRepository.findById(id)
                .map(fish -> {
                    fishRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
