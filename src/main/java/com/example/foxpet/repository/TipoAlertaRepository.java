package com.example.foxpet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.foxpet.model.TipoAlerta;


@Repository
public interface TipoAlertaRepository extends JpaRepository<TipoAlerta, Integer> {

}
