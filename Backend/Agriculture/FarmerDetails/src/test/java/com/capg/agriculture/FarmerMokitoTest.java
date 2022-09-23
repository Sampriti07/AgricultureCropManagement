package com.capg.agriculture;

import org.springframework.boot.test.context.SpringBootTest;

import com.capg.agriculture.Repository.FarmerRepository;
import com.capg.agriculture.entity.Farmer;
import com.capg.agriculture.service.FarmerService;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;

@SpringBootTest(classes= {FarmerMokitoTest.class})
public class FarmerMokitoTest {

	@Mock         //Used for mocking the repository class
	FarmerRepository crepo;

	@InjectMocks  //Used for injecting/invoking the methods of service class
	FarmerService service;

	public List<Farmer> f;

	@Test
	@Order(1)         //For executing this method first
	public void test_getFarmer()
	{
		List<Farmer> f=new ArrayList<Farmer>();
//		f.add(new Farmer("Sampriti", "Sam2000@gmail.com",6290407));
//		f.add(new Farmer( "Shreya", "Shreya2000@gmail.com",365245));
//		
		when(crepo.findAll()).thenReturn(f);
		assertEquals(2,service.getFarmerName().size());        //Invoke the method from the service class
	}

//	@Test
//	//@Order(2)        //For executing this method first
//	public void test_save() //test case for checking get all companies details 
//	{
//		//List<Company> f=new ArrayList<Company>();
//		Farmer c=new Farmer(110, "Subarna", "sub@gmail.com",8956425);
//		
//		when(crepo.save(c)).thenReturn(c);
//		assertEquals(c,service.savefarm(c));        //Invoke the method from the service class
//	}

	
	
}
