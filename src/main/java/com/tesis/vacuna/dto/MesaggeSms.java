package com.tesis.vacuna.dto;

import lombok.Data;

@Data
public class MesaggeSms {
	int correlative;
	String phone;
	String message;
	String rut;
}
