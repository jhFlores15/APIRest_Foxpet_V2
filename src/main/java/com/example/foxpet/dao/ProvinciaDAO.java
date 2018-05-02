package com.example.foxpet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foxpet.model.Provincia;
import com.example.foxpet.repository.ProvinciaRepository;



@Service
public class ProvinciaDAO {
	@Autowired
	ProvinciaRepository provinciaRepository;
	
	
	public Provincia save(Provincia pro) {
		return provinciaRepository.save(pro);
	}

	public List<Provincia> findAll(){
		return provinciaRepository.findAll();
	}
	
	public Provincia findOne(int proId) {
	    return provinciaRepository.findById(proId).orElse(null);
	}
	
	public void delete(Provincia pro) {
		provinciaRepository.delete(pro);
	}
}
