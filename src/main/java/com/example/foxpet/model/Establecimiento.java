package com.example.foxpet.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "establecimiento")
@EntityListeners(AuditingEntityListener.class)
public class Establecimiento {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
	
	@NotBlank
    private String nombre;
	
	@NotBlank
	private int comuna_id;

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

	public int getComuna_id() {
		return comuna_id;
	}

	public void setComuna_id(int comuna_id) {
		this.comuna_id = comuna_id;
	}

}
