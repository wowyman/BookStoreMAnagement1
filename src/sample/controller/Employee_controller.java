package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Main;
import sample.model.*;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class Employee_controller {
    public static Main main;

    public static void setMain(Main main_) {
        main = main_;
    }

    @FXML
    private ComboBox ma_nv = new ComboBox();
    @FXML
    private TextField dien_thoai = new TextField();
    @FXML
    private TextField ten_nv = new TextField();
    @FXML
    private TextField dia_chi = new TextField();
    @FXML
    private ChoiceBox chuc_vu = new ChoiceBox();
    @FXML
    private DatePicker ngay_sinh = new DatePicker();
    @FXML
    private TextField luong = new TextField();
    @FXML
    private ChoiceBox noi_lam_viec = new ChoiceBox();
    @FXML
    private CheckBox nam = new CheckBox();
    @FXML
    private CheckBox nu = new CheckBox();



    @FXML
    private TableView<Employee> table = new TableView<Employee>();
    @FXML
    private TableColumn<Employee, String> manv= new TableColumn<>();
    @FXML
    private TableColumn<Employee, String> tennv = new TableColumn<>();
    @FXML
    private TableColumn<Employee, String> dienthoai = new TableColumn<>();
    @FXML
    private TableColumn<Employee, String> chucvu = new TableColumn<>();
    @FXML
    private TableColumn<Employee, String> ngaysinh = new TableColumn<>();
    @FXML
    private TableColumn<Employee, String> diachi = new TableColumn<>();
    @FXML
    private TableColumn<Employee, Integer> Luong = new TableColumn<>();
    @FXML
    private TableColumn<Employee, String> noilamviec = new TableColumn<>();



    @FXML
    void initialize() throws SQLException, ClassNotFoundException {

        ObservableList<Employee> EmpList = EmployeeDB.searchEmployees();
        ObservableList<String> options = FXCollections.observableArrayList();
        for (Employee emp : EmpList) {
            options.add(emp.getMSNV());
        }
        //
        ma_nv.setEditable(true);
        ma_nv.getItems().addAll(options);
        ma_nv.getEditor().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("ccccccccccccc");
            }
        });

        ObservableList<ChucVu> chucvuList = ChucvuDB.searchCV();
        ObservableList<String> options1 = FXCollections.observableArrayList();
        for (ChucVu cv : chucvuList) {
            options1.add(cv.getTenCV());
        }
        //
        chuc_vu.getItems().addAll(options1);


        ObservableList<Kho> khoList = KhoDB.searchKho();
        ObservableList<String> options3= FXCollections.observableArrayList();
        for (Kho emp : khoList) {
            options3.add(emp.getTenKho());
        }
        //

        noi_lam_viec.getItems().addAll(options3);


        manv.setCellValueFactory(c -> c.getValue().MSNVProperty());
        tennv.setCellValueFactory(c -> c.getValue().nameProperty());
        dienthoai.setCellValueFactory(c -> c.getValue().phoneNumberProperty());
        diachi.setCellValueFactory(c -> c.getValue().addressProperty());
        ngaysinh.setCellValueFactory(c -> c.getValue().ngaySinhProperty());
        Luong.setCellValueFactory(c -> c.getValue().salaryProperty().asObject());
        chucvu.setCellValueFactory(c -> c.getValue().getChucVu().tenCVProperty());
        noilamviec.setCellValueFactory(c -> c.getValue().getKho().tenKhoProperty());
    }


    @FXML
    void add_employee() throws SQLException,ClassNotFoundException {
        try {
            String manv_ = ma_nv.getEditor().getText();
            String name_ = ten_nv.getText();
            String address_ = dia_chi.getText();
            String phoneNumber_ = dien_thoai.getText();

            String pattern = "yyyy-MM-dd";
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
            String ngaysinh_ = ngay_sinh.getValue().format(dateFormatter);
            System.out.println(ngaysinh_);
            String chucvu_ = chuc_vu.getValue().toString();
            String luong_ = luong.getText();
            String noilamvc = noi_lam_viec.getValue().toString();
            String quequan_default = "Viet Nam";
            String gioitinh = "nam";

            if(nu.isSelected()) gioitinh = "nu";
            ma_nv.getItems().add(manv_);
            ma_nv.getItems().sort((o, o1) -> {
                String s1 = (String) o;
                String s2 = (String) o1;
                if(s1.compareTo(s2) < 0) return -1;
                else return 1;
            });
            EmployeeDB.insertEmployee(manv_,name_,gioitinh,ngaysinh_,address_,phoneNumber_,quequan_default,luong_,noilamvc);
            clearText();
        } catch (SQLException e){
            System.out.println(e);
            throw e;
        }
    }
    @FXML
    void delete_employee() throws SQLException, ClassNotFoundException {
        try {
            String manv_ = (String) ma_nv.getSelectionModel().getSelectedItem();
            int index = ma_nv.getSelectionModel().getSelectedIndex();
            ma_nv.getItems().remove(index);
            EmployeeDB.deleteWithEmployeeMSNV(manv_);
            clearText();

        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
    }

    @FXML
    void update_employee() throws SQLException, ClassNotFoundException {
        try {
            String manv_ = ma_nv.getEditor().getText();
            String name_ = ten_nv.getText();
            String address_ = dia_chi.getText();
            String phoneNumber_ = dien_thoai.getText();

            String pattern = "yyyy-MM-dd";
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
            String ngaysinh_ = ngay_sinh.getValue().format(dateFormatter);

            String chucvu_ = chuc_vu.getValue().toString();
            String luong_ = luong.getText();
            String noilamvc = noi_lam_viec.getValue().toString();
            String quequan_default = "Viet Nam";
            String gioitinh = "nam";

            if(nu.isSelected()) gioitinh = "nu";
            EmployeeDB.updateEmployee(manv_,name_,gioitinh,ngaysinh_,address_,phoneNumber_,quequan_default,luong_,manv_);
            clearText();
        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
    }

    @FXML
    void search_employee() throws SQLException,ClassNotFoundException {
        try {
            String msnv = (String) ma_nv.getSelectionModel().getSelectedItem();

            ObservableList<Employee> result = EmployeeDB.searchEmployee_byMSNV(msnv);

            table.setItems(result);

        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
    }

    void clearText() {
        ten_nv.setText("");
        dien_thoai.setText("");
        dia_chi.setText("");
        luong.setText("");
    }
    @FXML
    private Button xong = new Button();
    @FXML
    public void close() {
        Stage stage = (Stage) xong.getScene().getWindow();
        stage.close();
    }
}
