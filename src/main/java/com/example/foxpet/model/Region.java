package com.example.foxpet.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "region")
@EntityListeners(AuditingEntityListener.class)

public class Region {

	@Id
	/* IDENTITY utiliza AUTOINCREMENT nativo mysql*//* AUTO utiliza AUTOINCREMENT Hibernate creando tabla hibernate_sequence*/
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;

    @NotBlank
    private String nombre;

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

}
