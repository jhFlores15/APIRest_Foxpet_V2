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
@Table(name = "usuario")
@EntityListeners(AuditingEntityListener.class)
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@NotBlank
    private String nombre;
	
	@NotBlank
    private String apellido;

	@NotBlank
    private String email;
	
	@NotBlank
    private String direccion;
	
	@NotBlank
    private String nombreusuario;
	
	@NotBlank
    private String password;
	
	@NotBlank
    private int tipo_usuario_id;
	
	@NotBlank
    private int comuna_id;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombreusuario() {
		return nombreusuario;
	}

	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTipo_usuario_id() {
		return tipo_usuario_id;
	}

	public void setTipo_usuario_id(int tipo_usuario_id) {
		this.tipo_usuario_id = tipo_usuario_id;
	}

	public int getComuna_id() {
		return comuna_id;
	}

	public void setComuna_id(int comuna_id) {
		this.comuna_id = comuna_id;
	}
	
	
}
