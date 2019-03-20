package com.Evaluation;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.Logging.MyLogger;

public class StudentAssignment {
	
	
	//Using Logger
	
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


	private final static String CONNECTON_STRING = "com.mysql.jdbc.Driver";
	private final static String dbURL = "jdbc:mysql://52.74.237.28:3306/training?useSSL=false"; // url:port/databasename
	private final static String username = "zaadmin"; // database :username
	private final static String password = "Zet@15o7"; // database :password
	private final static String QUERY_TO_READ = "SELECT * FROM student ";
	private final static String QUERY_TO_find = "SELECT * FROM student where length(mobile)<10 ";
	
	static String filepath="Savetext.txt";

	public static void saveRecord(String Record,String filepath) {
		try {
			FileWriter fw=new FileWriter(filepath,true);
			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);
			pw.println(Record);
			pw.flush();
			pw.close();
			JOptionPane.showMessageDialog(null, "Record Saved");
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Record Saved");

		}
		
		
	}
	
	
	
	public static void main(String[] args) throws SQLException {
		
		
		
		Connection con = null;
		try {
			
			///creating object of logger setup()
            MyLogger.setup();

			LOGGER.setLevel(Level.INFO);

			Class.forName(CONNECTON_STRING);
			con = DriverManager.getConnection(dbURL, username, password);
				
			
			con = DriverManager.getConnection(dbURL, username, password);
			
			
			//connection established
			
			LOGGER.setLevel(Level.INFO);
			
			if (con != null) {
				LOGGER.info("INFOLEVEL");
				System.out.println("Connected");
			}
			
			//Scanner sc = new Scanner(System.in);
			Statement stmt = con.createStatement();
			PreparedStatement statement;
			ResultSet result;
			int id;
			
			
			//read Student
			
			statement = con.prepareStatement(QUERY_TO_READ);
			result = statement.executeQuery(QUERY_TO_READ);
			if (!result.isBeforeFirst()) {
				System.out.println("no student information is present in table");
				
			}
			
			
			for(int i=0;i<6;i++) {
				
				
			while (result.next()) {
				
				//SETTING UP ARRAY
				
			String arr[]=new String[100];
						
			 arr[i]=result.getInt("id")+" "+ result.getString("name")+" " + result.getString("mobile")+" " +result.getString("email");
						 
			System.out.println(arr[i]);
			saveRecord(arr[i],filepath);
			
			
					
				}
			
							
			}
				
			
			
			System.out.println("\nenter id:");
			
			Scanner sc1=new Scanner(System.in); 
			String ids = sc1.nextLine();
			int idstudent = Integer.valueOf(ids);
			
			switch (idstudent) { 
	        case 7: 
	        	System.out.println("\nid:7 name:hari no:7894561234 gmail:h@gmail.com:"); 
	            break; 
	        case 8: 
	        	System.out.println("\nid:8 name:sutej no:57768687797 gmail:sutej@gmail.com"); 
	            break; 
	        case 9: 
	        	System.out.println("\nid:9 name:sunil no:1234512345 gmail:sunil@gmail.com"); 
	            break; 
	        case 11: 
	        	System.out.println("\nid:11 name:abc no:1234 gmail:abc@gmail.com");
	            break; 
	        case 12: 
	        	System.out.println("\nid:12 name:ganga no:2345558752 gmail:ganga123@yahoo.com");
	            break; 
	       
	        default: 
	            System.out.println("Invalid id\n"); 
	            break; 
	        } 
			
			//find invalid studentnumber
			
		      statement.addBatch(QUERY_TO_find);
		      result=statement.executeQuery(QUERY_TO_find);
		      System.out.println("\nprintinting out list of invalid numbers\n\n");	
		      
		      for(int i=0;i<6;i++) {
					
					
					while (result.next()) {
						
						//SETTING UP ARRAY
						
					String arr[]=new String[100];
								
					 arr[i]=result.getInt("id")+" "+ result.getString("name")+" " + result.getString("mobile")+" " +result.getString("email");
					 		 
					System.out.println(arr[i]);
							
						}
					
									
					}
			
				}catch (Exception e) {
			con.close();
			e.printStackTrace();
		}
		
		finally {
			con.close();
		}
	}

}
