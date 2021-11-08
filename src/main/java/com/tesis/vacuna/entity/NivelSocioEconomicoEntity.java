package com.tesis.vacuna.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nivelSocioeconomico")
public class NivelSocioEconomicoEntity {

	@Id
	private String valor;

	private String descripcion;
	
	private Integer ingresoPromedio;
	
	private String tipoVivienda;

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getIngresoPromedio() {
		return ingresoPromedio;
	}

	public void setIngresoPromedio(Integer ingresoPromedio) {
		this.ingresoPromedio = ingresoPromedio;
	}

	public String getTipoVivienda() {
		return tipoVivienda;
	}

	public void setTipoVivienda(String tipoVivienda) {
		this.tipoVivienda = tipoVivienda;
	}
	
	

}
