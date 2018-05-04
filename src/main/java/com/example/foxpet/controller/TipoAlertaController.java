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

import com.example.foxpet.dao.TipoAlertaDAO;
import com.example.foxpet.model.TipoAlerta;


@RestController
@RequestMapping("/foxpet")
public class TipoAlertaController {

	@Autowired
	TipoAlertaDAO tipoalertaDAO;
	
	@PostMapping("/tipoalertas")
	public TipoAlerta crearTipoAlerta(@Valid @RequestBody TipoAlerta com) {
		return tipoalertaDAO.save(com);
	}

	@GetMapping("/tipoalertas")
	public List<TipoAlerta> getAllTipoAlertas(){
		return tipoalertaDAO.findAll();
	}
	
	@GetMapping("/tipoalertas/{id}")
	public ResponseEntity<TipoAlerta> getTipoAlertaById(@PathVariable(value = "id") int com){
		TipoAlerta emp = tipoalertaDAO.findOne(com);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);	
	}
	
	
	@DeleteMapping("/tipoalertas/{id}")
	public ResponseEntity<TipoAlerta> deleteTipoAlerta(@PathVariable(value="id") int comId){
		
		TipoAlerta emp=tipoalertaDAO.findOne(comId);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		tipoalertaDAO.delete(emp);
		
		return ResponseEntity.ok().build();		
	}
}
