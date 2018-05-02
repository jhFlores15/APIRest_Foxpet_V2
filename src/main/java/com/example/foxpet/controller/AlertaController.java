package com.example.foxpet.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.foxpet.dao.AlertaDAO;
import com.example.foxpet.model.Alerta;


@RestController
@RequestMapping("/foxpet")
public class AlertaController {

	@Autowired
	AlertaDAO alertaDAO;
	
	@PostMapping("/alertas")
	public Alerta crearAlerta(@Valid @RequestBody Alerta com) {
		return alertaDAO.save(com);
	}

	@GetMapping("/alertas")
	public List<Alerta> getAllAlertas(){
		return alertaDAO.findAll();
	}
	
	@GetMapping("/alertas/{id}")
	public ResponseEntity<Alerta> getAlertaById(@PathVariable(value = "id") int com){
		Alerta emp = alertaDAO.findOne(com);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);	
	}
	
	
	@DeleteMapping("/alertas/{id}")
	public ResponseEntity<Alerta> deleteAlerta(@PathVariable(value="id") int comId){
		
		Alerta emp=alertaDAO.findOne(comId);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		alertaDAO.delete(emp);
		
		return ResponseEntity.ok().build();		
	}
}
