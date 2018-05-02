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
}
