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
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "vacuna_mascota")
@EntityListeners(AuditingEntityListener.class)
public class VacunaMascota {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
	
	@NotBlank
    private int mascota_id;
	
	@NotBlank
    private int vacuna_id;
	
	@Temporal(TemporalType.DATE)
    private Date fecha;

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

	public int getVacuna_id() {
		return vacuna_id;
	}

	public void setVacuna_id(int vacuna_id) {
		this.vacuna_id = vacuna_id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
