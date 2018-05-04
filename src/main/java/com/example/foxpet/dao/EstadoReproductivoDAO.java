package com.example.foxpet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foxpet.model.EstadoReproductivo;
import com.example.foxpet.repository.EstadoReproductivoRepository;


@Service
public class EstadoReproductivoDAO {

	@Autowired
	EstadoReproductivoRepository estadoreproductivoRepository;
	

	public EstadoReproductivo save(EstadoReproductivo alr) {
		return estadoreproductivoRepository.save(alr);
	}
	

	public List<EstadoReproductivo> findAll(){
		return estadoreproductivoRepository.findAll();
	}
	

	public EstadoReproductivo findOne(int alr) {
	    return estadoreproductivoRepository.findById(alr).orElse(null);
	}
	

	public void delete(EstadoReproductivo alr) {
		estadoreproductivoRepository.delete(alr);
	}
}
