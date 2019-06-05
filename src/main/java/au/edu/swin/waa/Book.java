package au.edu.swin.waa;
/**
 * This class consists of book information.
 *
 * @author Swathi Priya Kavuri
 */
public class Book {

	public int bookId;
	public String title;
	public String Author;
	public String publisher;
	public String PublishedDate;
	public String ISBN;
	public String status;
	
	
	/**
     * empty constructor
     */
	public Book (){
		
	}
	
	/**
     * Constructor for objects of class Book
     */
	
	public Book(String title,String status,String publisher,String publishedDate,String ISBN,String Author){
		this.title = title;
		this.status = status;
		this.publisher = publisher;
		this.PublishedDate = publishedDate;
		this.ISBN = ISBN;
		this.Author = Author;
		
	}
	
	/**
     * gets the id of the book
     * @return bookId
     */
	
	public int getBookId() {
		return bookId;
	}
	
	/**
     * method to set book Id
     * @parm bookId
     */
	
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	/**
     * gets the title of the book
     * @return title
     */
	
	public String getTitle() {
		return title;
		
	/**
	  * method to set book Title
	  * @parm title
	  */
	
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
     * gets the author of the book
     * @return author
     */
	
	public String getAuthor() {
		return Author;
	}
	
	/**
	  * method to set book author
	  * @parm author
	  */
	
	public void setAuthor(String author) {
		Author = author;
	}
	
	/**
     * gets the publisher of the book
     * @return publisher
     */
	
	public String getPublisher() {
		return publisher;
	}
	
	/**
	  * method to set book publisher
	  * @parm publisher
	  */
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	/**
     * gets the published date of the book
     * @return publishedDate
     */
	
	public String getPublishedDate() {
		return PublishedDate;
	}
	
	/**
	  * method to set book published date
	  * @parm publishedDate
	  */
	
	public void setPublishedDate(String publishedDate) {
		PublishedDate = publishedDate;
	}
	
	
	/**
     * gets the isbn of the book
     * @return ISBN
     */
	public String getISBN() {
		return ISBN;
	}
	
	/**
	  * method to set book isbn
	  * @parm iSBN
	  */
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	/**
     * gets the status of the book
     * @return status
     */
	public String getStatus() {
		return status;
	}
	
	/**
	  * method to set book status
	  * @parm status
	  */
	
	public void setStatus(String status) {
		this.status = status;
	}
}
