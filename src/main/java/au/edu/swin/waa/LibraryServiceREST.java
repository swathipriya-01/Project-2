package au.edu.swin.waa;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;

/**
 * This class consists of book information in a rest service.
 *
 * @author Swathi Priya Kavuri
 */
public class LibraryServiceREST {

	private Library lib = new Library();

	// Add a book to the server
	public String addBook(Book book) {
		return lib.addBook(book);
	}

	/*public String orderBook(String ISBN, int studentid) {
		return lib.RequestNewBook(studentid, ISBN);
	}*/

	/**
     * method to add view student records in to the server
     * @parm student id
     * 
     */
	public ArrayList<StudentBorrowingRecord> viewStudentBorrowedRecords(
			int studentID) {
		return lib.viewStudentBorrowedRecords(studentID);
	}

	/**
     * method to update book in to the server
     * @parm Id, title
     * @return String
     */ 

	public String updateBook(int id, String title) {
		return lib.updateBook(id, title);

	}
	
	/**
     * method to delete book in to the server
     * @parm Id
     * @return String
     */

	public String deleteBook(int id) {
		return lib.deleteBook(id);
	}


	/**
     * method to borrow book in the library
     * @parm StudentId, bookid
     * @return book
     */
	public String BorrowBook(int StudentId, int BookId) {
		return lib.BorrowBook(StudentId, BookId);
	}
	

	/**
     * method to view book in the library
     * 
     * @return books
     */

	public ArrayList<Book> viewBookRecords() {
		ArrayList<Book> books = lib.getAllBooks();
		/*
		 * if(books.size()>0) { for(int i = 0; i< books.size();i++) {
		 * System.out.println("---------------------------------------------");
		 * System.out.println("Book Id:" + books.get(i).getBookId());
		 * System.out.println("Title:" + books.get(i).getTitle());
		 * System.out.println("ISBN:" + books.get(i).getISBN());
		 * System.out.println("Status:" + books.get(i).getStatus());
		 * System.out.println("Author:" + books.get(i).getAuthor());
		 * System.out.println("Publisher:" + books.get(i).getPublisher());
		 * System.out.println("Published Date:" +
		 * books.get(i).getPublishedDate()); } } else
		 * System.out.println("Books are not pesent in library");
		 */
		return books;
	}


	/**
     * method to get book in the server
     * @parm StudentId, bookid
     * @return book
     */
	public OMElement getBook(int id) throws XMLStreamException {
		Book book = lib.getBook(id);
		// return book;
		String result = "";
		if (book != null) {
			result = "<getBookResponse>";			
			result = result + "<BookId>" + book.getBookId()+"</BookId>";
			result = result + "<Title>" + book.getTitle()+"</Title>";
			result = result + "<ISBN>" + book.getISBN() +"</ISBN>";
			result = result + "<Status>" + book.getStatus()+"</Status>";
			result = result + "<Author>" + book.getAuthor()+"</Author>";
			result = result + "<Publisher>" + book.getPublisher()+"</Publisher>";
			result = result + "<PublishedDate>" + book.getPublishedDate()+"</PublishedDate></getBookResponse>";
		} else
			result = "<getBookResponse><result>"+"Requested Book not found"+"</result></getBookResponse>";
		return new StAXOMBuilder(new ByteArrayInputStream(result.getBytes())).getDocumentElement();
	}
	/*
	 * public String updateBook(Integer bookId, Book book) { if
	 * (map.keySet().contains(bookId)) { map.put(bookId, book); return
	 * "The book Id " + bookId + " has been updated"; } return "The book Id " +
	 * bookId + " does not exist!"; }
	 * 
	 * // Retrieve a book from a bookId public Book getBook(Integer bookId) { if
	 * (map.keySet().contains(bookId)) return map.get(bookId); else return null;
	 * }
	 * 
	 * // Delete an existing book public String deleteBook(Integer bookId) {
	 */
	/*
	 * if (map.keySet().contains(bookId)) { map.remove(bookId); return
	 * "The book Id " + bookId + " has been deleted!"; } return "The book Id " +
	 * bookId + " does not exist!"; }
	 */

	/*
	 * public String viewAllBooks(){
	 * 
	 * }
	 */

	/*
	 * public String getStudentRecord (String stuId){
	 * 
	 * }
	 */

	/*
	 * public String updateStudentRecord (String StuId){
	 * 
	 * }
	 */

}