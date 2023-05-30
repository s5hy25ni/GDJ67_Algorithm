package com.sh.al;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Algorithm002 {
	public boolean sumCheck(int[] arr, int n) {
		boolean isc = false;
		Arrays.sort(arr);
		
//		List<Integer> arrList = new ArrayList<Integer>(Arrays.asList(arr));
		List<Integer> lists = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>=n) {
				break;
			}
			lists.add(arr[i]);
		}
		
		Iterator<Integer> iter = lists.iterator();
		while(iter.hasNext()) {
			if(lists.contains(n-iter.next())) {
				isc = true;
				break;
			}
		}
		
		return isc;
	}

}
