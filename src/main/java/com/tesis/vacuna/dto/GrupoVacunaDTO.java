package com.tesis.vacuna.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class GrupoVacunaDTO {

	@JsonIgnore
	private Integer id;
	private String edadAplica;
	private List<VacunaDTO> vacunaDTO;

}
