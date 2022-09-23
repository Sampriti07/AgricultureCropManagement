package com.capg.agriculture.controller;

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

import com.capg.agriculture.entity.Farmer;
import com.capg.agriculture.service.FarmerService;

@RestController
@RequestMapping("/farmer")
public class FarmerController {
	@Autowired
	FarmerService cservice;
	
	@Autowired
	public RestTemplate restTemplate;
	
	//RestTemplate Configuration
	
	@GetMapping("/getcropdetails")
	public List<Object> getCrop() {
		Object[] objects = restTemplate.getForObject("http://crop-management/crop/getall", Object[].class);
		return Arrays.asList(objects);
	}
	
	//ResponseEntity Configuration
	
	@GetMapping("/getall")
	public List<Farmer> getFarmerName(){
		return cservice.getFarmerName();
	}

	@PostMapping("/save")
	public ResponseEntity<String> insertUser(@RequestBody Farmer f) {
		System.out.println("FarmerDetails registered");
		cservice.savefarm(f);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> UpdateUserById1(@PathVariable("id") String id, @RequestBody Farmer f) {
		Optional<Farmer> op = cservice.findById1(id);
		if (op.isPresent()) {
			Farmer us = op.get();		
			//us.setFid(f.getFid());
			us.setName(f.getName());
			us.setEmailid(f.getEmailid());
			us.setPh_no(f.getPh_no());	
			
			cservice.save(us);
			return new ResponseEntity<Object>(us, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("Not updated successfully", HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteproductById(@PathVariable("id") String id){
		Optional<Farmer> op= cservice.findById1(id);
		if(op.isPresent())
		{
			cservice.deleteById(id);
		return new ResponseEntity<String>("Farmer Details Deleted successfully", HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Details Not Found",HttpStatus.EXPECTATION_FAILED);
	}
	


}