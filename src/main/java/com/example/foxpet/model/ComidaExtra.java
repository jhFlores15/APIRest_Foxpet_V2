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
@Table(name = "comida_extra")
@EntityListeners(AuditingEntityListener.class)
public class ComidaExtra {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Temporal(TemporalType.TIME)
    private Date hora;
	@NotNull
	private int comedero_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getComedero_id() {
		return comedero_id;
	}
	public void setComedero_id(int comedero_id) {
		this.comedero_id = comedero_id;
	}
}
