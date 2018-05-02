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

import com.example.foxpet.dao.ComederoDAO;
import com.example.foxpet.model.Comedero;

@RestController
@RequestMapping("/foxpet")
public class ComederoController {
	
	@Autowired
	ComederoDAO comederoDAO;
	
	@PostMapping("/comederos")
	public Comedero crearComedero(@Valid @RequestBody Comedero com) {
		return comederoDAO.save(com);
	}

	@GetMapping("/comederos")
	public List<Comedero> getAllComederos(){
		return comederoDAO.findAll();
	}
	
	@GetMapping("/comederos/{id}")
	public ResponseEntity<Comedero> getComederoById(@PathVariable(value = "id") int com){
		Comedero emp = comederoDAO.findOne(com);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);	
	}
	
	@PutMapping("/comederos/{id}")
	public ResponseEntity<Comedero> updateComedero(@PathVariable(value="id") int comId,@Valid @RequestBody Comedero comDetails){
		Comedero emp = comederoDAO.findOne(comId);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		emp.setHora_default(comDetails.getHora_default());
		Comedero updateComedero=comederoDAO.save(emp);
		return ResponseEntity.ok().body(updateComedero);
	}
	
	@DeleteMapping("/comederos/{id}")
	public ResponseEntity<Comedero> deleteComedero(@PathVariable(value="id") int comId){
		
		Comedero emp=comederoDAO.findOne(comId);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		comederoDAO.delete(emp);
		
		return ResponseEntity.ok().build();		
	}
}
