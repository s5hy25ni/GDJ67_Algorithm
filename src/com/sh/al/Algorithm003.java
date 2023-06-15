package com.sh.al;

public class Algorithm003 {
	
	public int solution(String str) {
		
		int len = str.length();
		String cycle = "";
		String temp;
		
		for (int i = 0; i < len/2; i++) {
			temp = "";
			cycle += str.charAt(i);
			for (int j = 0; j < len/cycle.length(); j++) {
				temp += cycle;
			}
			if(temp.equals(str)) {
				return cycle.length();
			}
		}	
		return str.length();
	}
}
