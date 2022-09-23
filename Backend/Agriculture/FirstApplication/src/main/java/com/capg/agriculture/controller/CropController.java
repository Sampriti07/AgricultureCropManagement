package com.capg.agriculture.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.agriculture.entity.CropDetails;
import com.capg.agriculture.Repository.CropRepository;

@RestController
@RequestMapping("/crop")
public class CropController {
	@Autowired
	CropRepository repo;
	
	@PostMapping("/register")
	public ResponseEntity<String> insertDetails(@RequestBody CropDetails crop) {
		System.out.println("Crop Details Saved");
		repo.save(crop);
		System.out.println(crop);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}



}