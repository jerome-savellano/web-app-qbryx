package com.qbryx.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDate {

	public static Date getCurrentDate(){
		return new Date();
	}
	
	public static void main(String[] args){
		System.out.println(getCurrentDate());
	}
}
