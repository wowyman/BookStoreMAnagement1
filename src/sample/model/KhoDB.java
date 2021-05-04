package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.DB.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KhoDB {


    public static void insertKho(String maKho, String tenKho, String theLoai) throws SQLException, ClassNotFoundException {

        String insertStmt =
                "INSERT INTO `kho` (`maKho`, `tenKho`,`theLoai`,`MSPX`) VALUES ('" +
                        maKho + "', '" + tenKho + "', '" + theLoai + "', NULL);";


        //Execute INSERT operation
        try {
            DBUtil.dbExecuteUpdate(insertStmt);
            System.out.println("---------Insert thanh cong-------------------------");
        } catch (SQLException e) {
            System.out.print("Xuat hien loi khi INSERT kho : " + e);
            throw e;
        }
    }

    //delete book
    public static void deleteWithmaKho(String maKho) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "DELETE FROM `kho` WHERE `kho`.`maKho` = '" + maKho + "'";


        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
            System.out.println("---------Delete thanh cong-------------------------");
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

    public static Kho searchKho(String maKho) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM kho WHERE maKho=" + maKho;

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

            return getKhoFromResultSet(rsEmp);
        } catch (SQLException e) {
            System.out.println("Xay ra loi khi tim kiem kho co maKho : " + maKho + ". " + e);
            //Return exception
            throw e;
        }
    }

    private static Kho getKhoFromResultSet(ResultSet rs) throws SQLException {
        Kho kho = null;
        if (rs.next()) {
            kho = new Kho();
            kho.setMaKho(rs.getString("maKho"));
            kho.setTenKho(rs.getString("tenKho"));
            kho.setTheLoai(rs.getString("theLoai"));

        }
        return kho;
    }

    private static ObservableList<Kho> getCVList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<Kho> KhoList = FXCollections.observableArrayList();

        while (rs.next()) {
            Kho kho = new Kho();
            kho.setMaKho(rs.getString("maKho"));
            kho.setTenKho(rs.getString("tenKho"));
            kho.setTheLoai(rs.getString("theLoai"));
            KhoList.add(kho);
        }
        return KhoList;
    }


    public static ObservableList<Kho> searchKho() throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM kho";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmps = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeList method and get employee object

            //Return employee object
            return getCVList(rsEmps);
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }


    public static void updateKho(String maKho, String tenKho,String theLoai) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "UPDATE `kho` SET `tenKho` = '" + tenKho +
                        "', `theLoai` = '" + theLoai +
                        "' WHERE `kho`.`maKho` = '" + maKho + "'";


        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
            System.out.println("---------Update thanh cong-------------------------");
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }

}
