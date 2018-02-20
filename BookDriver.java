


/*
 * This is the driver class for the Book class as it contains the main method 
 */
import java.util.Scanner;	/**this program requires user input so we must import the Scanner class**/
/**
 * This is the driver class for the Book class.
 *This is where the user will be asked how many books his bookstore can contain, what those books are
 *and how he wants to edit or change any of them
 */

public class BookDriver 
{
	public static void main(String[] args)
	{	
		Scanner key= new Scanner(System.in);
		
		/**defining constants:
		 */
		
		/**the password for the options that require it **/
			final String password= "password";
		/**boolean that allows the main part of the program to run while it is true**/
			boolean run= true;		
			int tries;		
			int runs=3;

		/**welcome message:
		 */
			System.out.println("Welcome owner");
		/**asking the owner for the maximum number of books: */
			System.out.println("What is the maximum number of books your bookstore can contain?");
		/**maximum number of books*/
			int maxBooks= key.nextInt();	
			
		/**array that keeps track of all the created Book objects: */
			Book[] inventory= new Book[maxBooks];
		
	/**while the program is running*/
		while (run==true)
		{
			/**main menu: */
				System.out.println("What do you want to do (select a number please)?");
				System.out.println("\t1. Enter new books (Password required)");
				System.out.println("\t2. Change information of a book (password required)");
				System.out.println("\t3. Display all books by a specific author");
				System.out.println("\t4. Display all books under a certain price.");
				System.out.println("\t5. Quit");
				System.out.println("Please Enter your choice");
				int choice= key.nextInt();
		
			/**if the user's choice does not correspond to any of the options, keep asking again and again; **/
				while (choice<1 || choice>5)
				{
					System.out.println("Please choose a valid option");
					System.out.println("\nWhat do you want to do (select a number please)?");
					System.out.println("\t1. Enter new books (Password required)");
					System.out.println("\t2. Change information of a book (password required)");
					System.out.println("\t3. Display all books by a specific author");
					System.out.println("\t4. Display all books under a certain price.");
					System.out.println("\t5. Quit");
					System.out.println("Please Enter your choice");
					choice= key.nextInt();
				}
			
			/**when option 1 is selected:*/
				if (choice==1)
				{
				/**asks for password */
					System.out.println("Please enter your password: ");	
					String pass= key.next();
				/**initially has 3 attempts to get the password right */
					tries=2;	
			
				/**while the password is incorrect: */
					while (!pass.equals(password) && tries>0)	
					{
					/**asks for password **/
						System.out.println("Incorrect! Please enter the correct password: ");	
						pass= key.next();
						tries--;
					}
					
				/**if the user has used up all of their tries, they still have 3 more chances 4 times **/
					if (tries==0 && runs>0)
					{
						runs--;
					/**skips the iteration and displays the main menu again **/
						continue;	
					}
					
					if (runs==0)
					{
						System.out.println("Program detected suspicious activities and will terminate immediately!");
						System.exit(0);
					}
		
				/**while the password is correct: **/
					while (pass.equals(password))
					{
					/**number that tells us how much room is left in the array: **/
						int room=0;
					/**number that tells us how much room is filled in the array: **/
						int filledBooks=0;
						
						for (int i=0; i<inventory.length; i++)
						{
						/**if there is room at a specific index, then increment room **/
							if (inventory[i]==null)	 
								room++;
							else
								filledBooks++;
						}
						
					/** asking how many books they would like **/
						System.out.println("How many books would you like to add?");
						int addedBooks= key.nextInt();
					/**if the user wants to add more books than there is room for: **/
						while (addedBooks>room)
						{
								System.out.println("There is not enough room, you can only add upto "+ (room) 
							+ " books");
								System.out.println("So let's do this again, How many books would you like to add?");
								addedBooks= key.nextInt();
						}
						
					/**if the user wants to add a number of books that fit into the array: **/
						while (addedBooks<=room) 
						{
							for (int i=0; i<(addedBooks + filledBooks); i++)
							{
							/**asking the user for info to create books with the attributes: **/
								if (inventory[i]==null)
								{
									System.out.println("What is the name of the book " + (i+1) + "?");
									String name= key.nextLine();
									name= key.nextLine();
									System.out.println("What is the name of the author?");
									String author= key.nextLine();
									System.out.println("What is the ISBN of the book?");
									int ISBN= key.nextInt();
									System.out.println("What is the price of the book?");
									double price= key.nextDouble();
								/** creating the book: */
									Book b= new Book(name, author, ISBN, price);
									inventory[i]=b;
								}
							}
							break;
						}
						break;
					}
			}
				
			/** when option 2(changes info of a book)  is entered: **/
				else if (choice==2)
				{
					//Number of tries:
					tries=2;	
				/**asking user for his/her password: **/
					System.out.println("Please enter your password:");
					String pass=key.next();
				/**if the password is incorrect: **/
					while (!pass.equals(password) && tries>0) 
					{
						System.out.println("I am sorry that is not the correct password, please enter the correct one:");
						pass=key.next();
						tries--;
					}
					if (tries<=0)
					{
						continue;	/**if they have used up all their tries, display the main menu again **/
					}
					
				/** if the password is correct: **/
					while (pass.equals(password)) 
					{
						System.out.println("Which book would you like to update? ");
						int update= key.nextInt();
						
					/** if a book does not exist at the given index: **/
						while (inventory[update]==null)
						{
							System.out.println("No book exists at that index");
							System.out.println("Please enter a valid index if the book you like to update? ");
							update= key.nextInt();
						}
					/** if a book does exist at the given index: **/
						while (inventory[update]!=null)
						{
							System.out.println("Book# " + update);
							System.out.println("Author: " + inventory[update].getAuthor());
							System.out.println("Title: " + inventory[update].getTitle());
							System.out.println("ISBN: " + inventory[update].getISBN());
							System.out.println("Price: " + inventory[update].getPrice());
							
							System.out.println("What information would you like to change?");
							System.out.println("\t1. Author");
							System.out.println("\t2. title");
							System.out.println("\t3. ISBN");
							System.out.println("\t4. price");
							System.out.println("\t5. Quit");
							System.out.println("Enter your choice");
							int decision= key.nextInt();
							
						/** if the decision is not valid, keep asking them again: **/
							while (decision<1 || decision>5)
							{
								System.out.println("That is not a valid option!, please pick a valid option\n");
								System.out.println("What information would you like to change?");
								System.out.println("\t1. Author");
								System.out.println("\t2. title");
								System.out.println("\t3. ISBN");
								System.out.println("\t4. price");
								System.out.println("\t5. Quit");
								System.out.println("Enter your choice");
							}
							
							switch (decision)
							{
						/** if the choose to update the author: **/
							case 1:
								System.out.println("What is the name of the new author?");
								String newAuthor= key.nextLine();
								newAuthor= key.nextLine();
								inventory[update].setAuthor(newAuthor);
								break;
						/** if they choose to update the title: **/
							case 2:
								System.out.println("What is the new title?");
								String newTitle= key.nextLine();
								newTitle= key.nextLine();
								inventory[update].setTitle(newTitle);
								break;
						/** if they choose to update the ISBN: **/
							case 3:
								System.out.println("What is the new ISBN?");
								int newISBN= key.nextInt();
								inventory[update].setISBN(newISBN);
								break;
						//if they choose to update the price:
							case 4:
								System.out.println("What is the new price?");
								double newPrice= key.nextDouble();
								inventory[update].setPrice(newPrice);
								break;
						/** if they choose to simply quit and not update anything **/
							case 5:
								System.out.println("Goodbye! ");
								break;
							}
							
						/** new info about the book: **/
							System.out.println("Updated information:");
							System.out.println("Book# " + update);
							System.out.println("Author: " + inventory[update].getAuthor());
							System.out.println("Title: " + inventory[update].getTitle());
							System.out.println("ISBN: " + inventory[update].getISBN());
							System.out.println("Price: " + inventory[update].getPrice());
							break;
						}
						break;
					}
				}
		
			/** when option 3 is entered: **/
				else if (choice==3)
				{
				/** number of books that exist under the author's name: **/
					int existingBooks=0;
					System.out.println("Please Enter the name of the author");
					String authorName= key.nextLine();
					authorName= key.nextLine();
					for (int i=0; i<inventory.length;i++)
					{
						if (inventory[i]!=null)
							if (inventory[i].getAuthor().equals(authorName))	
								existingBooks++;
					}
				/** saying how many books exist under the name of the author: **/
					System.out.println("There exists " + existingBooks + " books under the author of that name: ");
					System.out.println();
					
					for (int i=0; i<inventory.length; i++)
					{
					/** 	if a book does exist at a particular location in an array: **/
						if (inventory[i]!=null)
						/**then we check if the author names match the one we are looking for*/
							if (inventory[i].getAuthor().equals(authorName))	
								System.out.println(inventory[i]);	
					}
				}
				
			/**when option 4 is entered: **/
				else if (choice==4)
				{
				/** number of books cheaper than the price entered **/	
					int cheaperThan=0;
					System.out.println("What is the price($) ?");
					Double price= key.nextDouble();
					
					for (int i=0; i<inventory.length; i++)
					{
					/**checks to see if an object does exist at the index **/
						if (inventory[i]!=null)
							if (inventory[i].getPrice() <price)
								cheaperThan++;	/**increments the number of books cheaper than the entered price **/
					}
				
				/**displays how many books cheaper than the price entered exist: **/
					System.out.println("There exists " + cheaperThan + " book{s) under that price:");
					System.out.println();
					
					for (int i=0; i<inventory.length; i++)
					{
					/**checks to see if an object does exist at the index: **/
						if (inventory[i]!=null)
							if (inventory[i].getPrice() < price)
								System.out.println(inventory[i]);
					}
				}
			
			/**when option 5 is selected: **/
				else if (choice==5)
				{
					System.out.println("Goodbye sir!");
					System.exit(0); 	/**ends the program entirely **/
				}
				
			/**if the user wants to do more: **/
				System.out.println("\nWould you like to do anything else (y/n)");
				String again=key.next();
				
				if (again.equalsIgnoreCase("y") || again.equalsIgnoreCase("yes"))
					run=true;
				else
				{
					System.out.println("Goodbye! ");
					System.exit(0);;
				}
		}
		key.close(); 
			
	}
}
