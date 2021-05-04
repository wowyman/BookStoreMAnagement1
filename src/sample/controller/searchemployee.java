package sample.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.model.Employee;
import sample.model.EmployeeDB;
import java.sql.SQLException;

public class searchemployee {
    @FXML
    TextField tennhanvien;
    @FXML
    TextField noilamviec;
    @FXML
    TableView<Employee> employeeTableView ;
    String tnv;
    String nlv;
    @FXML
    TableColumn<Employee, Integer> msnv_col;
    @FXML
    TableColumn<Employee, String> name_col;
    @FXML
    TableColumn<Employee, String> gioitinh_col;
    @FXML
    TableColumn<Employee, Integer> dienthoai_col;
    @FXML
    TableColumn<Employee, String> diachi_col;
    @FXML
    TableColumn<Employee, String> ngaysinh_col;
    @FXML
    TableColumn<Employee, String> noilamviec_col;
    @FXML
    TableColumn<Employee, String> chucvu_col;
    @FXML
    TableColumn<Employee, String> email_col;
    @FXML
    TableColumn<Employee, Integer> luong_col;
    ObservableList<Employee> true_list1 = FXCollections.observableArrayList();
    ObservableList<Employee> true_list2 = FXCollections.observableArrayList();
    @FXML
    public void handle_tnv() throws SQLException, ClassNotFoundException {
        ObservableList<Employee> listView = EmployeeDB.searchEmployees();
        tnv = tennhanvien.getText();
        System.out.println(listView.get(0).getName());
        System.out.println(listView.size());

        msnv_col.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("MSNV"));
        name_col.setCellValueFactory(new PropertyValueFactory<Employee,String>("name"));
        dienthoai_col.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("phoneNumber"));
        diachi_col.setCellValueFactory(new PropertyValueFactory<Employee,String>("address"));
        //chucvu_col.setCellValueFactory(new PropertyValueFactory<Employee,String>("Chức vụ"));
        ngaysinh_col.setCellValueFactory(new PropertyValueFactory<Employee,String>("ngaySinh"));
        noilamviec_col.setCellValueFactory(new PropertyValueFactory<Employee,String>("queQuan"));
        gioitinh_col.setCellValueFactory(new PropertyValueFactory<Employee,String>("gioiTinh"));
        //email_col.setCellValueFactory(new PropertyValueFactory<Employee,String>("Email"));
        luong_col.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("salary"));
        for (Employee employee : listView) {
            if (tnv.equals(employee.getName())) {
                true_list1.add(employee);
                System.out.println("ss");
                employeeTableView.setItems(true_list1);
            }
        }

    }
    @FXML
    public void handle_nlv() {
        nlv = noilamviec.getText();
        for (Employee employee : true_list1) {
            if (nlv.equals(employee.getQueQuan())) {
                true_list2.add(employee);
                System.out.println("ss");
                employeeTableView.getItems().clear();
                employeeTableView.setItems(true_list2);
            }
        }
    }
    @FXML
    Button thoat,nhapmoi,chon;
    public void thoat_button(){
        try {
            AnchorPane root1 = FXMLLoader.load(getClass().getResource("/src/sample/view/Menu.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Menu ");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void nhapmoi_button(){
        try {
            AnchorPane root1 = FXMLLoader.load(getClass().getResource("/src/sample/view/Employee.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("thong tin nhan vien ");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
