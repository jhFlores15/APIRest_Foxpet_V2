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
	
	/*Guardar Comuna*/
	public Especie save(Especie alr) {
		return especieRepository.save(alr);
	}
	
	/*Buscar Comuna*/
	public List<Especie> findAll(){
		return especieRepository.findAll();
	}
	
	/* Tomar una Comuna por Id*/
	public Especie findOne(int alr) {
	    return especieRepository.findById(alr).orElse(null);
	}
	
	/*Borrar Comuna*/
	public void delete(Especie alr) {
		especieRepository.delete(alr);
	}
}
