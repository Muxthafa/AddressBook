package com.assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
	public static ArrayList<AddressBook> person=new ArrayList<AddressBook>();  //collection class array list is used to store objects of address book
	
	public static Scanner sc=new Scanner(System.in);
	//Instance variables
	private String firstname;
	private String lastname;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone_number;
	private String email;
	
	public AddressBook()
	{
		System.out.println("Welcome to adress book program"); //welcome message
	}
			
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
	
	//@method to insert person details to specific address book
	public void insertContact() {
		
		while(true)
		{
			System.out.println("first Name:");
			firstname=sc.next();
			if(duplicateCheck(firstname) == true) {
				continue;						// if there is duplicate then user is asked to enter name again
			}else {
				break;
			}
		}
		System.out.println("last name:");
		lastname=sc.next();
		System.out.println("address:");
		address=sc.next();
		System.out.println("city:");
		city=sc.next();
		System.out.println("state:");
		state=sc.next();
		System.out.println("zip:");
		zip=sc.next();
		System.out.println("phone number");
		phone_number=sc.next();
		System.out.println("E-mail:");
		email=sc.next();
		person.add(new AddressBook(firstname,lastname,address,city,state,zip,phone_number,email));	//object creation
	}
	
	/**
	 * @method returns true if first name is duplicate 
	 * @param fName
	 * @return boolean
	 */
	public boolean duplicateCheck(String fName) {
		for(AddressBook name : person) {
			if(name.firstname.equalsIgnoreCase(fName)) {
				System.out.println("Contact exists!!");
				return true;
			}
		}
		return false;
	}
	
	//@method for displaying attributes
	public void display()
	{
		System.out.println("Enter the person's first name:");		//case to display a contact
		String name3=sc.next();
		int flag =0;
		for (int j=0;j<person.size();j++)
		{
			AddressBook address_book=person.get(j);					//get method takes an index to look for an object in collection list
			if(address_book.firstname.equals(name3))
			{
				flag=1;
				System.out.println("First Name: "+firstname);
				System.out.println("Last Name: "+lastname);
				System.out.println("Address: "+address);
				System.out.println("City: "+city);
				System.out.println("State: "+state);
				System.out.println("Zip: "+zip);
				System.out.println("Phone Number: "+phone_number);
				System.out.println("E-mail: "+email);	
			
			}
		   
		}
		if(flag==0) {
			System.out.println("Contact not found!");
		}
		
	}
	
	//@method to display all contents in the address book
	public void display_addressbook()
	{
		if(person.size()==0)
		{
			System.out.println("No Contacts in the address book!!!");
		}
		else
			{
			System.out.println("Address book contains following contacts!!!");
			
			for(int j=0;j<person.size();j++)
			{
				AddressBook object=person.get(j);
				System.out.println("Contact details of person "+j);
				System.out.println("first Name:"+object.firstname);
				System.out.println("last name:"+object.lastname);
				System.out.println("address:"+object.address);
				System.out.println("city:"+object.city);
				System.out.println("state:"+object.state);
				System.out.println("zip:"+object.zip);
				System.out.println("phone number:"+object.phone_number);
				System.out.println("E-mail:"+object.email);
			}
		}
	}
	
	//@method for editing details
	public void edit()
	{
		System.out.println("Enter the person whose contact to be edited");	//to edit existing address
		String name=sc.next();
		int flag=0;
		for (int j=0;j<person.size();j++)
		{
		    AddressBook tempObject=person.get(j);
			if(tempObject.firstname.equals(name))
			{
			    flag=1;
				System.out.println("first Name:"+tempObject.firstname);
				System.out.println("last name:"+tempObject.lastname);
				System.out.println("address:"+tempObject.address);
				System.out.println("city:"+tempObject.city);
				System.out.println("state:"+tempObject.state);
				System.out.println("zip:"+tempObject.zip);
				System.out.println("phone number:"+tempObject.phone_number);
				System.out.println("E-mail:"+tempObject.email);	
				System.out.println("Enter the number which you want to edit\n1.first name\n2.last name\n3.address\n4.city\n5.state\n6.zip\n7.phone number\n8.email");
                int choose = sc.nextInt();
                switch(choose){
                    case 1: System.out.println("first name:");
                        tempObject.firstname=sc.next();
                        break;
                    case 2: System.out.println("last name:");
                        tempObject.lastname=sc.next();
                        break;
                    case 3: System.out.println("address:");
                        tempObject.address=sc.next();
                        break;
                    
                    case 4: System.out.println("city:");
                        tempObject.city=sc.next();
                        break;
                    case 5: System.out.println("state:");
                        tempObject.state=sc.next();
                        break;
                    case 6: System.out.println("zip:");
                        tempObject.zip=sc.next();
                        break;
                    case 7: System.out.println("phone_number:");
                        tempObject.phone_number=sc.next();
                        break;
                    case 8: System.out.println("email:");
                        tempObject.email=sc.next();
                        break;
                }
			}
		}	
		if(flag==0)
            System.out.println("Contact not found!!!");
	}
	
	//@method for deleting objects
	public void delete()
	{
		System.out.println("Enter the person whose contact to be deleted");
		String name2=sc.next();			//input is taken from console
		
		for (int j=0;j<person.size();j++)
		{	
			AddressBook object=person.get(j);
			if(object.firstname.equals(name2))
			{
				
				person.remove(object);	//array list has built in method to remove objects
			
			}
		}	
	}
	
	/**
	 * @method to search for city or state
	 * @param place
	 */
    public void search(String name) {
        for (int j=0;j<person.size();j++)
        {   
            AddressBook object=person.get(j);
            if(object.city.equalsIgnoreCase(name) || object.state.equalsIgnoreCase(name))
            {
                System.out.println(object.firstname+" "+object.lastname);  
            }
        }
        
    }

}
