package com.example.foxpet.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "especie")
@EntityListeners(AuditingEntityListener.class)
public class Especie {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
	
	@NotBlank
    private String nombre;
	
	@NotBlank
	private int raza_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getRaza_id() {
		return raza_id;
	}

	public void setRaza_id(int raza_id) {
		this.raza_id = raza_id;
	}	
}
