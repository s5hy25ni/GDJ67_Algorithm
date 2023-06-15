package com.sh.al;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Algorithm002 {
	public boolean solutionStream(int[] arr, int n) {

		List<Integer> lists = new ArrayList<Integer>(Arrays.stream(arr).sorted().boxed().collect(Collectors.toList()));
		List<Integer> newLists = lists.stream().filter(a -> a < n).map(a -> n - a).collect(Collectors.toList());
		boolean isc = newLists.stream().filter(b -> lists.contains(b)).limit(1).collect(Collectors.toList()).isEmpty();

		return !isc;
	}

	public boolean solutionJCF(int[] arr, int n) {

		boolean isc = false;
		Arrays.sort(arr);

		List<Integer> lists = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= n) {
				break;
			}
			lists.add(arr[i]);
		}

		Iterator<Integer> iter = lists.iterator();
		while (iter.hasNext()) {
			if (lists.contains(n - iter.next())) {
				isc = true;
				break;
			}
		}

		return isc;
	}
	
	public boolean solution(int[] arr, int n) {		
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			if(n<=arr[i]) {
				return false;
			} else {
				for (int j = i+1; j < arr.length; j++) {
					if(arr[i]+arr[j]==n) {
						return true;
					}
				}
			}
		}
		return false;
	}
}