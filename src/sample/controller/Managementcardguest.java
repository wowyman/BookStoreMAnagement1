package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Main;
import sample.model.Customer;
import sample.model.CustomerDB;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Managementcardguest {
    public static Main main;

    public static void setMain(Main main_) {
        main = main_;
    }
    @FXML
    TextField mathe;
    @FXML
    ComboBox<String> loaithe;
    @FXML
    ComboBox<String> makhach;
    @FXML
    DatePicker ngaycap;
    @FXML
    Button them,sua,xoa,luu,chapnhan,huy;
    String mt;
    public void them_But(ActionEvent event) throws SQLException, ClassNotFoundException {
        try {
            AnchorPane root1 = FXMLLoader.load(getClass().getResource("/src/sample/view/Menu.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Menu");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void xoa_but(ActionEvent event) {
        try {
            AnchorPane root1 = FXMLLoader.load(getClass().getResource("/src/sample/view/Menu.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Menu");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void sua_but(ActionEvent event) {
        try {
            AnchorPane root1 = FXMLLoader.load(getClass().getResource("/src/sample/view/Menu.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Menu");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void luu_but(ActionEvent event) {
        try {
            AnchorPane root1 = FXMLLoader.load(getClass().getResource("/src/sample/view/Menu.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Menu");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void chapnhan_but(ActionEvent event) {
        try {
            AnchorPane root1 = FXMLLoader.load(getClass().getResource("/src/sample/view/Menu.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Menu");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void huy_but(ActionEvent event) {
        try {
            AnchorPane root1 = FXMLLoader.load(getClass().getResource("/src/sample/view/Menu.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Menu");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void handle_makhach() throws SQLException, ClassNotFoundException {
        ObservableList<Customer> customers = CustomerDB.search_all_customer();
        ArrayList<String> list_cusmk = new ArrayList<>();
        for (Customer customer:customers){
            list_cusmk.add(customer.getCmnd());
        }
        ObservableList<String>listmk = FXCollections.observableArrayList(list_cusmk);
        System.out.println(list_cusmk.size());
        makhach.setItems(listmk);
        System.out.println(CustomerDB.search_customer_by_CMND(makhach.getValue()).size());
    }

    public void handle_loaithe() {
        ObservableList<String> list_loaithe = FXCollections.observableArrayList("the muon","the doc");
        loaithe.setItems(list_loaithe);
    }

    public void handle_ngaycap() throws SQLException, ClassNotFoundException {
        if (loaithe.getValue().equals("the doc")){
            String ngayCapThe = CustomerDB.search_customer_by_CMND(makhach.getValue()).get(0).getThedoc().getNgayCapThe();
            String mathe_find = CustomerDB.search_customer_by_CMND(makhach.getValue()).get(0).getThedoc().getCardNumber();
            mathe.setText(mathe_find);
        }
        else {
            String ngayCapThe = CustomerDB.search_customer_by_CMND(makhach.getValue()).get(0).getThemuon().getNgayCapThe();
            String mathe_find = CustomerDB.search_customer_by_CMND(makhach.getValue()).get(0).getThemuon().getCardNumber();
            mathe.setText(mathe_find);
        }
        LocalDate localDate =LocalDate.of(2021,05,04);
        ngaycap.setValue(localDate);
    }
    public void handle() throws SQLException, ClassNotFoundException {
        mt = mathe.getText();
    }
}
