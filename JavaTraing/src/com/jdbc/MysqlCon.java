package com.jdbc;

import java.sql.*;
import java.util.Scanner;

/*while compilation on cmd use
* download mysql connector from: https://dev.mysql.com/downloads/connector/j/5.1.html 
* on windows:
* compile: javac -classpath .;C:\Users\dell\Downloads\mysql-connector-java-5.1.47\mysql-connector-java-5.1.47.jar MysqlCon.java
* execute: java -classpath .;C:\Users\dell\Downloads\mysql-connector-java-5.1.47\mysql-connector-java-5.1.47.jar MysqlCon
*on linux:
* compile: javac -classpath .:C:\Users\dell\Downloads\mysql-connector-java-5.1.47\mysql-connector-java-5.1.47.jar MysqlCon.java
* execute: java -classpath .:C:\Users\dell\Downloads\mysql-connector-java-5.1.47\mysql-connector-java-5.1.47.jar MysqlCon
*
* on eclipse to add jar go to your project properties -> java build path -> add external jars in libraries.
* 
*/
public class MysqlCon {
	private final static String CONNECTON_STRING = "com.mysql.jdbc.Driver";
	private final static String dbURL = "jdbc:mysql://52.74.237.28:3306/training?useSSL=false"; // url:port/databasename
	private final static String username = "zaadmin"; // database :username
	private final static String password = "Zet@15o7"; // database :password

	private final static String QUERY_CREATE_SQL = "CREATE TABLE IF NOT EXISTS `student` (id int PRIMARY KEY AUTO_INCREMENT , name varchar(255) NOT NULL, mobile varchar(255) NOT NULL,email varchar(255) NOT NULL)";
	private final static String QUERY_TO_INSERT = "INSERT INTO student (`name`, mobile, email) VALUES (?, ?, ?)";
	private final static String QUERY_TO_READ = "SELECT * FROM student ";
	private final static String QUERY_TO_UPDATE = "UPDATE student SET mobile=?, email=? WHERE id=?";
	private final static String QUERY_TO_DELETE = "DELETE FROM student WHERE id=?";

	public static boolean createNewTable(Connection conn) {
// SQL statement for creating a new table
		try {
			Statement stmt = conn.createStatement();
// create a new table
			stmt.execute(QUERY_CREATE_SQL);
			System.out.println("created");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		try {
			Class.forName(CONNECTON_STRING);
			con = DriverManager.getConnection(dbURL, username, password);
			if (!createNewTable(con)) {
				return;
			}
			if (con != null) {
				System.out.println("Connected");
			}
			Scanner sc = new Scanner(System.in);
			Statement stmt = con.createStatement();
			PreparedStatement statement;
			ResultSet result;
			int id;
// crud=create read update delete
			while (true) {
				System.out.println("1 to insert, 2 to select, 3 to update, 4 to delete, 5 to end ");
				try {
					switch (sc.nextInt()) {
					case 1:
// insert into student
						System.out.println("enter student's name");
						String name = sc.next();
						System.out.println("enter student's mobile number");
						String mobile = sc.next();
						System.out.println("enter student's email");
						String email = sc.next();

						statement = con.prepareStatement(QUERY_TO_INSERT);
						statement.setString(1, name);
						statement.setString(2, mobile);
						statement.setString(3, email);
						int rs = statement.executeUpdate();
						if (rs > 0) {
							System.out.println("A new student was inserted successfully!");
						}
						break;
					case 2:
// read from student

						statement = con.prepareStatement(QUERY_TO_READ);
						result = statement.executeQuery(QUERY_TO_READ);
						if (!result.isBeforeFirst()) {
							System.out.println("no student information is present in table");
							break;
						}
						while (result.next()) {
							id = result.getInt("id");// column 1 (1)
							name = result.getString("name");// column 2 (2)
							mobile = result.getString("mobile");// column 3 (3)
							email = result.getString("email");
							System.out.println(String.format(
									"id : " + id + ",Name : " + name + ",mobile : " + mobile + ",email :" + email));
						}
// System.out.println("no student information is present in
// table");
						break;
					case 3:
// update student

						statement = con.prepareStatement(QUERY_TO_UPDATE);
						System.out.println("enter student's id");
						id = sc.nextInt();
						System.out.println("enter student's mobile number");
						mobile = sc.next();
						System.out.println("enter student's email");
						email = sc.next();
						statement.setString(1, mobile);
						statement.setString(2, email);
						statement.setInt(3, id);
						int results = statement.executeUpdate();
						if (results > 0)
							System.out.println("Updated student Info successfully");
						else
							System.out.println("no student information is present in table");
						break;
					case 4:
// delete student

						statement = con.prepareStatement(QUERY_TO_DELETE);
						System.out.println("enter student's id");
						id = sc.nextInt();
						statement.setInt(1, id);
						int resultss = statement.executeUpdate();
						if (resultss > 0) {
							System.out.println("delete successfull");
						} else
							System.out.println("no student information is present in table");
						break;
					case 5:
						con.close();
						System.out.println("You are out!");
						return;
					}
				} catch (Exception e) {
					System.out.println("please enter valid input!!!");
					break;
				}
			}
		} catch (Exception e) {
			con.close();
			e.printStackTrace();
		}
//this finally closes the connection 
		finally {
			con.close();
		}
	}
}
