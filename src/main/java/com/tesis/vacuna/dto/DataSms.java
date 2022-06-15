package com.tesis.vacuna.dto;

import java.util.List;

import lombok.Data;

@Data
public class DataSms {

	List<MesaggeSms> messages;
	int smslargo;
	String hour;
	String delivery_date;
	int delivery_type;
	UserSms user;
}
