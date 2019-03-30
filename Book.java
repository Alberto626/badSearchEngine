package hw06;
import java.time.LocalDate;
import java.time.Period;

public class Book {
	private String title;
	private String authorFirstName;
	private String authorLastName;
	private String ISBN;
	private int numberOfPages;
	private LocalDate dateCheckedOut;
	private LocalDate dueDate;
	
	public Book(String title, String authorFirstName, String authorLastName, String ISBN, int numberOfPages) {
		this.title = title;
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
		this.ISBN = ISBN;
		this.numberOfPages = numberOfPages;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthorFirstName() {
		return authorFirstName;
	}
	public String getAuthorLastName() {
		return authorLastName;
	}
	public String getISBN() {
		return ISBN;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void checkOut() {
		dateCheckedOut = LocalDate.now();
		dueDate = dateCheckedOut.plusDays(14);
	}
	public void checkin() {
			int randomDate = (int)(Math.random() * 36);
			
			LocalDate returnedBook = dateCheckedOut.plusDays(randomDate);
			
			Period DaysBetween = Period.between(dateCheckedOut, returnedBook);
			int daysBTW = DaysBetween.getDays();
			int fine = 0;
			
			if(daysBTW > 14) {
				fine = daysBTW - 14; 
				System.out.println("Your fine is " + fine + " dollars");
			}
			dateCheckedOut = null;
			dueDate = null;
			
	}
	public String toString() {
		String rep = "Title: " +  title;
		rep +=  "\nAuthor: " + authorFirstName + " "+ authorLastName;
		rep += "\nISBN: " + ISBN;
		rep += "\nNumber Of Pages: " + numberOfPages;
		rep += "\nDate Check Out: " + dateCheckedOut;
		rep += "\nDate Checked In: " + dueDate + "\n";
		
		
		return rep;
	}
	
}
