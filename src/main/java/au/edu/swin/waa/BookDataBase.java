package au.edu.swin.waa;
//import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * method to connect to the database using mysql
 * 
 */
public class BookDataBase {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/bookDatabase";

    static final String USER = "root";
    static final String PASS = "1234";
    
    public ArrayList<StudentBorrowingRecord> getStudentRecord(int studentid){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// build connection
	        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

	        // create statement
	        Statement statement = connection.createStatement();

	        // select query
	        String booksQuery = "Select * from studentBorrowingRecords where studentID = "+studentid+";";

	        // execute query
	        ResultSet rs = statement.executeQuery(booksQuery);
	        ArrayList<StudentBorrowingRecord> records = new ArrayList<StudentBorrowingRecord>();
	        
	        while(rs.next()){
	        	StudentBorrowingRecord rec = new StudentBorrowingRecord(Integer.parseInt(rs.getString("BookID")),Integer.parseInt(rs.getString("studentID")),rs.getString("status"),rs.getString("ISBN"));
            	records.add(rec); 
	        }
	        connection.close();
	        return records;
		    } catch (Exception e) {
			e.printStackTrace();
		    }
			return null;
		}
    
    /**
     * method to add student borrowing records in to the database
     * @parm ISBN, StudentId, bookid
     */
	    	   
	public void AddRequest(String ISBN,int StudentId,int bookid){
		try {			
			Class.forName("com.mysql.jdbc.Driver");
			// build connection
	        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

	        // create statement
	        Statement statement = connection.createStatement();

	        // select query
	        String booksQuery = "INSERT INTO studentBorrowingRecords(studentID,ISBN,BookID,status) Values ('"+StudentId+"','"+ ISBN +"',"+bookid+"'Requested');" ;

	        // execute query
	        statement.executeUpdate(booksQuery);
	        connection.close();
	        System.out.println("Order has been placed for the requested book");
			
		    } catch (Exception e) {
			e.printStackTrace();
		    }
	}
	
	/**
     * method to check book in to the student borrowing records
     * @parm ISBN
     */
    public Boolean checkBookOrder(String ISBN){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// build connection
	        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

	        // create statement
	        Statement statement = connection.createStatement();

	        // select query
	        String booksQuery = "Select * from studentBorrowingRecords Where ISBN = '"+ ISBN +"';";

	        // execute query
	        ResultSet rs = statement.executeQuery(booksQuery);
	        if(rs.next())
	        	return true;
	        connection.close();
	        
		}
		catch (Exception e) {
			e.printStackTrace();
		    }
			return false;
	}
    
    /**
     * method to borrow book in the library
     * @parm StudentId, bookid
     * @return book
     */
	public String BorrowBook(int StudentId,int Bookid){
		String result="Book not found";
		try{
			
		Class.forName("com.mysql.jdbc.Driver");
		// build connection
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

        // create statement
        Statement statement = connection.createStatement();

        // select query
        String booksQuery = "Select * from Book Where BookId = "+ Bookid+";";

        // execute query
        ResultSet rs = statement.executeQuery(booksQuery);
        if(rs.next()) {
        	  String status = rs.getString("Status");
        	  String ISBN = rs.getString("ISBN");
        	  if(status.equalsIgnoreCase("available")){
        		  String updateQuery = "Update Book set status = 'Loan' Where BookId = '"+Bookid+"';";
        		  statement.executeUpdate(updateQuery);
        		  System.out.println(ISBN);
        		  String insertQuery = "INSERT INTO studentBorrowingRecords(StudentID,BookID,status,ISBN) VALUES ('" + StudentId +"','"+Bookid+"','Borrowed','"+ISBN+"');";
        		  statement.executeUpdate(insertQuery);
        		  result= "Book is borrowed";
        	  }
        	  else{
        		  result= "Book is not available";
        	  }
        	}		
		else
		{
			result= "Book not found,Please enter correct Book Id";
		}
	}
		catch(Exception e){
			System.out.println("Exception Occured in Mysql Database");
		}
		return result;
	}
	
	/**
     * method to get book from the database
     * @parm Id
     */
    public Book getBook(int id){
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		// build connection
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // create statement
            Statement statement = connection.createStatement();

            // select query
            String booksQuery = "Select * from Book WHERE BookId = " + id;

            // execute query
            ResultSet rs = statement.executeQuery(booksQuery);
            while(rs.next()){
            	Book book = new Book(rs.getString("Title"),rs.getString("Status"),rs.getString("Publisher"),rs.getString("PublishedDate"),rs.getString("ISBN"),rs.getString("Author"));
            	book.bookId = Integer.parseInt(rs.getString("BookId"));        	
            	return book;
            }
            connection.close();
    	    } catch (Exception e) {
    		e.printStackTrace();
    	    }
    		return null;
    	}
    	
    /**
     * method to check book in to the database
     * @parm ISBN
     */
    	public Boolean checkBookinDB(String ISBN){
    		Boolean result = false;
    		try{
    			Class.forName("com.mysql.jdbc.Driver");
    			// build connection
    	        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

    	        // create statement
    	        Statement statement = connection.createStatement();

    	        // select query
    	        String booksQuery = "Select * from Book Where ISBN = '"+ ISBN +"';";

    	        // execute query
    	        ResultSet rs = statement.executeQuery(booksQuery);
    	        if(rs.next())
    	        	result = true;
    	        connection.close();
    	        
    		}
    		catch (Exception e) {
    			e.printStackTrace();
    		    }
    			return result;
    	}
    	
    	/**
         * method to get all the books from the database
         * @return book
         */
    	public ArrayList<Book> getAllBooks(){
    		try {
    			Class.forName("com.mysql.jdbc.Driver");
    			// build connection
    	        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

    	        // create statement
    	        Statement statement = connection.createStatement();

    	        // select query
    	        String booksQuery = "Select * from Book;";

    	        // execute query
    	        ResultSet rs = statement.executeQuery(booksQuery);
    	        ArrayList<Book> books = new ArrayList<Book>();
    	        
    	        while(rs.next()){
    	        	Book book = new Book(rs.getString("Title"),rs.getString("Status"),rs.getString("Publisher"),rs.getString("PublishedDate"),rs.getString("ISBN"),rs.getString("Author"));
    	        	book.bookId = Integer.parseInt(rs.getString("BookID"));        	
    	        	books.add(book);
    	        }
    	        connection.close();
    	        return books;
    		    } catch (Exception e) {
    			e.printStackTrace();
    		    }
    			return null;
    		}
    	/**
         * method to update book in to the database
         * @parm Id, title
         * @return boolean
         */    	
    	public Boolean UpdateBook(int id,String title){
    		Boolean result = false;
    		try {
    			Class.forName("com.mysql.jdbc.Driver");
    			// build connection
    	        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

    	        // create statement
    	        Statement statement = connection.createStatement();

    	        // select query
    	        String booksQuery = "UPDATE Book SET Title = '" + title +"' WHERE BookId = " + id;

    	        // execute query
    	        int rowsAffected = statement.executeUpdate(booksQuery);
    	        connection.close();
    	        if(rowsAffected == 0)
    	        	result = false;
    	        else
    	        	result = true;
    		    } catch (Exception e) {
    			e.printStackTrace();    			
    		    }
    			return result;
    	}
    	
    	/**
         * method to delete book in to the database
         * @parm Id
         * @return boolean
         */ 
    	public Boolean DeleteBook(int id){
    		Boolean result = false;
    		try {
    			 
    			Class.forName("com.mysql.jdbc.Driver");
    			// build connection
    	        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

    	        // create statement
    	        Statement statement = connection.createStatement();

    	        // select query
    	        String booksQuery = "DELETE FROM Book WHERE BookID = " + id ;

    	        // execute query
    	        int rowsAffected = statement.executeUpdate(booksQuery);
    	        connection.close();
    	        if(rowsAffected == 0)
    	        	result = false;
    	        else
    				result = true;
    		    } catch (Exception e) {
    			e.printStackTrace();
    		    }
    			return result;
    	}
    	
    	/**
         * method to add book in to the database
         * @parm book
         * 
         */ 
    	public void AddBook(Book book){
    		try {			
    			Class.forName("com.mysql.jdbc.Driver");
    			// build connection
    	        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

    	        // create statement
    	        Statement statement = connection.createStatement();

    	        // select query
    	        String booksQuery = "INSERT INTO Book(Title, Author, ISBN, Publisher, PublishedDate,Status,BookID) Values ('"
    	        					  + book.title + "','" + book.Author + "','" + book.ISBN +"','" + book.publisher + "','" + 
    	        					  book.PublishedDate + "','" + book.status +"',"+book.bookId+");" ;

    	        // execute query
    	        statement.executeUpdate(booksQuery);
    	        connection.close();
    	        System.out.println("Book has been added to database");
    			
    		    } catch (Exception e) {
    			e.printStackTrace();
    		    }			
    	}
    	
    	/**
         * method to get student records from the database
         * @parm StudentId
         * @return books
         */ 
    	public ArrayList<Book> getStudentRecords(String StudentId){
    		try {
    			Class.forName("com.mysql.jdbc.Driver");
    			// build connection
    	        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

    	        // create statement
    	        Statement statement = connection.createStatement();

    	        // select query
    	        String booksQuery = "select book.BookId,book.Author,book.ISBN,book.Status,book.Publisher,book.PublishedDate,book.Title from Books book inner join Borrower s on s.BookId = book.BookId where s.StudentId = '"+StudentId+"';";

    	        // execute query
    	        ResultSet rs = statement.executeQuery(booksQuery);
    	        ArrayList<Book> books = new ArrayList<Book>();
    	        
    	        while(rs.next()){
    	        	Book book = new Book(rs.getString("Title"),rs.getString("Status"),rs.getString("Publisher"),rs.getString("PublishedDate"),rs.getString("ISBN"),rs.getString("Author"));
    	        	book.bookId = Integer.parseInt(rs.getString("BookId"));        	
    	        	books.add(book);
    	        }
    	        connection.close();
    	        return books;
    		    } catch (Exception e) {
    			e.printStackTrace();
    		    }
    			return null;
    	}    	    	
}
