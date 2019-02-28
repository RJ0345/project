package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.lti.model.Customer;


public class CustomerDao {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	public void add(Customer customer) {
		try {
			Properties dbProps = new Properties();
			dbProps.load(this.getClass().getClassLoader().getResourceAsStream("dev-db.properties"));
			Class.forName(dbProps.getProperty("driverClassName"));
			conn = DriverManager.getConnection(dbProps.getProperty("url"),dbProps.getProperty("username"),dbProps.getProperty("password"));
			String sql = "insert into customer values(?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, customer.getId());
			stmt.setString(2, customer.getName());
			stmt.setString(3, customer.getEmail());
			stmt.executeUpdate();
			// rs = stmt.executeQuery();

			/*
			 * if(rs.next()) { Customer emp = new Customer(); emp.setEmployeeid(empid);
			 * emp.setFirstname(rs.getString(1)); emp.setLastname(rs.getString(2));
			 * emp.setSalary(rs.getDouble(3)); return emp; } else return false;
			 */} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// try {rs.close();} catch(Exception e) { e.getStackTrace();}
			try {
				stmt.close();
			} catch (Exception e) {
				e.getStackTrace();
			}
			try {
				conn.close();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}

}
