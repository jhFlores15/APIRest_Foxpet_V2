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

import com.example.foxpet.dao.HoraComidaDAO;
import com.example.foxpet.model.HoraComida;


@RestController
@RequestMapping("/foxpet")
public class HoraComidaController {
	
	@Autowired
	HoraComidaDAO horacomidaDAO;
	
	@PostMapping("/horacomidas")
	public HoraComida crearHoraComida(@Valid @RequestBody HoraComida com) {
		return horacomidaDAO.save(com);
	}

	@GetMapping("/horacomidas")
	public List<HoraComida> getAllHoraComidas(){
		return horacomidaDAO.findAll();
	}
	
	@GetMapping("/horacomidas/{id}")
	public ResponseEntity<HoraComida> getHoraComidaById(@PathVariable(value = "id") int com){
		HoraComida emp = horacomidaDAO.findOne(com);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);	
	}
	
	
	@DeleteMapping("/horacomidas/{id}")
	public ResponseEntity<HoraComida> deleteHoraComida(@PathVariable(value="id") int comId){
		
		HoraComida emp=horacomidaDAO.findOne(comId);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		horacomidaDAO.delete(emp);
		
		return ResponseEntity.ok().build();		
	}
}
