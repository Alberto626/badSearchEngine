/*Alberto Landeros
 * CIN:306512276
 * CS2012 section 1 & 2
 * this program asks the user alot of questions which are if ur looking for a specific book,
 * which method will it be like ISBN, author name, or title but first it will ask which specific file it will ask for
 */
package hw06;
import java.util.Scanner;
import java.io.File;
public class Booktester {
	static Scanner userInput = new Scanner(System.in);
	public static void main(String[] args) {
		BookList allBooks;
		File file;
		while(true) {
			try {
				System.out.println("What is the name of the file you are looking for?");
				String fileName = userInput.nextLine();
				file = new File(fileName);
				allBooks = BookReader.parseBookFile(file);
				break;
			}
			catch(FileTypeException ex) {
				System.out.println(ex);

			}
		}
		System.out.println("What is your search method for find a book? (ISBN, Title, Author)");
		while(true) {
			String searchMethod = userInput.nextLine();
			if(searchMethod.compareToIgnoreCase("title") == 0) {
				searchTitle(allBooks);
				break;
			}
			else if(searchMethod.compareToIgnoreCase("author") == 0) {
				searchAuthor(allBooks);
				break;
			}
			else if (searchMethod.compareToIgnoreCase("ISBN") == 0){
				while(true) {
					try {
						searchISBN(allBooks);
						break;
					}
					catch(ISBNNumberFormatException ex) {
						System.out.println(ex);
					}
					catch(NumberFormatException ex) {
						System.out.println(ex + "\nThere are characters in your ISBN! Please try again");
					}
				}
				break;
			}
			else {
				System.out.println("Which method?");
			}
		}
	}
	public static void searchTitle(BookList allBooks) {
		BookList temp = allBooks;
		System.out.println("What is the title of the book you are looking for?");
		String title = userInput.nextLine();

		if(temp.getBookTitle(title) == null) {
			System.out.println("This book was not found");
		}
		else {
			System.out.println(temp.getBookTitle(title));
			checkOutOptionTitle(allBooks,title);
		}
	}
	public static void searchAuthor(BookList allBooks) {
		BookList temp = allBooks;
		System.out.println("What is the authors first fame?");
		String authorsFirst = userInput.nextLine();
		System.out.println("What is the authors last name?");
		String authorsLast = userInput.nextLine();
		if(temp.getBooksbyAuthor(authorsFirst + " " + authorsLast) == null) {
			System.out.println("This book was not found");
		}
		else {
			System.out.println(temp.getBooksbyAuthor(authorsFirst + " " + authorsLast));
		}
	}
	public static void searchISBN(BookList allBooks) throws ISBNNumberFormatException, NumberFormatException {
		BookList temp = allBooks;
		System.out.println("What is the ISBN of the book");
		String ISBN = userInput.nextLine();
		if(temp.getBooksByISBN(ISBN) == null) {
			System.out.println("The book was not found");
		}
		else {
			System.out.println(temp.getBooksByISBN(ISBN));
			checkOutOptionISBN(allBooks, ISBN);

		}
	}
	public static void checkOutOptionISBN(BookList book, String ISBN) {
		System.out.println("Do you want to check it out?");
		String answer = userInput.nextLine();
		while(true) {
			if(answer.trim().compareToIgnoreCase("yes") == 0) {
				book.getBooksByISBN(ISBN).checkOut();
				System.out.println("Do you want to check it in?");
				answer = userInput.nextLine();
				if(answer.trim().compareToIgnoreCase("yes") == 0) {
					System.out.println("Thank you!");
					book.getBooksByISBN(ISBN).checkin();
				}
				else {
					System.out.println("ok nevermind");
				}
				break;
			}
			else if(answer.trim().compareToIgnoreCase("no") == 0) {
				System.out.println("Okay! Next Please");
				System.exit(0);
				break;	
			}
			else {
				System.out.println("Please answer the question");
			}
		}
	}
	public static void checkOutOptionTitle(BookList book, String title) {
		System.out.println("Do you want to check it out?");
		String answer = userInput.nextLine();
		while(true) {
			if(answer.trim().compareToIgnoreCase("yes") == 0) {
				book.getBookTitle(title).checkOut();
				System.out.println("Do you want to check it in");
				answer = userInput.nextLine();
				if(answer.trim().compareToIgnoreCase("yes") == 0) {
					System.out.println("Thank you!");
					book.getBookTitle(title).checkin();
				}
				else {
					System.out.println("ok nevermind");
				}
				break;
			}
			else if(answer.trim().compareToIgnoreCase("no") == 0) {
				System.out.println("Okay! Next Please");
				System.exit(0);
				break;	
			}
			else {
				System.out.println("Please answer the question");
			}
		}
	}

}


