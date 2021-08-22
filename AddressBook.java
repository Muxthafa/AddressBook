package com.assignment;

import java.util.Scanner;

public class AddressBook {
		//Instance variables
		private String firstname;
		private String lastname;
		private String address;
		private String city;
		private String state;
		private String zip;
		private String phone_number;
		private String email;
			
		//parameterized constructors initialized during object creation
		public AddressBook(String firstname,String lastname,String address,String city,String state,String zip,String number,String email)
		{
			this.firstname=firstname;
			this.lastname=lastname;
			this.address=address;
			this.city=city;
			this.state=state;
			this.zip=zip;
			this.phone_number=number;
			this.email=email;
		}
		//@method for displaying attributes
		public void display()
		{
			System.out.println("First Name: "+firstname);
			System.out.println("Last Name: "+lastname);
			System.out.println("Address: "+address);
			System.out.println("City: "+city);
			System.out.println("State: "+state);
			System.out.println("Zip: "+zip);
			System.out.println("Phone Number: "+phone_number);
			System.out.println("E-mail: "+email);
		}

	public static void main(String[] args) {
		System.out.println("Welcome to adress book program");	//welcome message for the concerned program
		
		Scanner sc=new Scanner(System.in);
		
		AddressBook[] contact=new AddressBook[10];  //array to store objects
		System.out.println("Total number of contacts to add :");
		int n=sc.nextInt();
		System.out.println("Enter the details below");
		String fname,lname,address,city,state,zip,phone,email;
		
		//for loop to add n contact details
		for(int i=0;i<n;i++) 
		{
			System.out.println("Enter first Name:");
			fname=sc.next();
			System.out.println("Enter last name:");
			lname=sc.next();
			System.out.println("Enter the address:");
			address=sc.next();
			System.out.println("Enter the city name:");
			city=sc.next();
			System.out.println("Enter the name of state:");
			state=sc.next();
			System.out.println("zip:");
			zip=sc.next();
			System.out.println("Enter the contact number");
			phone=sc.next();
			System.out.println("E-mail address:");
			email=sc.next();
			contact[i]=new AddressBook(fname,lname,address,city,state,zip,phone,email);	//object creation for each contact
			
		}
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Details of "+i+" person!!!");
			contact[i].display(); //print details of each person
			
		}
	}

}
