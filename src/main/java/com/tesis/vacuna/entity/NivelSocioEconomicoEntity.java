package com.tesis.vacuna.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "nivelSocioeconomico")
public class NivelSocioEconomicoEntity {

	@Id
	private String valor;
	private String descripcion;
	private Integer ingresoPromedio;
	private String tipoVivienda;

}
