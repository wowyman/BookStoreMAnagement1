package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Main;
import sample.model.*;

import java.sql.SQLException;

public class User_controller {
    public static Main main;

    public static void setMain(Main main_) {
        main = main_;
    }

    @FXML
    private ComboBox quyen_su_dung = new ComboBox();
    @FXML
    private ComboBox chuc_vu = new ComboBox();
    @FXML
    private ComboBox ten_nguoi_dung = new ComboBox();
    @FXML
    private TextField ten_dang_nhap = new TextField();
    @FXML
    private PasswordField mat_khau = new PasswordField();
    @FXML
    private PasswordField xac_nhan_mat_khau = new PasswordField();


    @FXML
    void initialize() throws SQLException, ClassNotFoundException {


        ObservableList<String> options = FXCollections.observableArrayList();
        options.addAll("admin", "nhân viên");
        //
        quyen_su_dung.setEditable(true);
        quyen_su_dung.getItems().addAll(options);


        ObservableList<ChucVu> chucvuList = ChucvuDB.searchCV();
        ObservableList<String> options1 = FXCollections.observableArrayList();
        for (ChucVu cv : chucvuList) {
            options1.add(cv.getTenCV());
        }
        //
        chuc_vu.getItems().addAll(options1);


        ObservableList<Employee> empList = EmployeeDB.searchEmployees();
        ObservableList<String> options3 = FXCollections.observableArrayList();
        for (Employee emp : empList) {
            options3.add(emp.getName());
        }
        //

        ten_nguoi_dung.getItems().addAll(options3);

    }


    @FXML
    void add_user() throws SQLException, ClassNotFoundException {
        try {
            String tennguoidung = ten_nguoi_dung.getEditor().getText();
            String username = ten_dang_nhap.getText();
            String password = mat_khau.getText();
            String confirm_password = xac_nhan_mat_khau.getText();
            String chucvu = chuc_vu.getEditor().getText();
            String quyensudung = quyen_su_dung.getEditor().getText();

            if (!confirm_password.equals(password))
                warning();
            else
                UserDB.insertUser(quyensudung, username, password, chucvu, tennguoidung);

            clearText();
        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
    }

    @FXML
    void delete_user() throws SQLException, ClassNotFoundException {
        try {
            String username = ten_dang_nhap.getText();
            clearText();
            UserDB.deleteUser(username);
        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
    }

    @FXML
    void update_user() throws SQLException, ClassNotFoundException {
        try {
            String tennguoidung = ten_nguoi_dung.getEditor().getText();
            String username = ten_dang_nhap.getText();
            String password = mat_khau.getText();
            String confirm_password = xac_nhan_mat_khau.getText();
            String chucvu = chuc_vu.getEditor().getText();
            String quyensudung = quyen_su_dung.getEditor().getText();


            if (!confirm_password.equals(password))
                warning();
            else
                UserDB.updateUser(quyensudung, username, password, chucvu, tennguoidung);
            clearText();
        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
    }

    void warning() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setContentText("Mật khẩu xác nhận không đúng. VUi lòng nhập lại.");
        alert.show();


    }

    void clearText() {
        ten_dang_nhap.setText("");
        mat_khau.setText("");
        xac_nhan_mat_khau.setText("");
    }

    @FXML
    private Button xong = new Button();

    @FXML
    public void close() {
        Stage stage = (Stage) xong.getScene().getWindow();
        stage.close();
    }
}
