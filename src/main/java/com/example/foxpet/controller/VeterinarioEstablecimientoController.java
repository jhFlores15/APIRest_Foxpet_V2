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

import com.example.foxpet.dao.VeterinarioEstablecimientoDAO;
import com.example.foxpet.model.VeterinarioEstablecimiento;

@RestController
@RequestMapping("/foxpet")
public class VeterinarioEstablecimientoController {
	
	@Autowired
	VeterinarioEstablecimientoDAO veterinarioestablecimientoDAO;

	@PostMapping("/veterinarioestablecimiento")
	public VeterinarioEstablecimiento crearVeterinarioEstablecimiento(@Valid @RequestBody VeterinarioEstablecimiento reg) {
		return veterinarioestablecimientoDAO.save(reg);
	}

	@GetMapping("/veterinarioestablecimiento")
	public List<VeterinarioEstablecimiento> getAllVeterinarioEstablecimientos(){
		return veterinarioestablecimientoDAO.findAll();
	}
	
	@GetMapping("/veterinarioestablecimiento/{id}")
	public ResponseEntity<VeterinarioEstablecimiento> getVeterinarioEstablecimientoById(@PathVariable(value = "id") int regId){
		VeterinarioEstablecimiento emp = veterinarioestablecimientoDAO.findOne(regId);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);	
	}
	
	@PutMapping("/veterinarioestablecimiento/{id}")
	public ResponseEntity<VeterinarioEstablecimiento> updateVeterinarioEstablecimiento(@PathVariable(value="id") int regId,@Valid @RequestBody VeterinarioEstablecimiento regDetails){
		VeterinarioEstablecimiento emp = veterinarioestablecimientoDAO.findOne(regId);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		emp.setEstablecimiento_id(regDetails.getEstablecimiento_id());
		emp.setVeterinario_id(regDetails.getVeterinario_id());
		VeterinarioEstablecimiento updateRegion=veterinarioestablecimientoDAO.save(emp);
		return ResponseEntity.ok().body(updateRegion);
	}
	
	@DeleteMapping("/veterinarioestablecimiento/{id}")
	public ResponseEntity<VeterinarioEstablecimiento> deleteVeterinarioEstablecimiento(@PathVariable(value="id") int regId){
		
		VeterinarioEstablecimiento emp=veterinarioestablecimientoDAO.findOne(regId);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		veterinarioestablecimientoDAO.delete(emp);
		
		return ResponseEntity.ok().build();
		
	}
}
