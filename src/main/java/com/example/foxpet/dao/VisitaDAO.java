package com.example.foxpet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foxpet.model.Visita;
import com.example.foxpet.repository.VisitaRepository;

@Service
public class VisitaDAO {

	
	@Autowired
	VisitaRepository visitaRepository;
	
	
	public Visita save(Visita alr) {
		return visitaRepository.save(alr);
	}
	

	public List<Visita> findAll(){
		return visitaRepository.findAll();
	}
	

	public Visita findOne(int alr) {
	    return visitaRepository.findById(alr).orElse(null);
	}
	

	public void delete(Visita alr) {
		visitaRepository.delete(alr);
	}
}
