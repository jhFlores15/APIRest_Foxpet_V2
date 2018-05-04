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

import com.example.foxpet.dao.EstablecimientoDAO;
import com.example.foxpet.model.Establecimiento;


@RestController
@RequestMapping("/foxpet")
public class EstablecimientoController {
	
	@Autowired
	EstablecimientoDAO establecimientoDAO;
	
	@PostMapping("/establecimientos")
	public Establecimiento crearEspecie(@Valid @RequestBody Establecimiento com) {
		return establecimientoDAO.save(com);
	}

	@GetMapping("/establecimientos")
	public List<Establecimiento> getAllEspecies(){
		return establecimientoDAO.findAll();
	}
	
	@GetMapping("/establecimientos/{id}")
	public ResponseEntity<Establecimiento> getEstablecimientoById(@PathVariable(value = "id") int com){
		Establecimiento emp = establecimientoDAO.findOne(com);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);	
	}
	
	@PutMapping("/establecimientos/{id}")
	public ResponseEntity<Establecimiento> updateEspecie(@PathVariable(value="id") int proId,@Valid @RequestBody Establecimiento proDetails){
		Establecimiento emp = establecimientoDAO.findOne(proId);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		emp.setNombre(proDetails.getNombre());
		Establecimiento updateEstablecimientos=establecimientoDAO.save(emp);
		return ResponseEntity.ok().body(updateEstablecimientos);
	}
	
	@DeleteMapping("/establecimientos/{id}")
	public ResponseEntity<Establecimiento> deleteEspecie(@PathVariable(value="id") int comId){
		
		Establecimiento emp=establecimientoDAO.findOne(comId);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		establecimientoDAO.delete(emp);
		
		return ResponseEntity.ok().build();		
	}
}



