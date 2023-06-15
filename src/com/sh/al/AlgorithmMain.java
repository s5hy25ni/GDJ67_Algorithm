package com.sh.al;

public class AlgorithmMain {

	public static void main(String[] args) {
//		Algorithm001 a1 = new Algorithm001();
//		int result = a1.solution(513138484);
//		System.out.println(result);

		Algorithm002 a2 = new Algorithm002();
//		boolean isc1 = a2.solutionStream(new int[] {5,3,9,13}, 8);
//		boolean isc2 = a2.solutionStream(new int[] {5,3,9,13}, 7);
//		boolean isc3 = a2.solutionJCF(new int[] {5,3,9,13}, 8);
//		boolean isc4 = a2.solutionJCF(new int[] {5,3,9,13}, 7);
		boolean isc5 = a2.solution(new int[] {5,3,9,13}, 8);
		boolean isc6 = a2.solution(new int[] {5,3,9,13}, 7);
		boolean isc7 = a2.solution(new int[] {5,3,9,13}, 22);
		boolean isc8 = a2.solution(new int[] {5,3,9,13}, 15);
		
//		System.out.println(isc1);
//		System.out.println(isc2);
//		System.out.println(isc3);
//		System.out.println(isc4);
		System.out.println(isc5);
		System.out.println(isc6);
		System.out.println(isc7);
		System.out.println(isc8);
		
//		Algorithm003 a3 = new Algorithm003();
//		int cycle1 = a3.solution("aaaaaaa");
//		int cycle2 = a3.solution("abababab");
//		int cycle3 = a3.solution("abcabcabd");
//		System.out.println(cycle1);
//		System.out.println(cycle2);
//		System.out.println(cycle3);
		
		Algorithm004 a4 = new Algorithm004();
		a4.solution(new int[] {3,5,2,1,2,6}, new int[] {2,3,4,6,3,2});

	}

}
