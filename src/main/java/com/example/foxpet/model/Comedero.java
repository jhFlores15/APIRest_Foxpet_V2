package com.example.foxpet.model;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "comedero")
@EntityListeners(AuditingEntityListener.class)
public class Comedero {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
	
	@NotNull
	private int mascota_id;
	
	@NotNull
	@Temporal(TemporalType.TIME)
	private Date hora_default;

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

	public Date getHora_default() {
		return hora_default;
	}

	public void setHora_default(Date hora_default) {
		this.hora_default = hora_default;
	}

}
