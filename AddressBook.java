package com.assignment;

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
		System.out.println("Welcome to Adress Book System program"); //welcome message for the concerned program	
		AddressBook addbook=new AddressBook("Mohammad","Musthafa","Agrahara Katapadi","Udupi","Karnataka","574105","7760219131","musthafa@gmail.com");	//Object creation
		addbook.display(); //displaying the object created
	}

}
