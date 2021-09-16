package com.assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Address book problem to perform various operation on address books
 * MultipleAddressBook class contains multiple address book objects
 * each address book has many contacts
 * @author Mohammad Musthafa
 *
 */
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
		Map<String,AddressBook>  multipleAddressBook = new HashMap<String, AddressBook>();  //dictionary for mapping different address book with key 
		AddressBook address_book=new AddressBook();					//first address book object
		
		String n="";
		String k="AddressBook1";
		multipleAddressBook.put(k, address_book);							//put the first address book into dictionary
		
		while(true)
		{
			System.out.println("Enter your choice\n1.add contact\n2.edit contact\n3.Delete contact\n4.Display contact\n5.Display addressbook\n6.Create another address book\n7.Search for a city or state\n8.View persons by city or state\n9.Sort by Name, City, State or zip\n10.exit"); //options for different actions
			int choice=sc.nextInt();
			if(choice==6)  //to create a new address book
			{
				System.out.println("Enter the name of the addressbook");
				n=sc.next();
				AddressBook object1=new AddressBook();  // a new address book object is created 
				multipleAddressBook.put(n, object1);
					
			}
			else if(choice==7)
			{
			    System.out.println("Enter the name of city or state");
			    String place=sc.next();
			    for(Map.Entry<String, AddressBook> entry : multipleAddressBook.entrySet())
			    {
			        AddressBook tempObject=entry.getValue();
			        tempObject.search(place);
			    }  
			}
			else if(choice==8)
			{
			    System.out.println("Enter the number 1 or 2\n"
			    		+ "1.city\n"
			    		+ "2.state");
			    int ch=sc.nextInt();
			    if(ch == 1) {
			    	for(Map.Entry<String, AddressBook> mapEntry : multipleAddressBook.entrySet()) {
			    		AddressBook tempObject = mapEntry.getValue();
			    		System.out.println("AddressBook name: "+mapEntry.getKey()+"\npersons by cities are:");
			    		tempObject.viewByCity();
			    	}
			    }
			    else{
			    	for(Map.Entry<String, AddressBook> mapEntry : multipleAddressBook.entrySet()) {
			    		AddressBook tempObject = mapEntry.getValue();
			    		System.out.println("AddressBook: "+mapEntry.getKey()+"\npersons by states are:");
			    		tempObject.viewByState();
			    	}
			    }
			}
			else if(choice==9)
			{
				System.out.println("Enter the number to select the sort by option\n"
			    		+ "1.Name\n"
			    		+ "2.City\n"
			    		+ "3.State\n"
			    		+ "4.zip");
			    int ch=sc.nextInt();
			    for(Map.Entry<String, AddressBook> entry : multipleAddressBook.entrySet())
			    {
			        AddressBook tempObject=entry.getValue();
			        System.out.println(entry.getKey()+" details:");
			        tempObject.sortByNameCityStateZip(ch);
			        System.out.println("-----------------------------------------------------------------");
			    }  
			}
			else if(choice==9)				//to exist from the program
				System.exit(0);
			else
			{
				try{
					System.out.println("Enter the addressbook name!!");
					n=sc.next();
					choice(choice,multipleAddressBook.get(n));   //to perform required operation on desired address book
				}catch(Exception e) {
					System.out.println("AddressBook not found!!");
				}
				
			}		
		}
	}
}
