package com.example.foxpet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.foxpet.model.FrecuenciaComida;

@Repository
public interface FrecuenciaComidaRepository extends JpaRepository<FrecuenciaComida, Integer> {

}
