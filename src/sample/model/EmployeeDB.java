package sample.model;

import sample.DB.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDB {
//


    public static void insertEmployee(String MSNV, String name, String gioiTinh, String ngaySinh, String address, String phoneNumber, String queQuan, String salary,String makho) throws SQLException, ClassNotFoundException {

        String insertStmt =
                "INSERT INTO `employee` (`MSNV`, `name`, `gioiTinh`, `ngaySinh`, `address`, `phoneNumber`,`queQuan`,`salary`,`maKho`,`MSCV`) VALUES ('" +
                        MSNV + "', '" + name + "', '" + gioiTinh + "', '" + ngaySinh + "', '" + address + "', '" + phoneNumber + "', '" + queQuan + "', '" + salary + "', '"+ makho + "', NULL);";


        //Execute INSERT operation
        try {
            DBUtil.dbExecuteUpdate(insertStmt);
            System.out.println("---------Insert thanh cong-------------------------");
        } catch (SQLException e) {
            System.out.print("Xuat hien loi khi insert NV : " + e);
            throw e;
        }
    }

    //delete book
    public static void deleteWithEmployeeMSNV(String MSNV) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "DELETE FROM `employee` WHERE `employee`.`MSNV` = '" + MSNV + "'";


        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
            System.out.println("---------Delete thanh cong-------------------------");
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

    public static ObservableList<Employee> searchEmployee_byMSNV(String MSNV) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM employee WHERE MSNV=" + MSNV;

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
            if (!rs.next()) {
                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa ");

            }
            rs.beforeFirst();


            return getEmployeeList(rs);
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    private static Employee getEmployeeFromResultSet(ResultSet rs) throws SQLException {
        Employee emp = null;
        if (rs.next()) {
            emp = new Employee();
            emp.setMSNV(rs.getString("MSNV"));
            emp.setName(rs.getString("name"));
            emp.setGioiTinh(rs.getString("gioiTinh"));
            emp.setAddress(rs.getString("address"));
            emp.setPhoneNumber(rs.getString("phoneNumber"));
            emp.setQueQuan(rs.getString("queQuan"));
            emp.setNgaySinh(rs.getString("ngaySinh"));
            emp.setSalary(rs.getInt("salary"));
            emp.setKho(rs.getString("maKho"));
        }
        return emp;
    }

    private static ObservableList<Employee> getEmployeeList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Employee objects
        ObservableList<Employee> empList = FXCollections.observableArrayList();

        while (rs.next()) {
            Employee emp = new Employee();
            emp.setMSNV(rs.getString("MSNV"));
            emp.setName(rs.getString("name"));
            emp.setGioiTinh(rs.getString("gioiTinh"));
            emp.setAddress(rs.getString("address"));
            emp.setPhoneNumber(rs.getString("phoneNumber"));
            emp.setQueQuan(rs.getString("queQuan"));
            emp.setNgaySinh(rs.getString("ngaySinh"));
            emp.setSalary(rs.getInt("salary"));
            emp.setKho(rs.getString("maKho"));
            //Add employee to the ObservableList
            empList.add(emp);
        }
        //return empList (ObservableList of Employees)
        return empList;
    }


    public static ObservableList<Employee> searchEmployees() throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM employee";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmps = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeList method and get employee object
            ObservableList<Employee> empList = getEmployeeList(rsEmps);

            //Return employee object
            return empList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    public static void updateSalary(String MSNV, String salary) throws SQLException, ClassNotFoundException {
        //Declare a UPDATE statement
        String updateStmt =
                "UPDATE `employee` SET `salary` = '" + salary + "' WHERE `employee`.`MSNV` = '" + MSNV + "'";

        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
            System.out.println("Update salary thanh cong");
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }

    public static void updateEmployee(String manv, String name, String gioitinh,String ngaySinh,String address, String phoneNumber,String queQuan,String luong,String makho) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "UPDATE `employee` SET `name` = '" + name +
                        "', `gioiTinh` = '" + gioitinh +
                        "', `ngaySinh` = '" + ngaySinh +
                        "', `address` = '" + address +
                        "', `phoneNumber` = '" + ngaySinh +
                        "', `queQuan` = '" + queQuan +
                        "', `salary` = '" + luong +
                        "', `maKho` = '" + makho +
                        "' WHERE `employee`.`MSNV` = '" + manv + "'";


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
