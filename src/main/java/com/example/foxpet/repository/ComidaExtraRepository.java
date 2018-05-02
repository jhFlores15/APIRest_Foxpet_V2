package com.example.foxpet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.foxpet.model.ComidaExtra;



@Repository
public interface ComidaExtraRepository extends JpaRepository<ComidaExtra, Integer> {

}
