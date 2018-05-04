package com.example.foxpet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foxpet.model.Usuario;
import com.example.foxpet.repository.UsuarioRepository;

@Service
public class UsuarioDAO {


	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	public Usuario save(Usuario alr) {
		return usuarioRepository.save(alr);
	}
	

	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	

	public Usuario findOne(int alr) {
	    return usuarioRepository.findById(alr).orElse(null);
	}
	

	public void delete(Usuario alr) {
		usuarioRepository.delete(alr);
	}
}
