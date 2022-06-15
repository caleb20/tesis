package com.tesis.vacuna.service;

import java.util.List;

import com.tesis.vacuna.dto.MessageDTO;
import com.tesis.vacuna.dto.SmsDTO;

public interface SmsService {

	public MessageDTO enviarSms(SmsDTO smsDTO);

	public List<MessageDTO> recibirSms(String dniApoderado);
}
