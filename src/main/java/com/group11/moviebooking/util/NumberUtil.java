package com.group11.moviebooking.util;



public class NumberUtil {
	public static boolean checkNumber(String data) {
		try {
			Long number = Long.parseLong(data);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
