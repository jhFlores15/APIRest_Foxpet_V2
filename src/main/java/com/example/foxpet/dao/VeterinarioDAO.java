package com.example.foxpet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foxpet.model.Veterinario;
import com.example.foxpet.repository.VeterinarioRepository;

@Service
public class VeterinarioDAO {
	
	@Autowired
	VeterinarioRepository veterinarioRepository;
	
	
	public Veterinario save(Veterinario alr) {
		return veterinarioRepository.save(alr);
	}
	

	public List<Veterinario> findAll(){
		return veterinarioRepository.findAll();
	}
	

	public Veterinario findOne(int alr) {
	    return veterinarioRepository.findById(alr).orElse(null);
	}
	

	public void delete(Veterinario alr) {
		veterinarioRepository.delete(alr);
	}
}
