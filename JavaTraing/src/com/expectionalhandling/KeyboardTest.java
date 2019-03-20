
package com.expectionalhandling;
import java.io.*;  
class KeyboardTest{  
public static void main(String args[]){  


System.out.println("Enter password: "); 
Console c=System.console();
//String ca=c.readLine();
char ch[]=c.readPassword(); 
String pass=String.valueOf(ch); //converting char array into string  
System.out.println("Password is: "+pass);  
}  
}   