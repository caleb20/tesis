package com.tesis.vacuna.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "nivelEducacion")
public class NivelEducacionEntity {

	@Id
	private String valor;
	private String descripcion;

}
