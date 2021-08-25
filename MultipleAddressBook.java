package com.assignment;

import java.util.Hashtable;
import java.util.Scanner;

public class MultipleAddressBook {
	
	/*@method to perform some operation 
	 * takes choice and specific address book object as parameters
	 */
	public static  void choice(int choice,AddressBook object)
	{
			switch(choice)
			{
				case 1:	object.insertContact();			//add a new contact into address book
						break;
			
				case 2:object.edit();					//edit existing contact							
						break;
				   
				case 3: object.delete();				//delete the selected contact
						break;
						
				case 4: object.display();				//to display desired contact
						break;
					
				case 5:object.display_addressbook();	//to display entire address book
						break;	
			}
			
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Hashtable<String,AddressBook>  multipleAddressBook = new Hashtable<String, AddressBook>();  //dictionary for mapping different address book with key 
		AddressBook address_book=new AddressBook();					//first address book object
		
		String n="";
		String k="AddressBook1";
		multipleAddressBook.put(k, address_book);							//put the first address book into dictionary
		
		while(true)
		{
			System.out.println("Enter your choice\n1.add contact\n2.edit contact\n3.Delete contact\n4.Display contact\n5.Display addressbook\n6.Create another address book\n7.exit"); //options for different actions
			int choice=sc.nextInt();
			if(choice==6)  //to create a new address book
			{
				System.out.println("Enter the name of the addressbook");
				n=sc.next();
				AddressBook object1=new AddressBook();  // a new address book object is created 
				multipleAddressBook.put(n, object1);
					
			}
			else if(choice==7)				//to exist from the program
				System.exit(0);
			else
			{
				System.out.println("Enter the addressbook where you want to insert or modify the  contact!!");
				n=sc.next();
				choice(choice,multipleAddressBook.get(n));   //to perform required operation on desired address book
			}		
		}
	}
}
