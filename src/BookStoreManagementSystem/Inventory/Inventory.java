package BookStoreManagementSystem.Inventory;

import BookStoreManagementSystem.DBConnector.DBClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Inventory {

    /*Get the total count of books in store*/
    public void getTotalItemCount() {
        try {
            Connection connection = DBClass.getConnection();
            PreparedStatement pt;
            String sql = "SELECT COUNT(*) FROM BOOK";
            assert connection != null;
            pt = connection.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            System.out.println("The total Number of Books = " + count);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*Get the book count by each category*/
    public void getCategoryItemCount() {
        try {
            Connection connection = DBClass.getConnection();
            PreparedStatement pt;
            String sql = "SELECT bookCategory,COUNT(*) FROM BOOK GROUP BY bookCategory";
            assert connection != null;
            pt = connection.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
            int c = 0;
            while (rs.next()) {
                if (c == 0) {
                    System.out.println("**CATEGORY**");
                }
                String category = rs.getString(1);
                int count = rs.getInt(2);
                System.out.println(category + " = " + count + " Books");
                c++;
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*Get the details which are in Stock and which are not*/
    public void getStockStatus() {
        inStock();
        outStock();
    }
    /*Get details which are in stock*/
    private void inStock() {
        try {
            Connection connection = DBClass.getConnection();
            PreparedStatement pt;
            String sql = "SELECT bookID,bookTitle FROM BOOK WHERE bookQTY>0";
            assert connection != null;
            pt = connection.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
            int c = 0;
            while (rs.next()) {
                if (c == 0) {
                    System.out.println("**IN STOCK**");
                }
                String bookID = rs.getString(1);
                String bookTitle = rs.getString(2);
                System.out.println(bookID + "_" + bookTitle);
                c++;
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /*Get the details which are out of stock*/
    private void outStock() {
        try {
            Connection connection = DBClass.getConnection();
            PreparedStatement pt;
            String sql = "SELECT bookID,bookTitle FROM BOOK WHERE bookQTY<1";
            assert connection != null;
            pt = connection.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
            int c = 0;
            while (rs.next()) {
                if (c == 0) {
                    System.out.println("**Out of STOCK**");
                }
                String bookID = rs.getString(1);
                String bookTitle = rs.getString(2);
                System.out.println(bookID + "_" + bookTitle);
                c++;
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}