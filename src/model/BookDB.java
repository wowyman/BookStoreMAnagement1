package model;

import javafx.collections.*;
import DB.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDB {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        insertBook("4","da kiem","zed","1","lolllll","2020-1-4","1","3200","1");
        //deleteWithBookName("da kiem");
    }


    public static void insertBook(String id, String name, String tacGia, String XBlan, String theLoai, String namXB, String tap,String gia,String soLuong) throws SQLException, ClassNotFoundException {
        //Declare a INSERT statement
        String insertStmt =
                "INSERT INTO `book` (`bookId`, `bookTitle`, `authorName`, `XBlan`, `theLoai`, `namXB`, `tap`, `price`, `soLuong`) VALUES ('" +
                        id + "', '" + name + "', '" + tacGia + "', '" + XBlan + "', '" + theLoai + "', '" + namXB + "', '" + tap + "', '" + gia + "', '" + soLuong +  "');";

        //Execute INSERT operation
        try {
            DBUtil.dbExecuteUpdate(insertStmt);
            System.out.println("---------Insert thanh cong-------------------------");
        } catch (SQLException e) {
            System.out.print("Xuat hien loi khi insert book : " + e);
            throw e;
        }
    }
    //delete book
    public static void deleteWithBookName(String tensach) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "DELETE FROM `book` WHERE `book`.`bookTitle` = '"+ tensach + "'";


        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
            System.out.println("---------Delete thanh cong-------------------------");
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

    public static ObservableList<Book> search_all_book() throws SQLException, ClassCastException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM book";
        System.out.println("------>");

        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeList method and get employee object
            ObservableList<Book> bookList = getBookList(rs);

            //Return employee object
            return bookList;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }


    private static ObservableList<Book> getBookList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Book objects
        ObservableList<Book> bookList = FXCollections.observableArrayList();

        while (rs.next()) {
            Book book = new Book();

            book.setBookTitle(rs.getString("bookTitle"));
            book.setAuthor(rs.getString("authorName"));
            book.setBookId(rs.getString("bookId"));
            book.setNamXB(rs.getString("namXB"));
            book.setPrice(rs.getInt("price"));
            book.setSoLuong(rs.getInt("soLuong"));
            book.setXBlan(rs.getInt("XBlan"));
            book.setTap(rs.getInt("tap"));
            book.setTheLoai(rs.getString("theLoai"));


            bookList.add(book);
        }
        return bookList;
    }
    public static ObservableList<Book> search_by_bookName(String name) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM book WHERE bookTitle=" + "'" +name+"'";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeFromResultSet method and get employee object
            ObservableList<Book> bookList =getBookList(rsEmp);

            //Return employee object
            return bookList;
        } catch (SQLException e) {
            System.out.println("Xuat hien loi khi tim kiem sach co ten sach : " + name + " . " + e);
            //Return exception
            throw e;
        }
    }
    public static ObservableList<Book> search_by_tacGia(String tenTacGia) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM Book WHERE authorName=" + "'" + tenTacGia +"'";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeFromResultSet method and get employee object
            ObservableList<Book> bookList =getBookList(rsEmp);

            //Return employee object
            return bookList;
        } catch (SQLException e) {
            System.out.println("Xuat hien loi khi tim kiem sach co ten tac gia : " + tenTacGia + " . " + e);
            //Return exception
            throw e;
        }

    }


}
