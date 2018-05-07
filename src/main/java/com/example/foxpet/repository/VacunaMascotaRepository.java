package com.example.foxpet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.foxpet.model.VacunaMascota;



@Repository
public interface VacunaMascotaRepository extends JpaRepository<VacunaMascota, Integer> {

}
