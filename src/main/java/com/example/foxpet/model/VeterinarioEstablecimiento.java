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
@Table(name = "veterinario_almacenamiento")
@EntityListeners(AuditingEntityListener.class)

public class VeterinarioEstablecimiento {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
	
	@NotBlank
    private int establecimiento_id;
	
	@NotBlank
    private int veterinario_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEstablecimiento_id() {
		return establecimiento_id;
	}

	public void setEstablecimiento_id(int establecimiento_id) {
		this.establecimiento_id = establecimiento_id;
	}

	public int getVeterinario_id() {
		return veterinario_id;
	}

	public void setVeterinario_id(int veterinario_id) {
		this.veterinario_id = veterinario_id;
	}	
}
