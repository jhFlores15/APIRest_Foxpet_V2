package com.example.foxpet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.foxpet.model.FrecuenciaComida;
import com.example.foxpet.repository.FrecuenciaComidaRepository;



public class FrecuenciaComidaDAO {
	
	@Autowired
	FrecuenciaComidaRepository frecuenciacomidaRepository;
	

	public FrecuenciaComida save(FrecuenciaComida alr) {
		return frecuenciacomidaRepository.save(alr);
	}
	

	public List<FrecuenciaComida> findAll(){
		return frecuenciacomidaRepository.findAll();
	}
	

	public FrecuenciaComida findOne(int alr) {
	    return frecuenciacomidaRepository.findById(alr).orElse(null);
	}
	

	public void delete(FrecuenciaComida alr) {
		frecuenciacomidaRepository.delete(alr);
	}
}
