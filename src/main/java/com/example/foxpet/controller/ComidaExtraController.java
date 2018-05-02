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
import com.example.foxpet.dao.ComidaExtraDAO;
import com.example.foxpet.model.ComidaExtra;

@RestController
@RequestMapping("/foxpet")
public class ComidaExtraController {
	
	@Autowired
	ComidaExtraDAO comidaextraoDAO;
	
	@PostMapping("/comidasextra")
	public ComidaExtra crearComidaExtra(@Valid @RequestBody ComidaExtra com) {
		return comidaextraoDAO.save(com);
	}

	@GetMapping("/comidasextra")
	public List<ComidaExtra> getAllComidasExtra(){
		return comidaextraoDAO.findAll();
	}
	
	@GetMapping("/comidasextra/{id}")
	public ResponseEntity<ComidaExtra> getComidaExtraById(@PathVariable(value = "id") int com){
		ComidaExtra emp = comidaextraoDAO.findOne(com);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);	
	}
	
	
	@DeleteMapping("/comidasextra/{id}")
	public ResponseEntity<ComidaExtra> deleteComidaExtra(@PathVariable(value="id") int comId){
		
		ComidaExtra emp=comidaextraoDAO.findOne(comId);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		comidaextraoDAO.delete(emp);
		
		return ResponseEntity.ok().build();		
	}
}
