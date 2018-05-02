package com.example.foxpet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.foxpet.model.Comedero;

@Repository
public interface ComederoRepository extends JpaRepository<Comedero, Integer> {

}
