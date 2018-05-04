package com.example.foxpet.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "veterinario")
@EntityListeners(AuditingEntityListener.class)
public class Veterinario {
	
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
		
		@NotBlank
	    private String nombre;
	    
	    @NotBlank
	    private String apellido;

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
}
