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

import com.example.foxpet.dao.VeterinarioDAO;
import com.example.foxpet.model.Veterinario;

@RestController
@RequestMapping("/foxpet")
public class VeterinarioController {
		
	@Autowired
	VeterinarioDAO veterinarioDAO;

	@PostMapping("/veterinarios")
	public Veterinario crearVeterinario(@Valid @RequestBody Veterinario reg) {
		return veterinarioDAO.save(reg);
	}

	@GetMapping("/veterinarios")
	public List<Veterinario> getAllVeterinarios(){
		return veterinarioDAO.findAll();
	}
	
	@GetMapping("/veterinarios/{id}")
	public ResponseEntity<Veterinario> getVeterinarioById(@PathVariable(value = "id") int regId){
		Veterinario emp = veterinarioDAO.findOne(regId);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);	
	}
	
	@PutMapping("/veterinarios/{id}")
	public ResponseEntity<Veterinario> updateVeterinario(@PathVariable(value="id") int regId,@Valid @RequestBody Veterinario regDetails){
		Veterinario emp = veterinarioDAO.findOne(regId);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		emp.setNombre(regDetails.getNombre());
		Veterinario updateVeterinario = veterinarioDAO.save(emp);
		return ResponseEntity.ok().body(updateVeterinario);
	}
	
	@DeleteMapping("/veterinarios/{id}")
	public ResponseEntity<Veterinario> deleteVeterinario(@PathVariable(value="id") int regId){
		
		Veterinario emp=veterinarioDAO.findOne(regId);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		veterinarioDAO.delete(emp);
		
		return ResponseEntity.ok().build();
	}
}
