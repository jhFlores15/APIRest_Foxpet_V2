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

import com.example.foxpet.dao.MascotaDAO;
import com.example.foxpet.model.Mascota;


@RestController
@RequestMapping("/foxpet")
public class MascotaController {
	
	@Autowired
	MascotaDAO mascotaDAO;
	
	@PostMapping("/mascotas")
	public Mascota crearMascota(@Valid @RequestBody Mascota com) {
		return mascotaDAO.save(com);
	}

	@GetMapping("/mascotas")
	public List<Mascota> getAllMascotas(){
		return mascotaDAO.findAll();
	}
	
	@GetMapping("/mascotas/{id}")
	public ResponseEntity<Mascota> getMascotaById(@PathVariable(value = "id") int com){
		Mascota emp = mascotaDAO.findOne(com);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);	
	}
	
	
	@DeleteMapping("/mascotas/{id}")
	public ResponseEntity<Mascota> deleteAlerta(@PathVariable(value="id") int comId){
		
		Mascota emp=mascotaDAO.findOne(comId);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		mascotaDAO.delete(emp);
		
		return ResponseEntity.ok().build();		
	}
}
