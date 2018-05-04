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

import com.example.foxpet.dao.UsuarioDAO;
import com.example.foxpet.model.Usuario;



@RestController
@RequestMapping("/foxpet")
public class UsuarioController {
	
	@Autowired
	UsuarioDAO usuarioDAO;

	@PostMapping("/usuarios")
	public Usuario crearUsuario(@Valid @RequestBody Usuario reg) {
		return usuarioDAO.save(reg);
	}

	@GetMapping("/usuarios")
	public List<Usuario> getAllUsuarios(){
		return usuarioDAO.findAll();
	}
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable(value = "id") int regId){
		Usuario emp = usuarioDAO.findOne(regId);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);	
	}
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable(value="id") int regId,@Valid @RequestBody Usuario regDetails){
		Usuario emp = usuarioDAO.findOne(regId);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		emp.setNombre(regDetails.getNombre());
		emp.setApellido(regDetails.getApellido());
		emp.setComuna_id(regDetails.getComuna_id());
		emp.setDireccion(regDetails.getDireccion());
		emp.setEmail(regDetails.getEmail());
		emp.setNombreusuario(regDetails.getNombreusuario());
		emp.setPassword(regDetails.getPassword());
		Usuario updateUsuario=usuarioDAO.save(emp);
		return ResponseEntity.ok().body(updateUsuario);
	}
	
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> deleteUsuario(@PathVariable(value="id") int regId){
		
		Usuario emp=usuarioDAO.findOne(regId);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		usuarioDAO.delete(emp);
		
		return ResponseEntity.ok().build();
		
	}
}
