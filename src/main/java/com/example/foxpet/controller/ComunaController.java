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
import com.example.foxpet.dao.ComunaDAO;
import com.example.foxpet.model.Comuna;


@RestController
@RequestMapping("/foxpet")
public class ComunaController {
	
	
	@Autowired
	ComunaDAO comunaDAO;

	@PostMapping("/comunas")
	public Comuna crearComuna(@Valid @RequestBody Comuna com) {
		return comunaDAO.save(com);
	}

	@GetMapping("/comunas")
	public List<Comuna> getAllComunas(){
		return comunaDAO.findAll();
	}
	
	@GetMapping("/comunas/{id}")
	public ResponseEntity<Comuna> getComunaById(@PathVariable(value = "id") int com){
		Comuna emp = comunaDAO.findOne(com);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);	
	}
	
	@PutMapping("/comunas/{id}")
	public ResponseEntity<Comuna> updateComuna(@PathVariable(value="id") int comId,@Valid @RequestBody Comuna comDetails){
		Comuna emp = comunaDAO.findOne(comId);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		emp.setNombre(comDetails.getNombre());
		Comuna updateComuna=comunaDAO.save(emp);
		return ResponseEntity.ok().body(updateComuna);
	}
	
	@DeleteMapping("/comunas/{id}")
	public ResponseEntity<Comuna> deleteComuna(@PathVariable(value="id") int comId){
		
		Comuna emp=comunaDAO.findOne(comId);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		comunaDAO.delete(emp);
		
		return ResponseEntity.ok().build();		
	}
}
