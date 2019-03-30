package hw06;
import java.util.ArrayList;
public class BookList extends ArrayList<Book> {

	public BookList() {

	}
	public void addBook(Book book) {
		super.add(book);
	}
	public Book getBookTitle(String title) {
		for(int x = 0; super.size() > x; x++) {
			int y = title.trim().compareToIgnoreCase(super.get(x).getTitle().trim());
			if(y == 0) {
				return super.get(x);
			}
		}
		return null;
	}
	public Book getBooksbyAuthor(String author) {
		
		for(int x = 0; super.size() > x; x++) {
			String authorsFullName = super.get(x).getAuthorFirstName() +" " + super.get(x).getAuthorLastName();
			int y = author.trim().compareToIgnoreCase(authorsFullName);
			if(y == 0) {
				return super.get(x);
			}
		}
		return null;
	}
	public Book getBooksByISBN(String ISBN) throws NumberFormatException {
		ISBN = ISBN.trim();
		if(ISBN.length() > 13 || ISBN.length() < 10) {
			throw new ISBNNumberFormatException("the ISBN is not 10 to 13 characters long");
		}
		double ISBNNumber = Double.parseDouble(ISBN); // this will throw a numberformat exception if doesnt work
		for(int x = 0; super.size() > x; x++) {
			double ISBNFromBookList = Double.parseDouble(super.get(x).getISBN());
			if(ISBNFromBookList == ISBNNumber) {
				return super.get(x);
			}
		}
		return null;
	}
}
