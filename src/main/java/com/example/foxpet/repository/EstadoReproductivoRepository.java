package com.example.foxpet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.foxpet.model.EstadoReproductivo;



@Repository
public interface EstadoReproductivoRepository extends JpaRepository<EstadoReproductivo, Integer> {

}

