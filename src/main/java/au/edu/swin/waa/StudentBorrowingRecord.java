package au.edu.swin.waa;
/**
 * This class consists of student borrowing information.
 *
 * @author Swathi Priya Kavuri
 */
public class StudentBorrowingRecord {

	public int bookId;
	public int studentid;
	public String ISBN;
	public String status;
	
	/**
     * empty constructor
     */
	public StudentBorrowingRecord(){
		
	}
	
	/**
     * Constructor for objects of class student borrowing records
     */
	public StudentBorrowingRecord(int bookid,int studentid,String ISBN,String status){
		this.bookId = bookid;
		this.studentid = studentid;
		this.ISBN = ISBN;
		this.status = status;				
	}
	
	/**
     * gets the id of the book which student borrowed
     * @return bookId
     */
	public int getBookId() {
		return bookId;
	}
	/**
     * method to set book Id which student borrowed
     * @parm bookId
     */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	/**
     * gets the id of the student 
     * @return studentId
     */
	public int getStudentId() {
		return studentid;
	}
	
	/**
     * method to set student Id 
     * @parm bookId
     */
	public void setStudentId(int studentid) {
		this.studentid = studentid;
	}
	
	/**
     * gets the isbn 
     * @return isbn
     */
	public String getISBN() {
		return ISBN;
	}
	
	/**
     * method to set book isbn
     * @parm isbn
     */
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	/**
     * gets the status
     * @return status
     */
	public String getStatus() {
		return status;
	}
	
	/**
     * method to set status of the book which student borrowed
     * @parm status
     */
	public void setStatus(String status) {
		this.status = status;
	}
}
