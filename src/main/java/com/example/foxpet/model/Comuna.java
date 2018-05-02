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
@Table(name = "comuna")
@EntityListeners(AuditingEntityListener.class)
public class Comuna {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@NotBlank
    private String nombre;
    
    @NotBlank
    private int provincia_id;
    
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

	public int getProvincia_id() {
		return provincia_id;
	}

	public void setProvincia_id(int provincia_id) {
		this.provincia_id = provincia_id;
	}
	
}
