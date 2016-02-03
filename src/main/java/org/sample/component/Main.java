package org.sample.component;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import org.sample.vo.Employee;

public class Main {

	public static void main(String[] args) {
	
		//collectionr();
		//nullCheck();
		sample();
	}
	
	static private void sample(){
		String a = "abc";
		String b = new String("abc");
		System.out.println(a.equals(b));
		System.out.println(a==b);
	}
	
	static void collectionr(){
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		System.out.println(e1.getId());
		System.out.println(e2.getId());
		
		System.out.println(e1.equals(e2));
		
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		
		Set<Employee> eset = new HashSet<>();
		eset.add(e1);
		eset.add(e2);
		
		Map<String,String> map = new HashMap<>();
		map.put("k1", "V1");
		map.put("k2", "V2");
		
		List<String> mval =  new ArrayList<String>(map.values());
		Set<Entry<String, String>> set = map.entrySet();
		
		for(Entry e : set){
			System.out.println(e.getKey());
		}
		
		
		//Collection<String> cval = mval;
		System.out.println(mval);
		
		System.out.println(eset);
	}

	static void nullCheck(){
		File file = new File("D:\\Ddel");
		File[] listOfFiles = file.listFiles();
		if(listOfFiles!=null){
			List<File> files = Arrays.asList(listOfFiles);
			System.out.println("Files "+files);
			for(File f : files){
				System.out.println("Each "+f);
			}
		}
	}
}
