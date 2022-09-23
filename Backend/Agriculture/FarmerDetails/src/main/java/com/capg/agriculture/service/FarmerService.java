package com.capg.agriculture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.agriculture.Repository.FarmerRepository;
import com.capg.agriculture.entity.Farmer;



@Service
public class FarmerService {
	@Autowired
	private FarmerRepository crepo;
	
	public List<Farmer> getFarmerName() {
		// TODO Auto-generated method stub
		return crepo.findAll();
	}

	public void savefarm(Farmer f) {
		// TODO Auto-generated method stub
		crepo.save(f);
	}

	public void deleteById(String id) {
		// TODO Auto-generated method stub
		crepo.deleteById(id);
	}
	public Optional<Farmer> findById1(String id) {
		// TODO Auto-generated method stub
		return crepo.findById(id);
	}


	public void save(Farmer f) {
		// TODO Auto-generated method stub
		crepo.save(f);
	}
}