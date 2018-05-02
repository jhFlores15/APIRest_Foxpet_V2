package com.example.foxpet.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foxpet.model.Region;
import com.example.foxpet.repository.RegionRepository;




@Service
public class RegionDAO {
	
	@Autowired
	RegionRepository regionRepository;
	
	/*Guardar Region*/
	public Region save(Region reg) {
		return regionRepository.save(reg);
	}
	
	/*Buscar Region*/
	public List<Region> findAll(){
		return regionRepository.findAll();
	}
	
	/* Tomar una Region por Id*/
	public Region findOne(int regId) {
	    return regionRepository.findById(regId).orElse(null);
	}
	
	/*Borrar Region*/
	public void delete(Region reg) {
		regionRepository.delete(reg);
	}
}