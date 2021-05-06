package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Main;
import sample.model.*;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class PhieunhapController {
    public static Main main;

    public static void setMain(Main main_) {
        main = main_;
    }

    @FXML
    private final ComboBox maNCC = new ComboBox();
    @FXML
    private final TextField MSPN = new TextField();
    @FXML
    private final DatePicker ngay_nhap = new DatePicker();
    @FXML
    private final ComboBox MSNV = new ComboBox();
    @FXML
    private final TextField tong_tien = new TextField();
    @FXML
    private final TextField tong_tien_bang_chu = new TextField();

    @FXML
    private final TableView<Book> table = new TableView<>();
    @FXML
    private final TableColumn<Book, String> masach = new TableColumn<>();
    @FXML
    private final TableColumn<Book, String> tacgia = new TableColumn<>();
    @FXML
    private final TableColumn<Book, String> tensach = new TableColumn<>();
    @FXML
    private final TableColumn<Book, String> theloai = new TableColumn<>();
    @FXML
    private final TableColumn<Book, String> gia = new TableColumn<>();
    @FXML
    private final TableColumn<Book, String> soluong = new TableColumn<>();




    @FXML
    void initialize() throws SQLException, ClassNotFoundException {

        ObservableList<NCC> EmpList = NccDB.search_all_ncc();
        ObservableList<String> options = FXCollections.observableArrayList();
        for (NCC emp : EmpList) {
            options.add(emp.getMaNCC());
        }
        //
        maNCC.setEditable(true);
        maNCC.getItems().addAll(options);


        ObservableList<Employee> chucvuList = EmployeeDB.searchEmployees();
        ObservableList<String> options1 = FXCollections.observableArrayList();
        for (Employee cv : chucvuList) {
            options1.add(cv.getMSNV());
        }
        //
        MSNV.getItems().addAll(options1);





        masach.setCellValueFactory(c -> c.getValue().bookIdProperty());
        tacgia.setCellValueFactory(c -> c.getValue().authorProperty());
        tensach.setCellValueFactory(c -> c.getValue().bookTitleProperty());
        soluong.setCellValueFactory(c -> c.getValue().soLuongProperty().asString());
        gia.setCellValueFactory(c -> c.getValue().priceProperty().asString());

        theloai.setCellValueFactory(c -> c.getValue().theLoaiProperty());

    }


    @FXML
    void add_PN() throws SQLException,ClassNotFoundException {
        try {
            String ms = MSPN.getText();
            String maNCC_ = maNCC.getEditor().getText();
            String maNV_ = MSNV.getEditor().getText();
            String tien = tong_tien.getText();

            String pattern = "yyyy-MM-dd";
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
            String ngayNhapp = ngay_nhap.getValue().format(dateFormatter);


            PhieuNhapDB.insertPhieunhap(ms,ngayNhapp,tien,maNCC_,maNV_);
            clearText();
        } catch (SQLException e){
            System.out.println(e);
            throw e;
        }
    }
    @FXML
    void delete_PN() throws SQLException, ClassNotFoundException {
        try {
            String ms = MSPN.getText();
            PhieuNhapDB.deleteWithMSPN(ms);
            clearText();

        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
    }

    @FXML
    void update_PN() throws SQLException, ClassNotFoundException {
        try {
            String ms = MSPN.getText();
            String maNCC_ = maNCC.getEditor().getText();
            String maNV_ = MSNV.getEditor().getText();
            String tien = tong_tien.getText();

            String pattern = "yyyy-MM-dd";
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
            String ngayNhapp = ngay_nhap.getValue().format(dateFormatter);
            PhieuNhapDB.updatePN(ms,ngayNhapp,tien,maNCC_,maNV_);
            clearText();
        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
    }

    @FXML
    void search_PN() throws SQLException,ClassNotFoundException {
        try {
            String ms = MSPN.getText();

            ObservableList<Book> result = BookDB.search_by_bookID(ms);

            table.setItems(result);

        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
    }

    void clearText() {

    }
    @FXML
    private final Button xong = new Button();
    @FXML
    public void close() {
        Stage stage = (Stage) xong.getScene().getWindow();
        stage.close();
    }
}
