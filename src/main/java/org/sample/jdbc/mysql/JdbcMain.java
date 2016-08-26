package org.sample.jdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;

import org.sample.filter.Cfilter;

public class JdbcMain {

	public static void main(String[] args) {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
//			"jdbc:mysql://localhost/test"
//			"jdbc:cubrid:localhost:33000:demodb:::","dba",""
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test"); 
			Statement st = con.createStatement();
			PreparedStatement pst = con.prepareStatement("select * from employee");
//			String create = "create table employee(eid int, name varchar(20))";
//			String insert = "insert into employee values(1,'muqtar')";
			String select = "select * from employee";
//			System.out.println(st.execute(create));
//			System.out.println(st.execute(insert));
			ResultSet rs =  pst.executeQuery();//st.executeQuery(select);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
