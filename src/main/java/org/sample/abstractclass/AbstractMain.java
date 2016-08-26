package org.sample.abstractclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.sample.sorting.SortedList;

public class AbstractMain {

	
	public static void main(String[] args) {
//		new AbstractImpl().nonAbstract();
		
//		String text = " hello  world     this";
//		System.out.println(text.replaceAll("\\s+", " "));
		
		String s1 = "abc";
		String s2 = "abcd";
		String s3 = "zxwever";
		
//		System.out.println(s1.equals(s2));
//		System.out.println(s1.compareTo(s2));
		
		Set<String> set = new  HashSet<String>(); //TreeSet<String>();
		
		set.add(s3);
		set.add(s1);
		set.add(s2);
		set.add(null);
		
//		System.out.println(set);
		List<String> al = new ArrayList<String>();
		List<String> ll = new LinkedList<String>();
		List<String> sl = new SortedList<String>();
		
/*		al.add(s3);
		al.add(s1);
		al.add(s2);
		
		ll.add(s3);
		ll.add(s2);
		ll.add(s1);*/
		
		sl.add(s3);
		sl.add(s2);
		sl.add(s1);
		
//		Collections.sort(sl);
		
//		System.out.println("AL "+al);
//		System.out.println("LL "+ll);
		System.out.println("SL "+sl);
		
		
	}
}
