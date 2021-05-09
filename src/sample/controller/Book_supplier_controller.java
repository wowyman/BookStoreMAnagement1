package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Main;
import sample.model.NCC;
import sample.model.NccDB;

import java.sql.SQLException;

public class Book_supplier_controller {
    public static Main main;

    public static void setMain(Main main_) {
        main = main_;
    }

    @FXML
    private ComboBox<String> ma_ncc;// = new ComboBox<String>();
    @FXML
    private TextField dien_thoai = new TextField();
    @FXML
    private TextField ten_ncc = new TextField();
    @FXML
    private TextField email = new TextField();
    @FXML
    private TextField dia_chi = new TextField();
    @FXML
    private TextField fax = new TextField();



    @FXML
    private TableView<NCC> table = new TableView<NCC>();
    @FXML
    private TableColumn<NCC, String> mancc= new TableColumn<>();
    @FXML
    private TableColumn<NCC, String> tenncc = new TableColumn<>();
    @FXML
    private TableColumn<NCC, String> dienthoai = new TableColumn<>();
    @FXML
    private TableColumn<NCC, String> Email = new TableColumn<>();
    @FXML
    private TableColumn<NCC, String> Fax = new TableColumn<>();
    @FXML
    private TableColumn<NCC, String> diachi = new TableColumn<>();



    @FXML
    void initialize() throws SQLException, ClassNotFoundException {

        ObservableList<NCC> nccList = NccDB.search_all_ncc();
        ObservableList<String> options = FXCollections.observableArrayList();
        for (NCC ncc : nccList) {
            options.add(ncc.getMaNCC());
            System.out.println("-----------------------"+ncc.getMaNCC()+"-------------------------");
        }
        //


        ma_ncc.setEditable(true);
        ma_ncc.setItems(options);
        ma_ncc.getEditor().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("ccccccccccccc");
            }
        });

        //System.out.println("-----------------"+options.get(2)+"-------------------------");

        mancc.setCellValueFactory(c -> c.getValue().maNCCProperty());
        tenncc.setCellValueFactory(c -> c.getValue().nameProperty());
        dienthoai.setCellValueFactory(c -> c.getValue().phoneNumberProperty());
        diachi.setCellValueFactory(c -> c.getValue().addressProperty());
        Fax.setCellValueFactory(c -> c.getValue().faxProperty());
        Email.setCellValueFactory(c -> c.getValue().emailProperty());
    }


    @FXML
    void add_ncc() throws SQLException,ClassNotFoundException {
        try {
            String maNCC_ = ma_ncc.getEditor().getText();
            String name_ = ten_ncc.getText();
            String address_ = dia_chi.getText();
            String phoneNumber_ = dien_thoai.getText();
            String email_ = email.getText();
            String fax_ = fax.getText();
            ma_ncc.getItems().add(maNCC_);
            ma_ncc.getItems().sort((o, o1) -> {
                String s1 = (String) o;
                String s2 = (String) o1;
                if(s1.compareTo(s2) < 0) return -1;
                else return 1;
            });
            NccDB.insertNCC(maNCC_,name_,address_,phoneNumber_,email_,fax_);
            clearText();
        } catch (SQLException e){
            System.out.println(e);
            throw e;
        }
    }
    @FXML
    void delete_ncc() throws SQLException, ClassNotFoundException {
        try {
            String maNCC = (String) ma_ncc.getSelectionModel().getSelectedItem();
            int index = ma_ncc.getSelectionModel().getSelectedIndex();
            ma_ncc.getItems().remove(index);
            NccDB.deleteWithmaNCC(maNCC);
            clearText();

        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
    }

    @FXML
    void update_ncc() throws SQLException, ClassNotFoundException {
        try {
            String maNCC = (String) ma_ncc.getSelectionModel().getSelectedItem();
            String name_ = ten_ncc.getText();
            String address_ = dia_chi.getText();
            String phoneNumber_ = dien_thoai.getText();
            String email_ = email.getText();
            String fax_ = fax.getText();
            NccDB.updateNCC(maNCC,name_,address_,phoneNumber_,email_,fax_);
            clearText();
        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
    }

    @FXML
    void search_ncc() throws SQLException,ClassNotFoundException {
        try {
            String maNCC = (String) ma_ncc.getSelectionModel().getSelectedItem();

            ObservableList<NCC> result = NccDB.search_ncc_by_maNCC(maNCC);

            table.setItems(result);

        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
    }

    void clearText() {
        ten_ncc.setText("");
        dien_thoai.setText("");
        dia_chi.setText("");
        email.setText("");
        fax.setText("");
    }
    @FXML
    private final Button xong = new Button();
    @FXML
    public void close() {
        Stage stage = (Stage) xong.getScene().getWindow();
        stage.close();
    }
}
