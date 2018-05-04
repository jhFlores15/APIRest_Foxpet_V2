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
@Table(name = "umbral")
@EntityListeners(AuditingEntityListener.class)
public class Umbral {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@NotBlank
    private int cantidad;
    
    @NotBlank
    private int tipo_alerta_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getTipo_alerta_id() {
		return tipo_alerta_id;
	}

	public void setTipo_alerta_id(int tipo_alerta_id) {
		this.tipo_alerta_id = tipo_alerta_id;
	}
}
