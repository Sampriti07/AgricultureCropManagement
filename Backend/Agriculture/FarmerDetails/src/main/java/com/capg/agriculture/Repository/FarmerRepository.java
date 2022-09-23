package com.capg.agriculture.Repository;

import com.capg.agriculture.entity.Farmer;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface FarmerRepository extends MongoRepository<Farmer, String> {




}
