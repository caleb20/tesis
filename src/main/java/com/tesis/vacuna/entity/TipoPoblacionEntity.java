package com.tesis.vacuna.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tipoPoblacion")
public class TipoPoblacionEntity {

	@Id
	private String valor;
	private String descripcion;

}
