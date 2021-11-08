package com.tesis.vacuna.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.Instant;
import java.util.Date;

public class Util {

	public static Date unixTimeToDate(String unixTime) {

		Instant instant = Instant.ofEpochSecond(Long.valueOf(unixTime));
		Date myDate = Date.from(instant);

		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date todayWithZeroTime;
		try {
			todayWithZeroTime = formatter.parse(formatter.format(myDate));
		} catch (ParseException e) {
			todayWithZeroTime = new Date();
		}

		return todayWithZeroTime;
	}

}
