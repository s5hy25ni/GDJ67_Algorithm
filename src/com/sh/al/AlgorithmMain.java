package com.sh.al;

public class AlgorithmMain {

	public static void main(String[] args) {
//		Algorithm001 a1 = new Algorithm001();
//		int result = a1.sum(20489);
//		System.out.println(result);

		Algorithm002 a2 = new Algorithm002();
		boolean isc1 = a2.sumCheck(new int[] {5,3,9,13}, 8);
		System.out.println(isc1);
		boolean isc2 = a2.sumCheck(new int[] {5,3,9,13}, 7);
		System.out.println(isc2);
	}

}
