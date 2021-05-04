package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.DB.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDB {
//


    public static void insertUser(String quyensudung, String tendangnhap, String matkhau, String tenCV, String tennguoidung) throws SQLException, ClassNotFoundException {
        System.out.println("-----------------cccc     " + tenCV + "   cccc--------------------");
        String insertStmt =
                "INSERT INTO `user` (`quyensudung`, `tendangnhap`, `matkhau`, `tenCV`, `name`) VALUES ('" + quyensudung + "', '" + tendangnhap + "', '"+
                    matkhau +"', '" + tenCV + "', '" + tennguoidung + "');";

        //Execute INSERT operation
        try {
            DBUtil.dbExecuteUpdate(insertStmt);
            System.out.println("---------Insert thanh cong-------------------------");
        } catch (SQLException e) {
            System.out.print("Xuat hien loi khi insert user : " + e);
            throw e;
        }
    }

    //delete book
    public static void deleteUser(String tendangnhap) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "DELETE FROM `user` WHERE `user`.`tendangnhap` = '" + tendangnhap + "'";


        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
            System.out.println("---------Delete thanh cong-------------------------");
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }



    public static void updateUser(String quyensudung, String tendangnhap, String matkhau, String tenCV, String tennguoidung) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "UPDATE `user` SET `matkhau` = '" + matkhau +
                        "', `quyensudung` = '" + quyensudung +
                        "', `tenCV` = '" + tenCV +
                        "' WHERE `user`.`tendangnhap` = '" + tendangnhap + "' ";


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
