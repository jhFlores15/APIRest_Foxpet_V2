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
import com.example.foxpet.dao.RegionDAO;
import com.example.foxpet.model.Region;


	@RestController
	@RequestMapping("/foxpet")
	public class RegionController
	{
		
		@Autowired
		RegionDAO regionDAO;

		@PostMapping("/regiones")
		public Region crearRegion(@Valid @RequestBody Region reg) {
			return regionDAO.save(reg);
		}

		@GetMapping("/regiones")
		public List<Region> getAllRegiones(){
			return regionDAO.findAll();
		}
		
		@GetMapping("/regiones/{id}")
		public ResponseEntity<Region> getRegionById(@PathVariable(value = "id") int regId){
			Region emp = regionDAO.findOne(regId);
			if(emp == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok().body(emp);	
		}
		
		@PutMapping("/regiones/{id}")
		public ResponseEntity<Region> updateRegion(@PathVariable(value="id") int regId,@Valid @RequestBody Region regDetails){
			Region emp = regionDAO.findOne(regId);
			if(emp == null) {
				return ResponseEntity.notFound().build();
			}
			emp.setNombre(regDetails.getNombre());
			Region updateRegion=regionDAO.save(emp);
			return ResponseEntity.ok().body(updateRegion);
		}
		
		@DeleteMapping("/regiones/{id}")
		public ResponseEntity<Region> deleteRegion(@PathVariable(value="id") int regId){
			
			Region emp=regionDAO.findOne(regId);
			if(emp==null) {
				return ResponseEntity.notFound().build();
			}
			regionDAO.delete(emp);
			
			return ResponseEntity.ok().build();
			
		}
	}
