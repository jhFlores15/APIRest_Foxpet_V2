package com.example.foxpet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foxpet.model.Umbral;
import com.example.foxpet.repository.UmbralRepository;



@Service
public class UmbralDAO {
	
	@Autowired
	UmbralRepository umbralRepository;
	

	public Umbral save(Umbral com) {
		return umbralRepository.save(com);
	}
	

	public List<Umbral> findAll(){
		return umbralRepository.findAll();
	}
	

	public Umbral findOne(int com) {
	    return umbralRepository.findById(com).orElse(null);
	}
	

	public void delete(Umbral com) {
		umbralRepository.delete(com);
	}

}
