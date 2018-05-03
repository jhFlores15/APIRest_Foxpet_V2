package com.example.foxpet.model;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "alerta")
@EntityListeners(AuditingEntityListener.class)
public class Alerta {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Temporal(TemporalType.TIME)
    private Date hora;
    @NotNull
	private int usuario_id;
	@NotNull
	private int tipo_alerta_id;
	
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
	public int getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}
	public int getTipo_alerta_id() {
		return tipo_alerta_id;
	}
	public void setTipo_alerta_id(int tipo_alerta_id) {
		this.tipo_alerta_id = tipo_alerta_id;
	}
}
