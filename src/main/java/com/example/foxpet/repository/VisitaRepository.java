package com.example.foxpet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.foxpet.model.Visita;

@Repository
public interface VisitaRepository extends JpaRepository<Visita, Integer> {

}

