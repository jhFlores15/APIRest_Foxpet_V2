package com.example.foxpet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.foxpet.model.Establecimiento;


@Repository
public interface EstablecimientoRepository extends JpaRepository<Establecimiento, Integer> {

}
