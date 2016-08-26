package org.sample.sorting;

import java.util.ArrayList;
import java.util.List;

public class SortedList<T extends Comparable<? super T >> extends ArrayList<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean add(T e) {
		System.out.println("Adding element "+e);
		
		List<T> buffer = new ArrayList<T>();
		
		if(buffer.size() > 0)
		for(T each : buffer) {
			if(e.compareTo(each) < 0 ) { 
				
			}
			
		}
/*		int prevIndex = (super.size() > 0 ? super.size() : 0) - 1 ;
		if(prevIndex >= 0) {
		T previous = super.get(prevIndex);
		System.out.println("compare to value "+e.compareTo(previous)+" e "+e+" previous "+previous);
		if(e.compareTo(previous) < 0 ) {
			
			super.set(prevIndex, e);
			return super.add(previous);
			}
			
		}*/
		return super.add(e);
	}
}
