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

import com.example.foxpet.dao.UmbralDAO;
import com.example.foxpet.model.Umbral;

@RestController
@RequestMapping("/foxpet")
public class UmbralController {
	
	@Autowired
	UmbralDAO umbralDAO;

	@PostMapping("/umbrales")
	public Umbral crearUmbral(@Valid @RequestBody Umbral reg) {
		return umbralDAO.save(reg);
	}

	@GetMapping("/umbrales")
	public List<Umbral> getAllUmbrales(){
		return umbralDAO.findAll();
	}
	
	@GetMapping("/umbrales/{id}")
	public ResponseEntity<Umbral> getUmbralById(@PathVariable(value = "id") int regId){
		Umbral emp = umbralDAO.findOne(regId);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);	
	}
	
	@PutMapping("/umbrales/{id}")
	public ResponseEntity<Umbral> updateUmbral(@PathVariable(value="id") int regId,@Valid @RequestBody Umbral regDetails){
		Umbral emp = umbralDAO.findOne(regId);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		emp.setCantidad(regDetails.getCantidad());
		Umbral updateRegion=umbralDAO.save(emp);
		return ResponseEntity.ok().body(updateRegion);
	}
	
	@DeleteMapping("/umbrales/{id}")
	public ResponseEntity<Umbral> deleteUmbral(@PathVariable(value="id") int regId){
		
		Umbral emp=umbralDAO.findOne(regId);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		umbralDAO.delete(emp);
		
		return ResponseEntity.ok().build();
		
	}
}
