package com.example.foxpet.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.foxpet.model.Alerta;
import com.example.foxpet.repository.AlertaRepository;



@Service
public class AlertaDAO {
	
	@Autowired
	AlertaRepository alertaRepository;
	
	/*Guardar Comuna*/
	public Alerta save(Alerta alr) {
		return alertaRepository.save(alr);
	}
	
	/*Buscar Comuna*/
	public List<Alerta> findAll(){
		return alertaRepository.findAll();
	}
	
	/* Tomar una Comuna por Id*/
	public Alerta findOne(int alr) {
	    return alertaRepository.findById(alr).orElse(null);
	}
	
	/*Borrar Comuna*/
	public void delete(Alerta alr) {
		alertaRepository.delete(alr);
	}
}
