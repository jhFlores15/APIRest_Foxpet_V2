package com.example.foxpet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foxpet.model.VacunaMascota;
import com.example.foxpet.repository.VacunaMascotaRepository;

@Service
public class VacunaMascotaDAO {
	
	@Autowired
	VacunaMascotaRepository vacunamascotaRepository;
	
	
	public VacunaMascota save(VacunaMascota alr) {
		return vacunamascotaRepository.save(alr);
	}
	

	public List<VacunaMascota> findAll(){
		return vacunamascotaRepository.findAll();
	}
	

	public VacunaMascota findOne(int alr) {
	    return vacunamascotaRepository.findById(alr).orElse(null);
	}
	

	public void delete(VacunaMascota alr) {
		vacunamascotaRepository.delete(alr);
	}
}
