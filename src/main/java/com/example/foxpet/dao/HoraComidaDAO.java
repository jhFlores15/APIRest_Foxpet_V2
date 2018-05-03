package com.example.foxpet.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foxpet.model.HoraComida;
import com.example.foxpet.repository.HoraComidaRepository;

@Service
public class HoraComidaDAO {
	
	@Autowired
	HoraComidaRepository horacomidaRepository;
	
	
	public HoraComida save(HoraComida alr) {
		return horacomidaRepository.save(alr);
	}
	

	public List<HoraComida> findAll(){
		return horacomidaRepository.findAll();
	}
	

	public HoraComida findOne(int alr) {
	    return horacomidaRepository.findById(alr).orElse(null);
	}
	

	public void delete(HoraComida alr) {
		horacomidaRepository.delete(alr);
	}
}
