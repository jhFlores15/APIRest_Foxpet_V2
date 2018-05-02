package com.example.foxpet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.foxpet.model.Especie;


@Repository
public interface EspecieRepository extends JpaRepository<Especie, Integer> {

}
