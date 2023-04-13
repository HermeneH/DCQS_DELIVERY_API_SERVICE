package com.bsva.dcqs.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
	
	private LocalDate today = LocalDate.now();
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
	
	public String getYesterdayDate()
	{
		String yesterday = (today.minusDays(1)).format(formatter);
		return yesterday;
		
	}

}
