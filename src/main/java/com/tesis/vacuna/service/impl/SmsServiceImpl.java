package com.tesis.vacuna.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.tesis.vacuna.dto.MessageDTO;
import com.tesis.vacuna.dto.SmsDTO;
import com.tesis.vacuna.service.SmsService;

public class SmsServiceImpl implements SmsService {

	@Override
	public MessageDTO enviarSms(SmsDTO smsDTO) {

		MessageDTO messageDTO = new MessageDTO();
		messageDTO.setMensaje("Mensaje enviado correctamente");
		messageDTO.setOk(true);

		return messageDTO;
	}

	@Override
	public List<MessageDTO> recibirSms(String dniApoderado) {

		List<MessageDTO> messageDTOs = new ArrayList<>();

		MessageDTO messageDTO1 = new MessageDTO();
		messageDTO1.setMensaje("Puede responder mi duda por favor");
		messageDTO1.setOk(true);

		MessageDTO messageDTO2 = new MessageDTO();
		messageDTO2.setMensaje("Puede responder mi duda por favor 2");
		messageDTO2.setOk(true);

		messageDTOs.add(messageDTO1);
		messageDTOs.add(messageDTO2);

		return messageDTOs;
	}

}
