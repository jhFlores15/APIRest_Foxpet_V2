package com.example.foxpet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.foxpet.model.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}