package com.sh.al;

public class Algorithm003 {
	
	public int calString(String str) {
		String cycle = "";
		String temp = str;
		String regex = "";
		
		for (int i = 0; i < str.length(); i++) {
			cycle += str.charAt(i);
			if(str.length()/cycle.length()!=0) {
				continue;
			}
			regex = 
			temp.replaceAll(regex, cycle);
			
		}

		return str.length();
	}
}
