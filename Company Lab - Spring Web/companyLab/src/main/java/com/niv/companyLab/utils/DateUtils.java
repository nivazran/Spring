package com.niv.companyLab.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public static Date getDate(int dd, int mm, int yyyy) {
		try {
			return simpleDateFormat.parse(String.format("%2d/%2d/%4d", dd, mm, yyyy));
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static java.sql.Date convert(Date date) {
		return new java.sql.Date(date.getTime());
	}
}
