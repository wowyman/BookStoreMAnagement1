package sample.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Main;
import sample.model.Customer;
import sample.model.CustomerDB;

import java.sql.SQLException;

public class searchguest {

    public static Main main;

    public static void setMain(Main main_) {
        main = main_;
    }
    @FXML
    TextField tenkhach;
    @FXML
    TableView<Customer> customerTableView ;
    String tk;
    @FXML
    TableColumn<Customer, Integer> ms_col;
    @FXML
    TableColumn<Customer, String> name_col;
    @FXML
    TableColumn<Customer, Integer> dienthoai_col;
    @FXML
    TableColumn<Customer,String> diachi_col;
    @FXML
    TableColumn<Customer, String> mtd_col = new TableColumn<Customer, String>();
    @FXML
    TableColumn<Customer, String> mtm_col = new TableColumn<>();
    ObservableList<Customer> true_list1 = FXCollections.observableArrayList();
    ObservableList<Customer> true_list2 = FXCollections.observableArrayList();
    @FXML
    public void initialize() throws SQLException, ClassNotFoundException {
        ObservableList<Customer> listView = CustomerDB.search_all_customer();
        tk = tenkhach.getText();
        System.out.println(listView.get(3).getThedoc().getCardNumber());
        System.out.println(listView.size());
        ms_col.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("cmnd"));
        name_col.setCellValueFactory(new PropertyValueFactory<Customer,String>("name"));
        dienthoai_col.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("phoneNumber"));
        diachi_col.setCellValueFactory(new PropertyValueFactory<Customer,String>("address"));
        mtd_col.setCellValueFactory(data->new SimpleStringProperty(data.getValue().getThedoc().getCardNumber()));
        mtm_col.setCellValueFactory(data->new SimpleStringProperty(data.getValue().getThemuon().getCardNumber()));
        for (Customer customer : listView) {
            if (tk.equals(customer.getName())) {
                true_list1.add(customer);
                System.out.println("ss");
                customerTableView.setItems(true_list1);
                System.out.println(customer.getThedoc().getCardNumber());
                System.out.println(mtd_col.getCellValueFactory());
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
            AnchorPane root1 = FXMLLoader.load(getClass().getResource("/src/sample/view/Guest_information.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("thong tin khach hang ");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
