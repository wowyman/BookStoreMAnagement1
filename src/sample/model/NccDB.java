package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.DB.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NccDB {



    public static void insertNCC(String maNCC, String name, String address, String phoneNumber, String email, String fax) throws SQLException, ClassNotFoundException {
        //mathedoc va mathemuon co the la Null
        String insertStmt;

        insertStmt =
                "INSERT INTO `ncc` (`maNCC`, `name`, `address`, `phoneNumber`, `email`,`fax`) VALUES ('" +
                        maNCC + "', '" + name + "', '" + address + "', '" + phoneNumber + "','" + email + "','" + fax + "');";


        //Execute INSERT operation
        try {
            DBUtil.dbExecuteUpdate(insertStmt);
            System.out.println("---------Insert thanh cong-------------------------");
        } catch (SQLException e) {
            System.out.print("Xuat hien loi khi INSERT ncc : " + e);
            throw e;
        }
    }

    //delete book
    public static void deleteWithmaNCC(String maNCC) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "DELETE FROM `ncc` WHERE `ncc`.`maNCC` = '" + maNCC + "'";

        try {
            DBUtil.dbExecuteUpdate(updateStmt);
            System.out.println("---------Delete thanh cong-------------------------");
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }

    }

    //update
    public static void updateNCC(String maNCC, String name, String address, String phoneNumber,String email,String fax) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "UPDATE `ncc` SET `name` = '" + name +
                        "', `address` = '" + address +
                        "', `phoneNumber` = '" + phoneNumber +
                        "', `email` = '" + email +
                        "', `fax` = '" + fax +
                        "' WHERE `ncc`.`maNCC` = '" + maNCC + "'";


        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
            System.out.println("---------Update thanh cong-------------------------");
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }

    public static ObservableList<NCC> search_all_ncc() throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM ncc";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeList method and get employee object
            ObservableList<NCC> nccList = getNCCList(rs);

            //Return employee object
            return nccList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //Select * from employees operation
    private static ObservableList<NCC> getNCCList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Employee objects
        ObservableList<NCC> nccList = FXCollections.observableArrayList();

        while (rs.next()) {
            NCC ncc = new NCC();
            ncc.setMaNCC(rs.getString("maNCC"));
            ncc.setName(rs.getString("name"));
            ncc.setPhoneNumber(rs.getString("phoneNumber"));
            ncc.setEmail(rs.getString("email"));
            ncc.setFax(rs.getString("fax"));
            ncc.setAddress(rs.getString("address"));
            //Add employee to the ObservableList
            nccList.add(ncc);
        }
        //return empList (ObservableList of Employees)
        return nccList;
    }

    //search
    public static ObservableList<NCC> search_ncc_by_maNCC(String maNCC) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM `ncc` where maNCC = " + "'" + maNCC + "'";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
            if (!rs.next()) {
                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa ");

            }
            rs.beforeFirst();


            return getNCCList(rs);
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }
}
