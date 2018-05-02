package com.example.foxpet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.foxpet.model.Especie;
import com.example.foxpet.repository.EspecieRepository;

@Service
public class EspecieDAO {
	@Autowired
	EspecieRepository especieRepository;
	

	public Especie save(Especie alr) {
		return especieRepository.save(alr);
	}
	

	public List<Especie> findAll(){
		return especieRepository.findAll();
	}
	
	
	public Especie findOne(int alr) {
	    return especieRepository.findById(alr).orElse(null);
	}
	
	
	public void delete(Especie alr) {
		especieRepository.delete(alr);
	}
}
