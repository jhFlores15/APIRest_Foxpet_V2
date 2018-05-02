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

import com.example.foxpet.dao.ProvinciaDAO;
import com.example.foxpet.model.Provincia;

public class ProvinciaController {

	@RestController
	@RequestMapping("/foxpet")
	public class PronvinciaController {
		
		@Autowired
		ProvinciaDAO provinciaDAO;

		@PostMapping("/provincias")
		public Provincia crearProvincia(@Valid @RequestBody Provincia pro) {
			return provinciaDAO.save(pro);
		}

		@GetMapping("/provincias")
		public List<Provincia> getAllProvincias(){
			return provinciaDAO.findAll();
		}
		
		@GetMapping("/provincias/{id}")
		public ResponseEntity<Provincia> getProvinciaById(@PathVariable(value = "id") int pro){
			Provincia emp = provinciaDAO.findOne(pro);
			if(emp == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok().body(emp);	
		}
		
		@PutMapping("/provincias/{id}")
		public ResponseEntity<Provincia> updateProvincia(@PathVariable(value="id") int proId,@Valid @RequestBody Provincia proDetails){
			Provincia emp = provinciaDAO.findOne(proId);
			if(emp == null) {
				return ResponseEntity.notFound().build();
			}
			emp.setNombre(proDetails.getNombre());
			Provincia updateComuna=provinciaDAO.save(emp);
			return ResponseEntity.ok().body(updateComuna);
		}
		
		@DeleteMapping("/provincias/{id}")
		public ResponseEntity<Provincia> deleteProvincia(@PathVariable(value="id") int proId){
			
			Provincia emp=provinciaDAO.findOne(proId);
			if(emp==null) {
				return ResponseEntity.notFound().build();
			}
			provinciaDAO.delete(emp);
			
			return ResponseEntity.ok().build();		
		}
	}

}
