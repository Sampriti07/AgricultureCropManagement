package com.capg.agriculture.controller;

import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.web.client.RestTemplate;

import com.capg.agriculture.entity.CropDetails;
import com.capg.agriculture.service.CropService;
import com.capg.agriculture.Repository.CropRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping("/crop")
public class CropController {
	@Autowired
	CropService cservice;
	
	@Autowired
	public RestTemplate restTemplate;
	
	//RestTemplate Configuration
	
	@GetMapping("/getfarmerdetails")
	public List<Object> getCrop() {
		Object[] objects = restTemplate.getForObject("http://farmer-details/farmer/getall", Object[].class);
		return Arrays.asList(objects);
	}
//	
	//ResponseEntity Configuration
	
	@GetMapping("/getall")
	public List<CropDetails> getCropName(){
		return cservice.getCropName();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getUserDetailsById(@PathVariable("id") String id)  {
			CropDetails crop= cservice.findById(id);
			if(crop==null)
				return new ResponseEntity<Object>("User Data not found",HttpStatus.EXPECTATION_FAILED);
			return new ResponseEntity<Object>(crop,HttpStatus.OK);
		}
	
	@PostMapping("/save")
	public ResponseEntity<String> insertUser(@RequestBody CropDetails crop) {
		System.out.println("CropDetails registered");
		cservice.savecrop(crop);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> UpdateUserById1(@PathVariable("id") String id, @RequestBody CropDetails crop) {
		Optional<CropDetails> op = cservice.findById1(id);
		if (op.isPresent()) {
			CropDetails us = op.get();		
			us.setId(crop.getId());
			us.setCropName(crop.getCropName());
			us.setQuantity(crop.getQuantity());
			us.setPrice(crop.getPrice());	
			us.setPh_no(crop.getPh_no());
			cservice.save(us);
			return new ResponseEntity<Object>(us, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("Not updated successfully", HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteproductById(@PathVariable("id") String id){
		Optional<CropDetails> op= cservice.findById1(id);
		if(op.isPresent())
		{
			cservice.deleteById(id);
		return new ResponseEntity<String>("User Deleted successfully", HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("User Not Found",HttpStatus.EXPECTATION_FAILED);
	}
	
	


}