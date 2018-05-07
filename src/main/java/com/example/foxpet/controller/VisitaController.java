package com.example.foxpet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.foxpet.dao.VisitaDAO;
import com.example.foxpet.model.Visita;


@RestController
@RequestMapping("/foxpet")
public class VisitaController {
	
	@Autowired
	VisitaDAO visitaDAO;

	@PostMapping("/visitas")
	public Visita crearVisita(@Valid @RequestBody Visita reg) {
		return visitaDAO.save(reg);
	}

	@GetMapping("/visitas")
	public List<Visita> getAllVisitas(){
		return visitaDAO.findAll();
	}
	
	@GetMapping("/visitas/{id}")
	public ResponseEntity<Visita> getVisitaById(@PathVariable(value = "id") int regId){
		Visita emp = visitaDAO.findOne(regId);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);	
	}
	
	@PutMapping("/visitas/{id}")
	public ResponseEntity<Visita> updateVisita(@PathVariable(value="id") int regId,@Valid @RequestBody Visita regDetails){
		Visita emp = visitaDAO.findOne(regId);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		emp.setAsunto(regDetails.getAsunto());
		emp.setFecha(regDetails.getFecha());
		emp.setHora(regDetails.getHora());
		emp.setVeterinario_id(regDetails.getVeterinario_id());
		Visita updateVeterinario = visitaDAO.save(emp);
		return ResponseEntity.ok().body(updateVeterinario);
	}
	
	@DeleteMapping("/visitas/{id}")
	public ResponseEntity<Visita> deleteVisita(@PathVariable(value="id") int regId){
		
		Visita emp=visitaDAO.findOne(regId);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		visitaDAO.delete(emp);
		
		return ResponseEntity.ok().build();
	}
}
