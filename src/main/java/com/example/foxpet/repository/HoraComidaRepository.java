package com.example.foxpet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.foxpet.model.HoraComida;


@Repository
public interface HoraComidaRepository extends JpaRepository<HoraComida, Integer> {

}

