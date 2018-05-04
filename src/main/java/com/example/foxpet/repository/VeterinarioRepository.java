package com.example.foxpet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.foxpet.model.Veterinario;


@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer> {

}
