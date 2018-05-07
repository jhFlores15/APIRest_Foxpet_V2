package com.example.foxpet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.foxpet.model.Vacuna;



@Repository
public interface VacunaRepository extends JpaRepository<Vacuna, Integer> {

}