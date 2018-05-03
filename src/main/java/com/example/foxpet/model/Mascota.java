package com.example.foxpet.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "mascota")
@EntityListeners(AuditingEntityListener.class)
public class Mascota {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;

    @NotBlank
    private String nombre;
    
    @NotBlank
    private int usuario_id;
    
    @NotBlank
    private int especie_id;
    
    @Temporal(TemporalType.DATE)
    private Date fecha_nacimiento;
    
    @NotBlank
    private int sexo_id;
    
    @NotBlank
    private int estado_reproductivo_id;

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

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	public int getEspecie_id() {
		return especie_id;
	}

	public void setEspecie_id(int especie_id) {
		this.especie_id = especie_id;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public int getSexo_id() {
		return sexo_id;
	}

	public void setSexo_id(int sexo_id) {
		this.sexo_id = sexo_id;
	}

	public int getEstado_reproductivo_id() {
		return estado_reproductivo_id;
	}

	public void setEstado_reproductivo_id(int estado_reproductivo_id) {
		this.estado_reproductivo_id = estado_reproductivo_id;
	} 
}
