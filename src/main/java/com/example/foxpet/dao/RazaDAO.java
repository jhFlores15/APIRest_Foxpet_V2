package com.example.foxpet.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.foxpet.model.Raza;
import com.example.foxpet.repository.RazaRepository;


@Service
public class RazaDAO {

	@Autowired
	RazaRepository razaRepository;
	

	public Raza save(Raza reg) {
		return razaRepository.save(reg);
	}
	

	public List<Raza> findAll(){
		return razaRepository.findAll();
	}
	

	public Raza findOne(int regId) {
	    return razaRepository.findById(regId).orElse(null);
	}
	

	public void delete(Raza reg) {
		razaRepository.delete(reg);
	}
}
