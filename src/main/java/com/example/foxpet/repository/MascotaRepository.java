package com.example.foxpet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.foxpet.model.Mascota;



@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer> {

}