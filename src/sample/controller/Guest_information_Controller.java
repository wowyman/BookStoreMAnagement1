package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Main;
import sample.model.Customer;
import sample.model.CustomerDB;

import java.sql.SQLException;

public class Guest_information_Controller {
    public static Main main;

    public static void setMain(Main main_) {
        main = main_;
    }

    @FXML
    private  ComboBox ma_khach = new ComboBox();
    @FXML
    private  TextField dien_thoai = new TextField();
    @FXML
    private  TextField ma_the_doc = new TextField();
    @FXML
    private  TextField ten_khach = new TextField();
    @FXML
    private  TextField dia_chi = new TextField();
    @FXML
    private  TextField ma_the_muon = new TextField();



    @FXML
    private  TableView<Customer> table = new TableView<Customer>();
    @FXML
    private  TableColumn<Customer, String> makhach = new TableColumn<>();
    @FXML
    private  TableColumn<Customer, String> tenkhach = new TableColumn<>();
    @FXML
    private  TableColumn<Customer, String> dienthoai = new TableColumn<>();
    @FXML
    private  TableColumn<Customer, String> diachi = new TableColumn<>();
    @FXML
    private  TableColumn<Customer, String> maTD = new TableColumn<>();
    @FXML
    private  TableColumn<Customer, String> maTM = new TableColumn<>();



    @FXML
    void initialize() throws SQLException, ClassNotFoundException {

        ObservableList<Customer> cusList = CustomerDB.search_all_customer();
        ObservableList<String> options = FXCollections.observableArrayList();
        for (Customer customer : cusList) {
            options.add(customer.getCmnd());
        }
        //
        ma_khach.setEditable(true);
        ma_khach.getItems().addAll(options);
        ma_khach.getEditor().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("ccccccccccccc");
            }
        });
        makhach.setCellValueFactory(c -> c.getValue().cmndProperty());
        tenkhach.setCellValueFactory(c -> c.getValue().nameProperty());
        dienthoai.setCellValueFactory(c -> c.getValue().phoneNumberProperty());
        diachi.setCellValueFactory(c -> c.getValue().addressProperty());
        maTD.setCellValueFactory(c -> c.getValue().getThedoc().cardNumberProperty());
        maTM.setCellValueFactory(c -> c.getValue().getThemuon().cardNumberProperty());
    }


    @FXML
    void add_customer() throws SQLException,ClassNotFoundException {
        try {
            String CMND = ma_khach.getEditor().getText();
            String name = ten_khach.getText();
            String default_age = "20";
            String address = dia_chi.getText();
            String phoneNumber = dien_thoai.getText();
            String mathedoc = ma_the_doc.getText();
            String mathemuon = ma_the_muon.getText();
            ma_khach.getItems().add(CMND);
            ma_khach.getItems().sort((o, o1) -> {
                String s1 = (String) o;
                String s2 = (String) o1;
                if(s1.compareTo(s2) < 0) return -1;
                else return 1;
            });
            CustomerDB.insertCustomer(CMND,name,default_age,address,phoneNumber,mathedoc,mathemuon);
            clearText();
        } catch (SQLException e){
            System.out.println(e);
            throw e;
        }
    }
    @FXML
    void delete_customer() throws SQLException, ClassNotFoundException {
        try {
            String CMND = (String) ma_khach.getSelectionModel().getSelectedItem();
            int index = ma_khach.getSelectionModel().getSelectedIndex();
            //System.out.println(CMND);
            ma_khach.getItems().remove(index);
            CustomerDB.deleteWithCustomerCMND(CMND);


        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
    }

    @FXML
    void update_customer() throws SQLException, ClassNotFoundException {
        try {
            String CMND = (String) ma_khach.getSelectionModel().getSelectedItem();
            String name = ten_khach.getText();
            String address = dia_chi.getText();
            String phoneNumber = dien_thoai.getText();
            CustomerDB.updateCustomer(CMND, name, address, phoneNumber);
            clearText();
        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
    }
    @FXML
    void search_customer() throws SQLException,ClassNotFoundException {
        try {
            String CMND = (String) ma_khach.getSelectionModel().getSelectedItem();

            ObservableList<Customer> result = CustomerDB.search_customer_by_CMND(CMND);

            table.setItems(result);

        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
    }

    void clearText() {
        ten_khach.setText("");
        dien_thoai.setText("");
        dia_chi.setText("");
        ma_the_doc.setText("");
        ma_the_muon.setText("");

    }
    @FXML
    private final Button xong = new Button();
    @FXML
    public void close() {
        Stage stage = (Stage) xong.getScene().getWindow();
        stage.close();
    }
}
