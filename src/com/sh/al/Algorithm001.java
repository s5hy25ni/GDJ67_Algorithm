package com.sh.al;

public class Algorithm001 {

	public int solution(int n) {
		String nStr = "";
		
		while(true) {
			nStr = Integer.toString(n);
			n = 0;
			for (int i = 0; i < nStr.length()-1; i++) {
				n += Integer.parseInt(nStr.substring(i,i+1));
			}
			n += Integer.parseInt(nStr.substring(nStr.length()-1));
			if(n<10) {
				break;
			}
		}
		
		return n;

	}
}
