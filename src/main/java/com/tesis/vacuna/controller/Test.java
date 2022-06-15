package com.tesis.vacuna.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.xml.sax.SAXException;

public class Test {

	public static void main(String[] args)
			throws ClientProtocolException, IOException, ParserConfigurationException, SAXException {
		String respuesta = "";
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost("https://ws.intico.com.pe:8181/rest/webresources/envioSMS");
		List nameValuePairs = new ArrayList(1);
		nameValuePairs.add(new BasicNameValuePair("usuario", "unibanca_bulk"));
		nameValuePairs.add(new BasicNameValuePair("password", "8f46fGR9s7"));
		nameValuePairs.add(new BasicNameValuePair("celular", "987317731"));
		nameValuePairs.add(new BasicNameValuePair("mensaje", "Mensaje de Prueba"));
		nameValuePairs.add(new BasicNameValuePair("senderId", "test"));
		post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		try {
			HttpResponse response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line;
			while ((line = rd.readLine()) != null) {
				respuesta = respuesta.trim() + line.trim();
			}
			System.out.println(respuesta);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
