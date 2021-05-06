package sample.controller;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Main;
import sample.model.Employee;
import sample.model.EmployeeDB;

import java.sql.SQLException;

public class searchemployee {

    public static Main main;

    public static void setMain(Main main_) {
        main = main_;
    }
    @FXML
    TextField tennhanvien;
    @FXML
    TextField noilamviec;

    @FXML
    private final TableView<Employee> table = new TableView<Employee>();
    @FXML
    TableColumn<Employee, String> msnv_col;
    @FXML
    TableColumn<Employee, String> name_col;
    @FXML
    TableColumn<Employee, String> gioitinh_col;
    @FXML
    TableColumn<Employee, String> dienthoai_col;
    @FXML
    TableColumn<Employee, String> diachi_col;
    @FXML
    TableColumn<Employee, String> ngaysinh_col;
    @FXML
    TableColumn<Employee, String> noilamviec_col;
    @FXML
    TableColumn<Employee, String> chucvu_col;

    @FXML
    TableColumn<Employee, String> luong_col;


    @FXML
    void initialize() throws SQLException, ClassNotFoundException {

        msnv_col.setCellValueFactory(c -> c.getValue().MSNVProperty());
        name_col.setCellValueFactory(c -> c.getValue().nameProperty());
        gioitinh_col.setCellValueFactory(c -> c.getValue().gioiTinhProperty());
        dienthoai_col.setCellValueFactory(c -> c.getValue().phoneNumberProperty());
        diachi_col.setCellValueFactory(c -> c.getValue().addressProperty());
        ngaysinh_col.setCellValueFactory(c -> c.getValue().ngaySinhProperty());
        noilamviec_col.setCellValueFactory(c -> c.getValue().getKho().tenKhoProperty());
        chucvu_col.setCellValueFactory(c -> c.getValue().getChucVu().tenCVProperty());
        luong_col.setCellValueFactory(c -> c.getValue().salaryProperty().asString());
    }


    @FXML
    void search() throws SQLException, ClassNotFoundException {
        String ten = tennhanvien.getText();
        String noi = noilamviec.getText();
        ObservableList<Employee> e = EmployeeDB.searchEmployee(ten,noi);
        table.setItems(e);


    }

    @FXML
    private final Button xong = new Button();
    @FXML
    public void close() {
        Stage stage = (Stage) xong.getScene().getWindow();
        stage.close();
    }

}
