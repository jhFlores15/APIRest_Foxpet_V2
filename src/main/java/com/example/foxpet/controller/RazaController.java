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

import com.example.foxpet.dao.RazaDAO;
import com.example.foxpet.model.Raza;


@RestController
@RequestMapping("/foxpet")
public class RazaController {

	@Autowired
	RazaDAO razaDAO;
	
	@PostMapping("/razas")
	public Raza crearRaza(@Valid @RequestBody Raza com) {
		return razaDAO.save(com);
	}

	@GetMapping("/alertas")
	public List<Raza> getAllRaza(){
		return razaDAO.findAll();
	}
	
	@GetMapping("/alertas/{id}")
	public ResponseEntity<Raza> getRazaById(@PathVariable(value = "id") int com){
		Raza emp = razaDAO.findOne(com);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);	
	}
	
	
	@DeleteMapping("/alertas/{id}")
	public ResponseEntity<Raza> deleteRaza(@PathVariable(value="id") int comId){
		
		Raza emp=razaDAO.findOne(comId);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		razaDAO.delete(emp);
		
		return ResponseEntity.ok().build();		
	}
}
