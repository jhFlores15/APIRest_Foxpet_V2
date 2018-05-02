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

import com.example.foxpet.dao.FrecuenciaComidaDAO;
import com.example.foxpet.model.FrecuenciaComida;



@RestController
@RequestMapping("/foxpet")
public class FrecuenciaComidaController {
	
	@Autowired
	FrecuenciaComidaDAO frecuenciacomidaDAO;
	
	@PostMapping("/frecuenciacomidas")
	public FrecuenciaComida crearFrecuenciaComida(@Valid @RequestBody FrecuenciaComida com) {
		return frecuenciacomidaDAO.save(com);
	}

	@GetMapping("/frecuenciacomidas")
	public List<FrecuenciaComida> getAllFrecuenciaComida(){
		return frecuenciacomidaDAO.findAll();
	}
	
	@GetMapping("/frecuenciacomidas/{id}")
	public ResponseEntity<FrecuenciaComida> getFrecuenciaComidaById(@PathVariable(value = "id") int com){
		FrecuenciaComida emp = frecuenciacomidaDAO.findOne(com);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);	
	}
	
	@PutMapping("/frecuenciacomidas/{id}")
	public ResponseEntity<FrecuenciaComida> updateFrecuenciaComida(@PathVariable(value="id") int proId,@Valid @RequestBody FrecuenciaComida proDetails){
		FrecuenciaComida emp = frecuenciacomidaDAO.findOne(proId);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		emp.setHora_comida_id(proDetails.getHora_comida_id());
		FrecuenciaComida updateFrecuenciaComida=frecuenciacomidaDAO.save(emp);
		return ResponseEntity.ok().body(updateFrecuenciaComida);
	}
	
	@DeleteMapping("/frecuenciacomidas/{id}")
	public ResponseEntity<FrecuenciaComida> deleteFrecuenciaComida(@PathVariable(value="id") int comId){
		
		FrecuenciaComida emp=frecuenciacomidaDAO.findOne(comId);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		frecuenciacomidaDAO.delete(emp);
		
		return ResponseEntity.ok().build();		
	}
}
