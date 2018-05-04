package com.example.foxpet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foxpet.model.Establecimiento;
import com.example.foxpet.repository.EstablecimientoRepository;



@Service
public class EstablecimientoDAO {
	@Autowired
	EstablecimientoRepository establecimientoRepository;
	

	public Establecimiento save(Establecimiento alr) {
		return establecimientoRepository.save(alr);
	}
	

	public List<Establecimiento> findAll(){
		return establecimientoRepository.findAll();
	}
	

	public Establecimiento findOne(int alr) {
	    return establecimientoRepository.findById(alr).orElse(null);
	}
	

	public void delete(Establecimiento alr) {
		establecimientoRepository.delete(alr);
	}
}
