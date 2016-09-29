package com.qbryx.util;

import java.text.SimpleDateFormat;
import java.sql.Date;

public class CurrentDate {

	public static Date getCurrentDate(){
		return new Date(0);
	}
	
	public static void main(String[] args){
		System.out.println(getCurrentDate());
	}
}
