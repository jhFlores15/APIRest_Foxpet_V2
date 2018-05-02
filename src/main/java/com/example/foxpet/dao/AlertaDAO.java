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
	
	
	public Alerta save(Alerta alr) {
		return alertaRepository.save(alr);
	}
	

	public List<Alerta> findAll(){
		return alertaRepository.findAll();
	}
	

	public Alerta findOne(int alr) {
	    return alertaRepository.findById(alr).orElse(null);
	}
	

	public void delete(Alerta alr) {
		alertaRepository.delete(alr);
	}
}
