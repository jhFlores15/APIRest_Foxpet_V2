package com.example.foxpet.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foxpet.model.Comedero;
import com.example.foxpet.repository.ComederoRepository;

@Service
public class ComederoDAO {
	
	@Autowired
	ComederoRepository comederoRepository;
	
	
	public Comedero save(Comedero alr) {
		return comederoRepository.save(alr);
	}
	
	
	public List<Comedero> findAll(){
		return comederoRepository.findAll();
	}
	
	
	public Comedero findOne(int alr) {
	    return comederoRepository.findById(alr).orElse(null);
	}
	
	
	public void delete(Comedero alr) {
		comederoRepository.delete(alr);
	}
}
