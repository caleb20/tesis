package com.tesis.vacuna.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "estadoCivil")
public class EstadoCivilEntity {

	@Column(name = "valor")
	@Id
	private String valor;
	@Column(name = "descripcion")
	private String descripcion;

}
