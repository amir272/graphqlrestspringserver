package com.example.assignment.service;

import java.util.List;

import com.example.assignment.entity.Manufacturer;

public interface ManufactureService {

	public List<Manufacturer> getALL();
	public List<Manufacturer> findByName(String name);
}
