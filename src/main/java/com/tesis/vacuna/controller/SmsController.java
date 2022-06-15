package com.tesis.vacuna.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.tesis.vacuna.dto.DataSms;
import com.tesis.vacuna.dto.MesaggeSms;
import com.tesis.vacuna.dto.ResponseSms;
import com.tesis.vacuna.dto.SmsBulk;
import com.tesis.vacuna.dto.UserSms;

@RestController
@RequestMapping("/sms")
public class SmsController {

	@GetMapping("/enviar")
	public String enviarSms() {

		SmsBulk smsBulk = new SmsBulk();
		DataSms dataSms = new DataSms();
		List<MesaggeSms> lisMesaggeSms = new ArrayList<>();
		MesaggeSms mesaggeSms = new MesaggeSms();
		UserSms userSms = new UserSms();

		smsBulk.setApi_key("J274bMdKCjx/J3JkHdglXGOjs3NpnMz5k3EfjuQCyZw=");

		mesaggeSms.setCorrelative(5);
		mesaggeSms.setPhone("987317731");
		mesaggeSms.setMessage("enviado desde el la aplicacion 2");
		mesaggeSms.setRut("12345");
		lisMesaggeSms.add(mesaggeSms);

		dataSms.setMessages(lisMesaggeSms);
		dataSms.setSmslargo(0);
		dataSms.setHour("16:30:00");
		dataSms.setDelivery_date("24/10/2019");
		dataSms.setDelivery_type(0);

		userSms.setUser_id(50052);
		dataSms.setUser(userSms);

		smsBulk.setData(dataSms);

		System.out.println(new Gson().toJson(smsBulk));

		RestTemplate restTemplate = new RestTemplate();

		final String fooResourceUrl = "http://sms.intico.com.pe:8182/api/sms_bulk";
		ResponseEntity<String> response = restTemplate.postForEntity(fooResourceUrl, smsBulk, String.class);

		Gson gson = new Gson();

		ResponseSms responseSms = gson.fromJson(response.getBody(), ResponseSms.class);

		return responseSms.getFileRegister();
	}

}
