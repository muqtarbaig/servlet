package org.sample.example.h2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] a)
            throws Exception {
//        Class.forName("org.h2.Driver");
//        Connection conn = DriverManager.
//            getConnection("jdbc:h2:mem:test", "sa", "");
//        // add application code here
//        conn.close();
    	
        	
    }
    
        
    public void test() {
    	Student s1 = new Student();
    	s1.name = "s1_name";
    	s1.rollno = 1;
    	
    	Student s2 = new Student();
    	s2.name = "s2_name";
    	s2.rollno = 33;
    	
    	List<Student> list = new ArrayList<Student>();
    	list.add(s1);
    	list.add(s2);
    	
    	/*for(Student s : list) {
//    		s.rollno = 9;
    		System.out.println(s.rollno);
    		list.remove(s);
    	}*/
    	
    	Iterator<Student> sitr = list.iterator();
    	while(sitr.hasNext()) {
    		System.out.println(sitr.next());
    		sitr.remove();
    	}
    	
    	System.out.println(list.get(0));
    	
    }
    
    public class Student {
    	int rollno;
    	String name;
    	
    	public String toString() {
    		return "roll "+rollno+" name "+name;
    	}
    }
}