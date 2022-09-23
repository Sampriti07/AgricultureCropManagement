package com.capg.agriculture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.agriculture.Repository.CropRepository;
import com.capg.agriculture.entity.CropDetails;



@Service
public class CropService {
	@Autowired
	private CropRepository crepo;
	
	public List<CropDetails> getCropName() {
		// TODO Auto-generated method stub
		return crepo.findAll();
	}

	public void savecrop(CropDetails crop) {
		// TODO Auto-generated method stub
		crepo.save(crop);
	}

	public void deleteById(String pid) {
		// TODO Auto-generated method stub
		crepo.deleteById(pid);
	}
	public Optional<CropDetails> findById1(String id) {
		// TODO Auto-generated method stub
		return crepo.findById(id);
	}


	public void save(CropDetails prod) {
		// TODO Auto-generated method stub
		crepo.save(prod);
	}

	public CropDetails findById(String id) {
		// TODO Auto-generated method stub
		Optional<CropDetails> op= crepo.findById(id);
		if(op.isPresent())
		{
			CropDetails crop= op.get();
			return crop;
		}
		return null;
		}
}