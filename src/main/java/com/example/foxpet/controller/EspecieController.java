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
import com.example.foxpet.dao.EspecieDAO;
import com.example.foxpet.model.Especie;



@RestController
@RequestMapping("/foxpet")
public class EspecieController {
	
	@Autowired
	EspecieDAO especieDAO;
	
	@PostMapping("/especies")
	public Especie crearEspecie(@Valid @RequestBody Especie com) {
		return especieDAO.save(com);
	}

	@GetMapping("/especies")
	public List<Especie> getAllEspecies(){
		return especieDAO.findAll();
	}
	
	@GetMapping("/especies/{id}")
	public ResponseEntity<Especie> getEspecieById(@PathVariable(value = "id") int com){
		Especie emp = especieDAO.findOne(com);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);	
	}
	
	@PutMapping("/especies/{id}")
	public ResponseEntity<Especie> updateEspecie(@PathVariable(value="id") int proId,@Valid @RequestBody Especie proDetails){
		Especie emp = especieDAO.findOne(proId);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		emp.setNombre(proDetails.getNombre());
		Especie updateComuna=especieDAO.save(emp);
		return ResponseEntity.ok().body(updateComuna);
	}
	
	@DeleteMapping("/especies/{id}")
	public ResponseEntity<Especie> deleteAlerta(@PathVariable(value="id") int comId){
		
		Especie emp=especieDAO.findOne(comId);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		especieDAO.delete(emp);
		
		return ResponseEntity.ok().build();		
	}
}
