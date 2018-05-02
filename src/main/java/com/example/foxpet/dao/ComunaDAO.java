package com.example.foxpet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foxpet.model.Comuna;
import com.example.foxpet.repository.ComunaRepository;

@Service
public class ComunaDAO {
	@Autowired
	ComunaRepository comunaRepository;
	

	public Comuna save(Comuna com) {
		return comunaRepository.save(com);
	}
	

	public List<Comuna> findAll(){
		return comunaRepository.findAll();
	}
	

	public Comuna findOne(int com) {
	    return comunaRepository.findById(com).orElse(null);
	}
	

	public void delete(Comuna com) {
		comunaRepository.delete(com);
	}
}
