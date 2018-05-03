package com.example.foxpet.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "hora_comida")
@EntityListeners(AuditingEntityListener.class)
public class HoraComida {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
  
	@NotNull
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
