package com.example.foxpet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.foxpet.model.Umbral;

@Repository
public interface UmbralRepository extends JpaRepository<Umbral, Integer> {

}