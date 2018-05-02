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


import com.example.foxpet.dao.EstadoReproductivoDAO;
import com.example.foxpet.model.EstadoReproductivo;


@RestController
@RequestMapping("/foxpet")
public class EstadoReproductivoController {
	
	@Autowired
	EstadoReproductivoDAO estadoreproductivoDAO;
	
	@PostMapping("/estadosreproductivos")
	public EstadoReproductivo crearEstadoReproductivo(@Valid @RequestBody EstadoReproductivo com) {
		return estadoreproductivoDAO.save(com);
	}

	@GetMapping("/estadosreproductivos")
	public List<EstadoReproductivo> getAllEstadosReproductivos(){
		return estadoreproductivoDAO.findAll();
	}
	
	@GetMapping("/estadosreproductivos/{id}")
	public ResponseEntity<EstadoReproductivo> getEstablecimientoById(@PathVariable(value = "id") int com){
		EstadoReproductivo emp = estadoreproductivoDAO.findOne(com);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);	
	}
	
	@PutMapping("/estadosreproductivos/{id}")
	public ResponseEntity<EstadoReproductivo> updateEspecie(@PathVariable(value="id") int proId,@Valid @RequestBody EstadoReproductivo proDetails){
		EstadoReproductivo emp = estadoreproductivoDAO.findOne(proId);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		emp.setNombre(proDetails.getNombre());
		EstadoReproductivo updateEstadoReproductivo=estadoreproductivoDAO.save(emp);
		return ResponseEntity.ok().body(updateEstadoReproductivo);
	}
	
	@DeleteMapping("/estadosreproductivos/{id}")
	public ResponseEntity<EstadoReproductivo> deleteupdateEstadoReproductivo(@PathVariable(value="id") int comId){
		
		EstadoReproductivo emp=estadoreproductivoDAO.findOne(comId);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		estadoreproductivoDAO.delete(emp);
		
		return ResponseEntity.ok().build();		
	}
}
