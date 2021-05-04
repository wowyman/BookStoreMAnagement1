package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.DB.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhieuNhapDB {


    public static void insertPhieunhap(String MSPN, String ngayNhap, String tongGiaTri, String maNCC, String MSNV) throws SQLException, ClassNotFoundException {

        String insertStmt =
                "INSERT INTO `phieunhap` (`MSPN`, `ngayNhap`, `tongGiaTri`, `maNCC`, `MSNV`) VALUES ('" +
                        MSPN + "', '" + ngayNhap + "', '" + tongGiaTri + "', '" + maNCC + "', '" + MSNV + ");";


        //Execute INSERT operation
        try {
            DBUtil.dbExecuteUpdate(insertStmt);
            System.out.println("---------Insert thanh cong-------------------------");
        } catch (SQLException e) {
            System.out.print("Xuat hien loi khi INSERT PN : " + e);
            throw e;
        }
    }

    //delete book
    public static void deleteWithMSPN(String MSPN) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "DELETE FROM `phieunhap` WHERE `phieunhap`.`MSPN` = '" + MSPN + "'";


        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
            System.out.println("---------Delete thanh cong-------------------------");
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

    public static PhieuNhap searchPN(String mspn) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM phieunhap WHERE MSPN=" + mspn;

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

            return getPNFromResultSet(rsEmp);
        } catch (SQLException e) {
            System.out.println("Xay ra loi khi tim kiem kho co MSPN : " + mspn + ". " + e);
            //Return exception
            throw e;
        }
    }

    private static PhieuNhap getPNFromResultSet(ResultSet rs) throws SQLException {
        PhieuNhap phieu = null;
        if (rs.next()) {
            phieu = new PhieuNhap();
            phieu.setMSPN(rs.getString("MSPN"));
            phieu.setNgayNhap(rs.getString("ngayNhap"));
            phieu.setTongGiaTri(rs.getInt("tongGiaTri"));
            phieu.setNcc(rs.getString("maNCC"));
            phieu.setE(rs.getString("MSNV"));

        }
        return phieu;
    }

    private static ObservableList<PhieuNhap> getPNList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<PhieuNhap> PNList = FXCollections.observableArrayList();
            PhieuNhap phieu = null;
        while (rs.next()) {
            phieu = new PhieuNhap();
            phieu.setMSPN(rs.getString("MSPN"));
            phieu.setNgayNhap(rs.getString("ngayNhap"));
            phieu.setTongGiaTri(rs.getInt("tongGiaTri"));
            phieu.setNcc(rs.getString("maNCC"));
            phieu.setE(rs.getString("MSNV"));
            PNList.add(phieu);
        }
        return PNList;
    }


    public static ObservableList<PhieuNhap> searchPN() throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM phieunhap";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmps = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeList method and get employee object

            //Return employee object
            return getPNList(rsEmps);
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }


    public static void updatePN(String MSPN, String ngayNhap, String tongGiaTri, String maNCC, String MSNV) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "UPDATE `phieunhap` SET `ngayNhap` = '" + ngayNhap +
                        "', `tongGiaTri` = '" + tongGiaTri +
                        "', `maNCC` = '" + maNCC +
                        "', `MSNV` = '" + MSNV +
                        "' WHERE `phieunhap`.`MSPN` = '" + MSPN + "'";


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
