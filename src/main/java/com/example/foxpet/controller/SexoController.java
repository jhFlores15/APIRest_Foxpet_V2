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

import com.example.foxpet.dao.SexoDAO;
import com.example.foxpet.model.Sexo;


@RestController
@RequestMapping("/foxpet")

public class SexoController {
	
		@Autowired
		SexoDAO sexoDAO;
		
		@PostMapping("/sexos")
		public Sexo crearSexo(@Valid @RequestBody Sexo com) {
			return sexoDAO.save(com);
		}

		@GetMapping("/sexos")
		public List<Sexo> getAllAlertas(){
			return sexoDAO.findAll();
		}
		
		@GetMapping("/sexos/{id}")
		public ResponseEntity<Sexo> getSexoById(@PathVariable(value = "id") int com){
			Sexo emp = sexoDAO.findOne(com);
			if(emp == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok().body(emp);	
		}
		
		
		@DeleteMapping("/sexos/{id}")
		public ResponseEntity<Sexo> deleteSexo(@PathVariable(value="id") int comId){
			
			Sexo emp=sexoDAO.findOne(comId);
			if(emp==null) {
				return ResponseEntity.notFound().build();
			}
			sexoDAO.delete(emp);
			
			return ResponseEntity.ok().build();		
		}
}
