package com.capg.agriculture.Repository;

import com.capg.agriculture.entity.CropDetails;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface CropRepository extends MongoRepository<CropDetails, Integer> {




}
