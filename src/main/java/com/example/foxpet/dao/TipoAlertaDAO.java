package com.example.foxpet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foxpet.model.TipoAlerta;
import com.example.foxpet.repository.TipoAlertaRepository;

@Service
public class TipoAlertaDAO {

	@Autowired
	TipoAlertaRepository tipoalertaRepository;
	
	
	public TipoAlerta save(TipoAlerta alr) {
		return tipoalertaRepository.save(alr);
	}
	

	public List<TipoAlerta> findAll(){
		return tipoalertaRepository.findAll();
	}
	

	public TipoAlerta findOne(int alr) {
	    return tipoalertaRepository.findById(alr).orElse(null);
	}
	

	public void delete(TipoAlerta alr) {
		tipoalertaRepository.delete(alr);
	}
}
