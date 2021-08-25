package com.assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
	public static ArrayList<AddressBook> person=new ArrayList<AddressBook>();  //collection class array list is used to store objects of address book
	
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
	//@method for editing details
	public void edit(String firstname,String lastname,String address,String city,String state,String zip,String phone_number,String email)
	{
		this.firstname=firstname;
		this.lastname=lastname;
		this.address=address;
		this.city=city;
		this.state=state;
		this.zip=zip;
		this.phone_number=phone_number;
		this.email=email;
	}
	//@method for deleting objects
	public static void delete(AddressBook address_book)
	{
		person.remove(address_book);	//remove is an inbuilt method to remove objects
	}

	public static void main(String[] args) {
		System.out.println("Welcome to adress book program");	//welcome message for the concerned program
		
		Scanner sc=new Scanner(System.in);
		
		String fname,lname,address,city,state,zip,phone,email;

		while(true)
		{
			System.out.println("Enter your choice\n1.add contact\n2.edit contact\n3.Delete contact\n4.Display contact\n5.Display entire contact list\n6.exit");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:									
				//case to add contacts
				System.out.println("first Name:");
				fname=sc.next();
				System.out.println("last name:");
				lname=sc.next();
				System.out.println("address:");
				address=sc.next();
				System.out.println("city:");
				city=sc.next();
				System.out.println("state:");
				state=sc.next();
				System.out.println("zip:");
				zip=sc.next();
				System.out.println("phone number");
				phone=sc.next();
				System.out.println("E-mail:");
				email=sc.next();
				person.add(new AddressBook(fname,lname,address,city,state,zip,phone,email));	//object creation
				break;
			
			case 2:System.out.println("Enter the person's first name : ");		//case to edit contacts
					String name=sc.next();
					for (int j=0;j<person.size();j++)
					{
						AddressBook address_book = person.get(j);		//get method takes an index to look for an object in collection list
						if(address_book.firstname.equals(name))
						{
							System.out.println("Enter first Name:");
							fname=sc.next();
							System.out.println("Enter last name:");
							lname=sc.next();
							System.out.println("Enter address:");
							address=sc.next();
							System.out.println("Enter city:");
							city=sc.next();
							System.out.println("Enter state:");
							state=sc.next();
							System.out.println("Enter zip:");
							zip=sc.next();
							System.out.println("Enter phone number:");
							phone=sc.next();
							System.out.println("E-mail address:");
							email=sc.next();
							address_book.edit(fname,lname,address,city,state,zip,phone,email);
						}
					}
					break;
			case 3: System.out.println("Enter the person's first name:"); //case to delete the details of person
					String name2=sc.next();
					for (int j=0;j<person.size();j++)
					{	
						AddressBook address_book=person.get(j);				//get method takes an index to look for an object in collection list
						if(address_book.firstname.equals(name2))
						{
							delete(address_book);
						}
					}
					System.out.println("Details deleted");
					break; 
			
						
			case 4: System.out.println("Enter the person's first name:");		//case to display a contact
					String name3=sc.next();
					for (int j=0;j<person.size();j++)
					{
						AddressBook address_book=person.get(j);					//get method takes an index to look for an object in collection list
						if(address_book.firstname.equals(name3))
						{
							
							address_book.display();
						
						}
					   
					}
				
					break;
			case 5:	if(person.size()==0)	//to display all the contacts of the address book
					{
						System.out.println("No Contacts available");
					}
					for(int j=0;j<person.size();j++)
					{
						AddressBook address_book=person.get(j);
						System.out.println("Contact details of person"+j);
						address_book.display();
					}
					break;
			case 6: System.out.println("closing!!");
					System.exit(0);
					break;
			}
	}
}
}
