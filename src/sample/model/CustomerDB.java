package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.DB.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDB {
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//
//
//    }


    public static void insertCustomer(String CMND, String name, String age, String address, String phoneNumber,String mathedoc_,String mathemuon_) throws SQLException, ClassNotFoundException {
        //mathedoc va mathemuon co the la Null
        String insertStmt;
        String mathedoc = " '" + mathedoc_ +"'";
        String mathemuon =" '" + mathemuon_ +"'";
        if(mathedoc_.equals("")) mathedoc = "NULL";
        if(mathemuon_.equals("")) mathemuon = "NULL";

        insertStmt =
                "INSERT INTO `customers` (`CMND`, `Name`, `Age`, `Address`, `PhoneNumber`, `MSPM`,`mathedoc`,`mathemuon`) VALUES ('" +
                        CMND + "', '" + name + "', '" + age + "', '" + address + "', '" + phoneNumber + "', NULL," + mathedoc + ", "+ mathemuon + ");";


        //Execute INSERT operation
        try {
            DBUtil.dbExecuteUpdate(insertStmt);
            System.out.println("---------Insert thanh cong-------------------------");
        } catch (SQLException e) {
            System.out.print("Xuat hien loi khi INSERT Customer : " + e);
            throw e;
        }
    }

    //delete book
    public static void deleteWithCustomerCMND(String CMND) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "DELETE FROM `customers` WHERE `customers`.`CMND` = '" + CMND + "'";

        try {
            DBUtil.dbExecuteUpdate(updateStmt);
            System.out.println("---------Delete thanh cong-------------------------");
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

    //update
    public static void updateCustomer(String CMND, String name, String address, String phoneNumber) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "UPDATE `customers` SET `Name` = '" + name +
                        "', `Address` = '" + address +
                        "', `PhoneNumber` = '" + phoneNumber +
                        "' WHERE `customers`.`CMND` = '" + CMND + "'";


        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
            System.out.println("---------Update thanh cong-------------------------");
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
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
            cus.setmaThedoc(rs.getString("mathedoc"));
            cus.setmaThemuon(rs.getString("mathemuon"));
            //Add employee to the ObservableList
            cusList.add(cus);
        }
        //return empList (ObservableList of Employees)
        return cusList;
    }
    //search
    public static ObservableList<Customer> search_customer_by_CMND(String CMND) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM customers where CMND = " + "'" + CMND + "'";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
            if (!rs.next()) {
                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa ");

            }
            rs.beforeFirst();


            return getCustomerList(rs);
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }
}
