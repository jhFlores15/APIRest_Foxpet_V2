package com.example.foxpet.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foxpet.model.ComidaExtra;
import com.example.foxpet.repository.ComidaExtraRepository;

@Service
public class ComidaExtraDAO {
	@Autowired
	ComidaExtraRepository comidaextraRepository;
	
	/*Guardar Comuna*/
	public ComidaExtra save(ComidaExtra coex) {
		return comidaextraRepository.save(coex);
	}
	
	/*Buscar Comuna*/
	public List<ComidaExtra> findAll(){
		return comidaextraRepository.findAll();
	}
	
	/* Tomar una Comuna por Id*/
	public ComidaExtra findOne(int coex) {
	    return comidaextraRepository.findById(coex).orElse(null);
	}
	
	/*Borrar Comuna*/
	public void delete(ComidaExtra coex) {
		comidaextraRepository.delete(coex);
	}
}
