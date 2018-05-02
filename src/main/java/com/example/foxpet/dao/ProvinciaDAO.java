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
	
	/*Guardar Provincia*/
	public Provincia save(Provincia pro) {
		return provinciaRepository.save(pro);
	}
	
	/*Buscar Provincia*/
	public List<Provincia> findAll(){
		return provinciaRepository.findAll();
	}
	
	/* Tomar una Provincia por Id*/
	public Provincia findOne(int proId) {
	    return provinciaRepository.findById(proId).orElse(null);
	}
	
	/*Borrar Provinia*/
	public void delete(Provincia pro) {
		provinciaRepository.delete(pro);
	}
}
