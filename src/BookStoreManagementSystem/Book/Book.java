package BookStoreManagementSystem.Book;
import BookStoreManagementSystem.DBConnector.DBClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Book {

    private String bookID;
    private String bookTitle;
    private String bookAuthor;
    private String bookPublisher;
    private String bookYear;
    private String bookCategory;
    private String bookPrice;
    private int bookQTY;

    Scanner input = new Scanner(System.in);

    public Book() {
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public void setBookYear(String bookYear) {
        this.bookYear = bookYear;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public void setBookQTY(int bookQTY) {
        this.bookQTY = bookQTY;
    }

    public String getBookID() {
        return bookID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public String getBookYear() {
        return bookYear;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public int getBookQTY() {
        return bookQTY;
    }

    /*Check availability and add book*/
    public void addBook() {
        System.out.print("Enter Book ID : ");
        this.setBookID(input.nextLine());
        /*check whether book is exists or not*/
        viewBook();
        if (this.getBookTitle() == null) {
            /*get book details from user*/
            getBookDetails();
            /*add book details to the database*/
            addItem();
            System.out.println("---Book has bean Added---\n");
        } else {
            System.out.println("****ALREADY EXISTS A BOOK WITH THIS ID****\n");
        }
    }

    /*Add book details into database*/
    private void addItem() {
        try {
            Connection connection = DBClass.getConnection();
            PreparedStatement pt;
            String sql = "INSERT INTO BOOK VALUES(?,?,?,?,?,?,?,?)";
            assert connection != null;
            pt = connection.prepareStatement(sql);
            pt.setString(1, this.bookID);
            pt.setString(2, this.bookTitle);
            pt.setString(3, this.bookAuthor);
            pt.setString(4, this.bookPublisher);
            pt.setString(5, this.bookYear);
            pt.setString(6, this.bookCategory);
            pt.setString(7, this.bookPrice);
            pt.setInt(8, this.bookQTY);
            pt.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*Check availability and update book*/
    public void updateBook() {
        /*get book details from user*/
        System.out.print("Enter Book ID : ");
        this.setBookID(input.nextLine());
        /*check whether book is exists or not*/
        viewBook();
        if (this.getBookTitle() == null) {
            System.out.println("****DOESN'T EXISTS A BOOK WITH THIS ID****\n");
        } else {
            /*get book details from user*/
            getBookDetails();
            /* Update book details into database */
            updateItem();
            System.out.println("---Book has bean Updated---\n");
        }
    }

    /*Update book details in database*/
    private void updateItem() {
        try {
            Connection connection = DBClass.getConnection();
            PreparedStatement pt;
            String sql = "UPDATE BOOK SET bookTitle=?,bookAuthor=?,bookPublisher=?,bookCategory=?,bookYear=?,bookPrice=?,bookQTY=? "
                    + "WHERE bookID=?";
            assert connection != null;
            pt = connection.prepareStatement(sql);
            pt.setString(1, this.bookTitle);
            pt.setString(2, this.bookAuthor);
            pt.setString(3, this.bookPublisher);
            pt.setString(4, this.bookCategory);
            pt.setString(5, this.bookYear);
            pt.setString(6, this.bookPrice);
            pt.setInt(7, this.bookQTY);
            pt.setString(8, this.bookID);
            pt.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*Retrieve book details from the database*/
    public void viewBook() {
        try {
            Connection connection = DBClass.getConnection();
            PreparedStatement pt;
            String sql = "SELECT bookTitle,bookAuthor,bookPublisher,bookYear,bookCategory,bookPrice,bookQTY "
                    + "FROM BOOK WHERE bookID=?";
            assert connection != null;
            pt = connection.prepareStatement(sql);
            pt.setString(1, this.bookID);

            ResultSet rs = pt.executeQuery();
            if (rs.next()) {
                this.bookTitle = rs.getString(1);
                this.bookAuthor = rs.getString(2);
                this.bookPublisher = rs.getString(3);
                this.bookYear = rs.getString(4);
                this.bookCategory = rs.getString(5);
                this.bookPrice = rs.getString(6);
                this.bookQTY = rs.getInt(7);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*get book details from user*/
    private void getBookDetails() {
        System.out.print("Enter Book Title : ");
        this.setBookTitle(input.nextLine());
        System.out.print("Enter Book Author : ");
        this.setBookAuthor(input.nextLine());
        System.out.print("Enter Book Publisher : ");
        this.setBookPublisher(input.nextLine());
        System.out.print("Enter Published Year : ");
        this.setBookYear(input.nextLine());
        System.out.print("Enter Book Category : ");
        this.setBookCategory(input.nextLine());
        System.out.print("Enter Book Price : ");
        this.setBookPrice(input.nextLine());
        System.out.print("Enter Number of Quantity : ");
        this.setBookQTY(Integer.parseInt(input.nextLine()));
    }

    /*Remove book*/
    public void removeBook() {
        /*get book details from user*/
        System.out.print("Enter Book ID : ");
        this.setBookID(input.nextLine());

        /*remove book details from database*/
        removeItem();
        System.out.println("-----Book has been Removed-----\n");
    }

    /*Remove book details from the database*/
    public void removeItem() {
        try {
            Connection connection = DBClass.getConnection();
            PreparedStatement pt;
            String sql = "DELETE FROM BOOK WHERE bookID=?";
            assert connection != null;
            pt = connection.prepareStatement(sql);
            pt.setString(1, this.bookID);
            pt.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*Retrieve book details from database and display**/
    public void searchBook() {
        /*get book details from user*/
        System.out.print("Enter Book ID : ");
        this.setBookID(input.nextLine());

        /*get book details from database*/
        viewBook();

        /*Output the details of book if exists*/
        if (this.getBookTitle() == null) {
            System.out.println("****DOESN'T EXISTS A BOOK WITH THIS ID****\n");
        } else {
            System.out.println("--------------BOOK--------------");
            System.out.println("Book ID : " + this.getBookID());
            System.out.println("Book Title : " + this.getBookTitle());
            System.out.println("Book Author : " + this.getBookAuthor());
            System.out.println("Book Publisher : " + this.getBookPublisher());
            System.out.println("Published Year : " + this.getBookYear());
            System.out.println("Book Category : " + this.getBookCategory());
            System.out.println("Book Price : " + this.getBookPrice());
            System.out.println("Number of Quantity : " + this.getBookQTY());
            System.out.println("--------------------------------");
        }

    }
}
