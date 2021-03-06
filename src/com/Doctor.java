package com;

import java.sql.*;

import com.mysql.jdbc.Connection;

public class Doctor {

	public Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/hms?useSSL=true", "root", "");
			// For testing
			System.out.print("Successfully connected");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	public String insertDoctor(String name, String Tel, String Specialization, String Hospital, String Email,
			String password) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
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

			// execute the statement
			preparedStmt.execute();
			con.close();

			String newDoctor = readDoctor();
			output = "{\"status\":\"success\", \"data\": \"" + newDoctor + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while inserting the Doctor.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readDoctor() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table class='table' border='1'><tr class='thead-dark'><th>ID</th><th>Name</th><th>Tel</th>"
					+ "<th>Specialization</th>" + "<th>Hospital</th>" + "<th>Email</th>" + "<th>password</th>"
					+ "<th>Update</th><th>Remove</th></tr>";
			String query = "select * from doctor";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String DoId = Integer.toString(rs.getInt("id"));
				String DoName = rs.getString("name");
				String DoTel = Integer.toString(rs.getInt("Tel"));
				String DoSpecialization = rs.getString("Specialization");

				String DoHospital = rs.getString("Hospital");
				String DoEmail = rs.getString("Email");
				String Dopassword = rs.getString("password");

				// Add into the html table

				output += "<tr><td>" + "<input id='hidDoIDUpdate' name='hidDoIDUpdate'type='hidden' value='" + DoId
						+ "'>" + DoId + "</td>";

				output += "<td>" + DoName + "</td>";

				output += "<td>" + DoTel + "</td>";
				output += "<td>" + DoSpecialization + "</td>";
				output += "<td>" + DoHospital + "</td>";
				output += "<td>" + DoEmail + "</td>";
				output += "<td>" + Dopassword + "</td>";
				// buttons
				output += "<td><input name='btnUpdate' type='button'value='Update'class='btnUpdate btn btn-success'></td>"
						+ "<td><input name='btnRemove' type='button'value='Remove'class='btnRemove btn btn-danger' data-doid='"
						+ DoId + "'>" + "</td></tr>";
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the Doctor.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteDoctor(String DoId) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from doctor where id=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(DoId));

			// execute the statement
			preparedStmt.execute();
			con.close();
			String newDoctor = readDoctor();
			output = "{\"status\":\"success\", \"data\": \"" + newDoctor + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":\"Error while deleting the Doctor acccount....\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	// Update Doctor
	public String updateDoctor(String ID, String name, String Tel, String Specialization, String Hospital, String Email,
			String password) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE doctor SET name=?,Tel=?,Specialization=?,Hospital=?,Email=?,password=? WHERE id=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, name);
			preparedStmt.setInt(2, Integer.parseInt(Tel));
			preparedStmt.setString(3, Specialization);
			preparedStmt.setString(4, Hospital);
			preparedStmt.setString(5, Email);
			preparedStmt.setString(6, password);
			preparedStmt.setInt(7, Integer.parseInt(ID));

			// execute the statement
			preparedStmt.execute();
			con.close();
			String newDoctor = readDoctor();
			output = "{\"status\":\"success\", \"data\": \"" + newDoctor + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while updating the Doctor.\"}";
			System.err.println(e.getMessage());
		}
		return output;
		
		
	}
	
//Doctor login checker
	public String logincheck(String DoUsername,String Dopassword){
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating." ;
				
			} 
			
			String query = "select * from doctor where name=? and password=? ";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, DoUsername);
			preparedStmt.setString(2, Dopassword);
			
		
			ResultSet rs = preparedStmt.executeQuery();
			
			if(rs.next()) {
				String DoId = Integer.toString(rs.getInt("id"));
				String DoName = rs.getString("name");
				String DoTel = Integer.toString(rs.getInt("Tel"));
				String DoSpecialization = rs.getString("Specialization");

				String DoHospital = rs.getString("Hospital");
				String DoEmail = rs.getString("Email");
				String Docpassword = rs.getString("password");
				
				output +=  "id : <input id='hidDoIDUpdate' name='hidDoIDUpdate'type='hidden' value='" + DoId+ "'> <br>";

				//output += " id :<input id='id' name='id' type='text' class='form-control form-control-sm' value ='"+ DoId +"'><br>";
				output += " name : <input id='name' name='name' type='text' class='form-control form-control-sm' value ='"+ DoName +"'><br>";
				output += "Tel : <input id='Tel' name='Tel' type='text' class='form-control form-control-sm' value ='"+ DoTel +"'><br>";
				output += "Specialization : <input id='Specialization' name='Specialization' type='text' class='form-control form-control-sm' value ='"+ DoSpecialization +"'><br>";
				output += "Hospital : <input id='Hospital' name='Hospital' type='text' class='form-control form-control-sm' value ='"+ DoHospital +"'><br>";
				output += "Email : <input id='Email' name='Email' type='text' class='form-control form-control-sm' value ='"+ DoEmail +"'><br>";
				output += "password <input id='password' name='password' type='password' class='form-control form-control-sm' value ='"+ Docpassword +"'><br>";

				output +=  "<input name='btnRemove' type='button'value='Remove'class='btnRemove btn btn-danger' data-doid='"
						+ DoId + "'>";
				return output ;
			}
			
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		output ="wrong credentials";
		return output;
	}

}
