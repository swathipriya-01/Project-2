package au.edu.swin.waa;

import java.util.ArrayList;
/**
 * A class consisting of information of books
 * 
 */
public class Library {
	public ArrayList<Book> Books;

	public ArrayList<Book> getAvailableBooks() {
		BookDataBase db = new BookDataBase();
		return db.getAllBooks();
	}
	
	/**
     * method to add view student records in to the database
     * @parm student id
     * 
     */

	public ArrayList<StudentBorrowingRecord> viewStudentBorrowedRecords(
			int studentID) {
		BookDataBase db = new BookDataBase();
		return db.getStudentRecord(studentID);
	}

	/**
     * method to add book in to the database
     * @parm book
     * @return String
     */
	public String addBook(Book book) {
		BookDataBase db = new BookDataBase();
		if (db.checkBookinDB(book.ISBN))
			return "Book is already present";
		db.AddBook(book);
		return "Book is added to Database";
	}

	/**
     * method to update book in to the database
     * @parm Id, title
     * @return String
     */ 
	public String updateBook(int id, String title) {
		BookDataBase db = new BookDataBase();
		if (db.UpdateBook(id, title))
			return "Book found and is updated";
		else
			return "Book not found please enter correct Id";
	}
	
	/**
     * method to delete book in to the database
     * @parm Id
     * @return String
     */

	public String deleteBook(int id) {
		BookDataBase db = new BookDataBase();
		if (db.DeleteBook(id))
			return "Book is deleted";
		else
			return "Book not found, enter correct ID";
	}

	/**
     * method to get book from the database
     * @parm Id
     * @return book
     */
	public Book getBook(int id) {
		BookDataBase db = new BookDataBase();
		return db.getBook(id);
	}

	/**
     * method to get all books from the database
     * return books
     * 
     */
	public ArrayList<Book> getAllBooks() {
		BookDataBase db = new BookDataBase();
		return db.getAllBooks();
	}

	/*public String RequestNewBook(int StudentId, String ISBN) {
		BookDataBase db = new BookDataBase();
		GoogleBookInventory googleBook = new GoogleBookInventory();
		if (!db.checkBookinDB(ISBN)) {
			if (!db.checkBookOrder(ISBN)) {
				if (!googleBook.validateIsbn(ISBN)) {
					return "ISBN is not validated";
				} else {
					Book book = googleBook.assessQuality(ISBN);
					if (book != null) {
						book.status = "Back_Order";
						db.AddBook(book);
						db.AddRequest(ISBN, StudentId, book.bookId);
					} else {
						return "Book is not of good quality";
					}
				}
			} else
				return "Book has been already placed order";
		}

		return "Book is already present in the Library";
	}*/

	/**
     * method to borrow book in the library
     * @parm StudentId, bookid
     * @return book
     */
	public String BorrowBook(int studentId, int id) {
		BookDataBase db = new BookDataBase();
		return db.BorrowBook(studentId, id);

	}

}

// }
