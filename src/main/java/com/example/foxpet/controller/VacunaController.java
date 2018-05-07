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

import com.example.foxpet.dao.VacunaDAO;
import com.example.foxpet.model.Vacuna;


@RestController
@RequestMapping("/foxpet")
public class VacunaController {
	
	@Autowired
	VacunaDAO vacunaDAO;

	@PostMapping("/vacunas")
	public Vacuna crearVacuna(@Valid @RequestBody Vacuna reg) {
		return vacunaDAO.save(reg);
	}

	@GetMapping("/vacunas")
	public List<Vacuna> getAllVacunas(){
		return vacunaDAO.findAll();
	}
	
	@GetMapping("/vacunas/{id}")
	public ResponseEntity<Vacuna> getVacunaById(@PathVariable(value = "id") int regId){
		Vacuna emp = vacunaDAO.findOne(regId);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);	
	}
	
	@PutMapping("/vacunas/{id}")
	public ResponseEntity<Vacuna> updateVacuna(@PathVariable(value="id") int regId,@Valid @RequestBody Vacuna regDetails){
		Vacuna emp = vacunaDAO.findOne(regId);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		emp.setNombre(regDetails.getNombre());	
		Vacuna updateUsuario=vacunaDAO.save(emp);
		return ResponseEntity.ok().body(updateUsuario);
	}
	
	@DeleteMapping("/vacunas/{id}")
	public ResponseEntity<Vacuna> deleteVacuna(@PathVariable(value="id") int regId){
		
		Vacuna emp=vacunaDAO.findOne(regId);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		vacunaDAO.delete(emp);
		return ResponseEntity.ok().build();		
	}
}
