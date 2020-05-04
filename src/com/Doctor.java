package com;

import java.sql.*;

import com.mysql.jdbc.Connection;

public class Doctor {
	
	public Connection connect()
	{
	 Connection con = null;

	 try
	 {
	 Class.forName("com.mysql.jdbc.Driver");
	 con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/hms","root","");
	 //For testing
	 System.out.print("Successfully connected");
	 }
	 catch(Exception e)
	 {
	 e.printStackTrace();
	 }

	 return con;
	}
	
	
	
	
	
	
	public String insertDoctor(String name, String Tel, String Specialization, String Hospital,String Email,String password)
	{
	 String output = "";
	try
	 {
	 Connection con = connect();
	 if (con == null)
	 {
	 return "Error while connecting to the database";
	 }
	 // create a prepared statement
	 String query = " insert into doctor(name,Tel,Specialization,Hospital,Email,password)"
			 + " values (?, ?, ?, ?, ?, ?)"; 
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	
	 preparedStmt.setString(1, name);
	 preparedStmt.setInt(2, Integer.parseInt(Tel));
	
	 preparedStmt.setString(3, Specialization); 
	 preparedStmt.setString(4, Hospital); 
	 preparedStmt.setString(5, Email); 
	 preparedStmt.setString(6, password); 
	 
	 
	
	//execute the statement
	 preparedStmt.execute();
	 con.close();
	 
	 
	 output = "Inserted successfully";
	 }
	catch (Exception e)
	 {
	 output = "Error while inserting";
	 System.err.println(e.getMessage());
	 }
	return output;
	}
	
	
	
	
	
	
	public String readDoctor()
	{
	 String output = "";
	try
	 {
	 Connection con = connect();
	 if (con == null)
	 {
	 return "Error while connecting to the database for reading.";
	 }
	 // Prepare the html table to be displayed
	 output = "<table border=\"1\"><tr><th>ID</th>"
			 		+"<th>Name</th><th>Tel</th>"
			 		+ "<th>Specialization</th>"
			 		+ "<th>Hospital</th>"
			 		+ "<th>Email</th>"
			 		+ "<th>password</th>"
			 		+ "<th>Update</th><th>Remove</th></tr>";
	 String query = "select * from doctor";
	 Statement stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	 // iterate through the rows in the result set
	 while (rs.next())
	 {
	String DoId = Integer.toString(rs.getInt("id")); 
	 String DoName = rs.getString("name");
	 String DoTel = Integer.toString(rs.getInt("Tel"));
	 String DoSpecialization = rs.getString("Specialization");

	 String DoHospital = rs.getString("Hospital");
	 String DoEmail = rs.getString("Email");
	 String Dopassword = rs.getString("password");

	 
	 // Add into the html table
	 output += "<tr><td>" + DoId + "</td>";
	 output += "<td>" + DoName + "</td>"; 
	
	output += "<td>" + DoTel + "</td>";
	 output += "<td>" + DoSpecialization + "</td>";
	 output += "<td>" + DoHospital + "</td>";
	 output += "<td>" + DoEmail + "</td>";
	 output += "<td>" + Dopassword + "</td>";
	 // buttons
	 output += "<td><input name=\"btnUpdate\" "
	 + " type=\"button\" value=\"Update\"></td>"
	 + "<td><form method=\"post\" action=\"DoctorAdmin.jsp\">"
	 + "<input name=\"btnRemove\" "
	 + " type=\"submit\" value=\"Remove\" class=\"btn btndanger\">"
	 + "<input name=\"DoctorID\" type=\"hidden\" "
	 + " value=\"" + DoId + "\">" + "</form></td></tr>";
	 }
	 con.close();
	 // Complete the html table
	 output += "</table>";
	 }
	catch (Exception e)
	 {
	 output = "Error while reading the Doctor.";
	 System.err.println(e.getMessage());
	 }
	return output;
	}
	
	
	
	public String deleteDoctor(String DoctorID)
	{
	 String output = "";
	try
	 {
	 Connection con = connect();
	 if (con == null)
	 {
	 return "Error while connecting to the database for deleting.";
	 }
	 // create a prepared statement
	 String query = "delete from doctor where id=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setInt(1, Integer.parseInt(DoctorID));

	 // execute the statement
	 preparedStmt.execute();
	 con.close();
	 output = "Deleted successfully";
	 }
	catch (Exception e)
	 {
	 output = "Error while deleting the Doctor.";
	 System.err.println(e.getMessage());
	 }
	return output;
	}



}
