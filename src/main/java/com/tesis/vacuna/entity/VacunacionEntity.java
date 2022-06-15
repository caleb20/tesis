package com.tesis.vacuna.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "vacunacion")
public class VacunacionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	private String lote;
	private String dniHijo;
	private int idVacuna;
	private Date fechaCita;
	private Date fecha;
	private int idUbicacion;
	private String dniVacunador;
	private String reaccion;
	private String estado;

}
