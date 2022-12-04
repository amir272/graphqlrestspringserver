package com.example.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment.entity.Manufacturer;
import com.example.assignment.repo.ManufacturerRepo;

@Service
public class ManufactureServiceIMPL implements ManufactureService{
	
	@Autowired
	ManufacturerRepo manufacturerRepo;
	public List<Manufacturer> getALL() {
		return manufacturerRepo.findAll();
	}
	
	public List<Manufacturer> findByName(String name) {
		return manufacturerRepo.findByName(name);
	}

}
