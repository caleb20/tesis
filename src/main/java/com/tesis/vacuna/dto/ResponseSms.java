package com.tesis.vacuna.dto;

public class ResponseSms {
	int resp_cod;
	String resp_msg;
	String FileRegister;

	public int getResp_cod() {
		return resp_cod;
	}

	public void setResp_cod(int resp_cod) {
		this.resp_cod = resp_cod;
	}

	public String getResp_msg() {
		return resp_msg;
	}

	public void setResp_msg(String resp_msg) {
		this.resp_msg = resp_msg;
	}

	public String getFileRegister() {
		return FileRegister;
	}

	public void setFileRegister(String fileRegister) {
		FileRegister = fileRegister;
	}

}
