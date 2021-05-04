package sample.model;

import sample.DB.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChucvuDB {



    public static void insertChucvu(String MSCV,String tenCV) throws SQLException, ClassNotFoundException {

        String insertStmt =
                "INSERT INTO `chucvu` (`MSCV`, `tenCV`) VALUES ('" +
                        MSCV + "', '" + tenCV + "');";


        //Execute INSERT operation
        try {
            DBUtil.dbExecuteUpdate(insertStmt);
            System.out.println("---------Insert thanh cong-------------------------");
        } catch (SQLException e) {
            System.out.print("Xuat hien loi khi INSERT CV : " + e);
            throw e;
        }
    }

    //delete book
    public static void deleteWithMSCV(String MSCV) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "DELETE FROM `chucvu` WHERE `chucvu`.`MSCV` = '" + MSCV + "'";


        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
            System.out.println("---------Delete thanh cong-------------------------");
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

    public static ChucVu searchCV(String MSCV) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM chucvu WHERE MSCV=" + MSCV;

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

            ChucVu cv = getCVFromResultSet(rsEmp);

            return cv;
        } catch (SQLException e) {
            System.out.println("Xay ra loi khi tim kiem chuc vu co MSCV : " + MSCV + ". " + e);
            //Return exception
            throw e;
        }
    }

    private static ChucVu getCVFromResultSet(ResultSet rs) throws SQLException {
        ChucVu cv = null;
        if (rs.next()) {
            cv = new ChucVu();
            cv.setMSCV(rs.getString("MSCV"));
            cv.setTenCV(rs.getString("tenCV"));

        }
        return cv;
    }

    private static ObservableList<ChucVu> getCVList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Employee objects
        ObservableList<ChucVu> CVList = FXCollections.observableArrayList();

        while (rs.next()) {
            ChucVu cv = new ChucVu();
            cv.setMSCV(rs.getString("MSCV"));
            cv.setTenCV(rs.getString("tenCV"));
            CVList.add(cv);
        }
        return CVList;
    }


    public static ObservableList<ChucVu> searchCV() throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM chucvu";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmps = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeList method and get employee object
            ObservableList<ChucVu> CVList = getCVList(rsEmps);

            //Return employee object
            return CVList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }



    public static void updateCV(String MSCV,String tenCV) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "UPDATE `chucvu` SET `tenCV` = '" + tenCV +

                        "' WHERE `chucvu`.`MSCV` = '" + MSCV + "'";


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
