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

import com.example.foxpet.dao.VacunaMascotaDAO;
import com.example.foxpet.model.VacunaMascota;


@RestController
@RequestMapping("/foxpet")
public class VacunaMascotaController {
	
		@Autowired
		VacunaMascotaDAO vacunamascotaDAO;

		@PostMapping("/vacunamascotas")
		public VacunaMascota crearVacunaMascota(@Valid @RequestBody VacunaMascota reg) {
			return vacunamascotaDAO.save(reg);
		}

		@GetMapping("/vacunamascotas")
		public List<VacunaMascota> getAllRegiones(){
			return vacunamascotaDAO.findAll();
		}
		
		@GetMapping("/vacunamascotas/{id}")
		public ResponseEntity<VacunaMascota> getVacunaMascotaById(@PathVariable(value = "id") int regId){
			VacunaMascota emp = vacunamascotaDAO.findOne(regId);
			if(emp == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok().body(emp);	
		}
		
		@PutMapping("/vacunamascotas/{id}")
		public ResponseEntity<VacunaMascota> updateVacunaMascota(@PathVariable(value="id") int regId,@Valid @RequestBody VacunaMascota regDetails){
			VacunaMascota emp = vacunamascotaDAO.findOne(regId);
			if(emp == null) {
				return ResponseEntity.notFound().build();
			}
			emp.setFecha(regDetails.getFecha());
			VacunaMascota updateVacunaMascota=vacunamascotaDAO.save(emp);
			return ResponseEntity.ok().body(updateVacunaMascota);
		}
		
		@DeleteMapping("/vacunamascotas/{id}")
		public ResponseEntity<VacunaMascota> deleteVacunaMascota(@PathVariable(value="id") int regId){
			
			VacunaMascota emp=vacunamascotaDAO.findOne(regId);
			if(emp==null) {
				return ResponseEntity.notFound().build();
			}
			vacunamascotaDAO.delete(emp);
			
			return ResponseEntity.ok().build();			
		}
}
