package com.example.foxpet.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "visita")
@EntityListeners(AuditingEntityListener.class)
public class Visita {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
    @NotNull
	private int mascota_id;
	@NotNull
	private int veterinario_id;
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date fecha;
	@NotNull
	@Temporal(TemporalType.TIME)
	private Date hora;
	@NotNull
	private String asunto;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMascota_id() {
		return mascota_id;
	}
	public void setMascota_id(int mascota_id) {
		this.mascota_id = mascota_id;
	}
	public int getVeterinario_id() {
		return veterinario_id;
	}
	public void setVeterinario_id(int veterinario_id) {
		this.veterinario_id = veterinario_id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}	
}
