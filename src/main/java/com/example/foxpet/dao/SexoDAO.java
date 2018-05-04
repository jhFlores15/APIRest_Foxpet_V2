package com.example.foxpet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foxpet.model.Sexo;
import com.example.foxpet.repository.SexoRepository;

@Service
public class SexoDAO {
	
	@Autowired
	SexoRepository sexoRepository;
	
	
	public Sexo save(Sexo alr) {
		return sexoRepository.save(alr);
	}
	

	public List<Sexo> findAll(){
		return sexoRepository.findAll();
	}
	

	public Sexo findOne(int alr) {
	    return sexoRepository.findById(alr).orElse(null);
	}
	

	public void delete(Sexo alr) {
		sexoRepository.delete(alr);
	}
}
