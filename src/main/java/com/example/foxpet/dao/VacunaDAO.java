package com.example.foxpet.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foxpet.model.Vacuna;
import com.example.foxpet.repository.VacunaRepository;


@Service
public class VacunaDAO {

	@Autowired
	VacunaRepository vacunaRepository;
	
	
	public Vacuna save(Vacuna alr) {
		return vacunaRepository.save(alr);
	}
	

	public List<Vacuna> findAll(){
		return vacunaRepository.findAll();
	}
	

	public Vacuna findOne(int alr) {
	    return vacunaRepository.findById(alr).orElse(null);
	}
	

	public void delete(Vacuna alr) {
		vacunaRepository.delete(alr);
	}
}
