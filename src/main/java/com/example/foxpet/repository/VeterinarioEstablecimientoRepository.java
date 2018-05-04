package com.example.foxpet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.foxpet.model.VeterinarioEstablecimiento;


@Repository
public interface VeterinarioEstablecimientoRepository extends JpaRepository< VeterinarioEstablecimiento, Integer> {

}