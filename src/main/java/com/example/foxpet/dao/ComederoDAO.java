package com.example.foxpet.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foxpet.model.Comedero;
import com.example.foxpet.repository.ComederoRepository;

@Service
public class ComederoDAO {
	
	@Autowired
	ComederoRepository comederoRepository;
	
	/*Guardar Comuna*/
	public Comedero save(Comedero alr) {
		return comederoRepository.save(alr);
	}
	
	/*Buscar Comuna*/
	public List<Comedero> findAll(){
		return comederoRepository.findAll();
	}
	
	/* Tomar una Comuna por Id*/
	public Comedero findOne(int alr) {
	    return comederoRepository.findById(alr).orElse(null);
	}
	
	/*Borrar Comuna*/
	public void delete(Comedero alr) {
		comederoRepository.delete(alr);
	}
}
