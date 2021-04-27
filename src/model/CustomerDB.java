package model;

import DB.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDB {
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//
//        //insertCustomer("1","zed","20","ilonia","0987654321","");
//        deleteWithCustomerCMND("2");
//
//    }


    public static void insertCustomer(String CMND, String name, String age, String address, String phoneNumber, String MSPM) throws SQLException, ClassNotFoundException {
        //MSPM co the la Null
        String insertStmt=null;
        if(MSPM == "") {
            insertStmt =
                    "INSERT INTO `customers` (`CMND`, `Name`, `Age`, `Address`, `PhoneNumber`, `MSPM`) VALUES ('" +
                            CMND + "', '" + name + "', '" + age + "', '" + address + "', '" + phoneNumber + "', NULL);";
        } else {
            insertStmt =
                    "INSERT INTO `customers` (`CMND`, `Name`, `Age`, `Address`, `PhoneNumber`, `MSPM`) VALUES ('" +
                            CMND + "', '" + name + "', '" + age + "', '" + address + "', '" + phoneNumber + "', '" + MSPM + "');";
        }

        //Execute INSERT operation
        try {
            DBUtil.dbExecuteUpdate(insertStmt);
            System.out.println("---------Insert thanh cong-------------------------");
        } catch (SQLException e) {
            System.out.print("Xuat hien loi khi insert Customer : " + e);
            throw e;
        }
    }
    //delete book
    public static void deleteWithCustomerCMND(String CMND) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "DELETE FROM `customers` WHERE `customers`.`CMND` = '"+ CMND + "'";


        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
            System.out.println("---------Delete thanh cong-------------------------");
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }
    public static ObservableList<Customer> search_all_customer() throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM customers";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeList method and get employee object
            ObservableList<Customer> cusList = getCustomerList(rs);

            //Return employee object
            return cusList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //Select * from employees operation
    private static ObservableList<Customer> getCustomerList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Employee objects
        ObservableList<Customer> cusList = FXCollections.observableArrayList();

        while (rs.next()) {
            Customer cus = new Customer();
            cus.setCmnd(rs.getString("CMND"));
            cus.setName(rs.getString("Name"));
            cus.setPhoneNumber(rs.getString("PhoneNumber"));
            cus.setAge(rs.getInt("Age"));
            cus.setMSPM(rs.getString("MSPM"));
            cus.setAddress(rs.getString("Address"));
            //Add employee to the ObservableList
            cusList.add(cus);
        }
        //return empList (ObservableList of Employees)
        return cusList;
    }

    public static ObservableList<Customer> search_customer_by_CMND(String CMND) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM customer where CMND = " + "'" + CMND+ "'";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
            if(!rs.next()){
                System.out.println("not h");
            }
            rs.beforeFirst();

            //Send ResultSet to the getEmployeeList method and get employee object
            ObservableList<Customer> cusList = getCustomerList(rs);

            //Return employee object
            return cusList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }
}
