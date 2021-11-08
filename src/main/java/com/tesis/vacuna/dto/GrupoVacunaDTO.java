package com.tesis.vacuna.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GrupoVacunaDTO {

	@JsonIgnore
	private Integer id;
	private String edadAplica;
	private List<VacunaDTO> vacunaDTO;

	public Integer getIdEdadAplica() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEdadAplica() {
		return edadAplica;
	}

	public void setEdadAplica(String edadAplica) {
		this.edadAplica = edadAplica;
	}

	public List<VacunaDTO> getVacunaDTO() {
		return vacunaDTO;
	}

	public void setVacunaDTO(List<VacunaDTO> vacunaDTO) {
		this.vacunaDTO = vacunaDTO;
	}

}
