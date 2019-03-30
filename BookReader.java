package hw06;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class BookReader {

	private BookReader() {

	}
	public static BookList parseBookFile(File file) throws FileTypeException {
		BookList bookList = new BookList();
		if(file.getName().charAt(file.getName().length()-1) != 'v' ||
				file.getName().charAt(file.getName().length()-2) != 's' ||
				file.getName().charAt(file.getName().length()-3) != 'c' ||
				file.getName().charAt(file.getName().length()-4) != '.') {
			throw new FileTypeException("Wrong extension");
		}
		try(Scanner reader = new Scanner(file)) {
			while(reader.hasNextLine()) {
				String nextLine = reader.nextLine();
				String[] splitLine = nextLine.split(",");
				Book book = new Book(splitLine[0], splitLine[1],splitLine[2],splitLine[3],Integer.parseInt(splitLine[4]));
				bookList.add(book);
			}
			return bookList;
		}
		catch(FileNotFoundException ex) {
			System.out.println("File not found! System must exit");
			System.exit(0);
			return null;

		}




	} 
}

