package com.sh.al;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Algorithm002 {
	public boolean sumCheck(int[] arr, int n) {
		
		List<Integer> lists = new ArrayList<Integer>(Arrays.stream(arr).sorted().boxed().collect(Collectors.toList()));
		List<Integer> newLists = lists.stream().filter(a -> a<n).map(a->n-a).collect(Collectors.toList());
		boolean isc = newLists.stream().filter(b->lists.contains(b)).limit(1).collect(Collectors.toList()).isEmpty();

		return !isc;
	}

}
;