
/**
 * This is the Book class where all the books will be created for the Bookstore to contain.
 * Everything related to creating the books are in this class, from the author, the title, the ISBN and
 * the price. It contains all the methods asked for including the accessor methods, mutator methods, toString method etc.
 */
public class Book 
{
/**attributes of the books: **/
	
	private String title;	
	private String author;
	private double ISBN;
	private double price; 
	private static int numBooks=0;	/**the number of books initially set is 0 because no books have been created **/

/**default constructor: **/
	public Book()
	{
		numBooks++;	/**every time a book is created, the number of books increments **/
	}
/**constructor created with provided arguments: **/
	public Book(String t, String a, double I, double p)
	{
		title= t;
		author=a;
		ISBN= I;
		price=p;
		numBooks++;		/*every time a book is created, the number of books increments **/
	}
	
/**Copy constructor:*/
	public Book(Book b)
	{
		this.title=b.title;
		this.author=b.author;
		this.ISBN=b.ISBN;
		this.price=b.price;
	}
	
/**accessors (getter methods): **/
	
/**returns Title of book **/
	public String getTitle()	
	{
		return title;
	}
/**returns Author of book **/
	public String getAuthor()	
	{
		return author;
	}
/**returns ISBN of the book **/
	public double getISBN()		 
	{
		return ISBN;
	}
/**returns the price of the book **/
	public double getPrice()	
	{
		return price;
	}
	
/**mutators (setter methods): **/
	
/**sets the title of the book **/
	public void setTitle(String t)	
	{
		title=t;
	}
/**sets the author of the book **/
	public void setAuthor(String a)	
	{
		author=a;
	}
/**sets the ISBN of the book **/
	public void setISBN(double I)	
	{
		ISBN=I;
	}
/**sets the price of book **/
	public void setPrice(double p)	
	{
		price=p;
	}
	
	/**
	 * toString method
	 */
	public String toString()
	{
		return ("Title of the book is: " + title + ", Author: " + author + ", ISBN " + ISBN + " and the price is " 
	+ price + "$");
	}
	
/**Method that finds and returns the number of books created: **/
	
	public static int findNumberOfCreatedBooks()
	{
		return numBooks;
	}

/**Method that compares the equality of two books to determine if they are one and the same **/
	public boolean equals(Book b1)
	{
		return (this.price==b1.price && this.ISBN==b1.ISBN);	/**books are equivalent if price and ISBN are the same **/
	}
	
}




