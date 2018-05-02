package com.example.foxpet.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "frecuencia_comida")
@EntityListeners(AuditingEntityListener.class)
public class FrecuenciaComida {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
    @NotNull
	private int hora_comida_id;
	@NotNull
	private int comedero_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHora_comida_id() {
		return hora_comida_id;
	}
	public void setHora_comida_id(int hora_comida_id) {
		this.hora_comida_id = hora_comida_id;
	}
	public int getComedero_id() {
		return comedero_id;
	}
	public void setComedero_id(int comedero_id) {
		this.comedero_id = comedero_id;
	}
	
}
