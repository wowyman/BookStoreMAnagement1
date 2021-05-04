package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import sample.model.Card;
import sample.model.Customer;
import sample.model.CustomerDB;

import java.sql.SQLException;
import java.util.ArrayList;

public class Managementcardguest {
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
    public void handle() throws SQLException, ClassNotFoundException {
        mt = mathe.getText();
        ObservableList<Customer> customers = CustomerDB.search_all_customer();
        ArrayList<String> list_cusmk = new ArrayList<>();
        for (Customer customer:customers){
            list_cusmk.add(customer.getCmnd());
        }
        ObservableList<String>listmk = FXCollections.observableArrayList(list_cusmk);
        System.out.println(list_cusmk.size());
        makhach.setItems(listmk);
        ObservableList<String> list_loaithe = FXCollections.observableArrayList("the muon","the doc");
        loaithe.setItems(list_loaithe);
    }

    public void them_But(ActionEvent event) {
    }

    public void xoa_but(ActionEvent event) {
    }

    public void sua_but(ActionEvent event) {
    }

    public void luu_but(ActionEvent event) {
    }

    public void chapnhan_but(ActionEvent event) {
    }

    public void huy_but(ActionEvent event) {
    }
}
