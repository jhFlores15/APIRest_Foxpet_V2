package com.example.foxpet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.foxpet.model.Raza;


@Repository
public interface RazaRepository extends JpaRepository<Raza, Integer> {

}
