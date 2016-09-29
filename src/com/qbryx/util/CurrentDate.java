package com.qbryx.util;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Calendar;

public class CurrentDate {

	public static Date getCurrentDate(){
		return new java.sql.Date(Calendar.getInstance().getTime().getTime());
	}
	
	public static void main(String[] args){
		System.out.println(getCurrentDate());
	}
}
