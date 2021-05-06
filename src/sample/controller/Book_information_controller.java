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

public class Book_information_controller {
    public static Main main;

    public static void setMain(Main main_) {
        main = main_;
    }

    @FXML
    private final ComboBox ma_sach = new ComboBox();
    @FXML
    private final TextField ten_sach = new TextField();
    @FXML
    private final TextField the_loai = new TextField();
    @FXML
    private final TextField tac_gia = new TextField();
    @FXML
    private final ChoiceBox vi_tri_tru = new ChoiceBox();
    @FXML
    private final TextField gia = new TextField();
    @FXML
    private final TextField so_luong = new TextField();



    @FXML
    private final TableView<Book> table = new TableView<Book>();
    @FXML
    private final TableColumn<Book, String> masach= new TableColumn<>();
    @FXML
    private final TableColumn<Book, String> tensach = new TableColumn<>();
    @FXML
    private final TableColumn<Book, String> theloai = new TableColumn<>();
    @FXML
    private final TableColumn<Book, String> tacgia = new TableColumn<>();
    @FXML
    private final TableColumn<Book, String> giasach = new TableColumn<>();
    @FXML
    private final TableColumn<Book, String> vitritru = new TableColumn<>();
    @FXML
    private final TableColumn<Book, Integer> soluong = new TableColumn<>();



    @FXML
    void initialize() throws SQLException, ClassNotFoundException {

        ObservableList<Book> bookList = BookDB.search_all_book();
        ObservableList<String> options = FXCollections.observableArrayList();
        for (Book book : bookList) {
            options.add(book.getBookId());
        }
        //
        ma_sach.setEditable(true);
        ma_sach.getItems().addAll(options);

        ObservableList<Kho> vitritruList = KhoDB.searchKho();
        ObservableList<String> options1 = FXCollections.observableArrayList();
        for (Kho cv : vitritruList) {
            options1.add(cv.getTenKho());
        }
        //
        vi_tri_tru.getItems().addAll(options1);



        masach.setCellValueFactory(c -> c.getValue().bookIdProperty());
        tensach.setCellValueFactory(c -> c.getValue().bookTitleProperty());
        theloai.setCellValueFactory(c -> c.getValue().theLoaiProperty());
        vitritru.setCellValueFactory(c -> c.getValue().getKho().tenKhoProperty());
        giasach.setCellValueFactory(c -> c.getValue().priceProperty().asString());
        soluong.setCellValueFactory(c -> c.getValue().soLuongProperty().asObject());
        tacgia.setCellValueFactory(c -> c.getValue().authorProperty());
    }


    @FXML
    void add_book() throws SQLException,ClassNotFoundException {
        try {
            String masach_ = ma_sach.getEditor().getText();
            String theloai_ = the_loai.getText();
            String tacgia_ = tac_gia.getText();
            String ten_sachText = ten_sach.getText();

            String vitritru_ = vi_tri_tru.getValue().toString();
            String giaText = gia.getText();
            String soluongText   = so_luong.getText();
            String XBlan_default = "1";
            String namXb_default = "2020-2-2";
            String tap_default = "1";


            ma_sach.getItems().add(masach_);
            ma_sach.getItems().sort((o, o1) -> {
                String s1 = (String) o;
                String s2 = (String) o1;
                if(s1.compareTo(s2) < 0) return -1;
                else return 1;
            });
            BookDB.insertBook(masach_,ten_sachText,tacgia_,XBlan_default,theloai_,namXb_default,tap_default,giaText,soluongText,vitritru_);
            clearText();
        } catch (SQLException e){
            System.out.println(e);
            throw e;
        }
    }
    @FXML
    void delete_book() throws SQLException, ClassNotFoundException {
        try {
            String masach_ = (String) ma_sach.getSelectionModel().getSelectedItem();
            int index = ma_sach.getSelectionModel().getSelectedIndex();
            ma_sach.getItems().remove(index);
            BookDB.deleteWithBookID(masach_);
            clearText();

        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
    }

    @FXML
    void update_book() throws SQLException, ClassNotFoundException {
        try {
            String masach_ = ma_sach.getEditor().getText();
            String theloai_ = the_loai.getText();
            String tacgia_ = tac_gia.getText();
            String ten_sachText = ten_sach.getText();

            String vitritru_ = vi_tri_tru.getValue().toString();
            String giaText = gia.getText();
            String soluongText   = so_luong.getText();


            BookDB.updateBook(masach_,ten_sachText,theloai_,tacgia_,giaText,vitritru_,soluongText);
            clearText();
        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
    }

    @FXML
    void search_book() throws SQLException,ClassNotFoundException {
        try {
            String masach_ = (String) ma_sach.getSelectionModel().getSelectedItem();

            ObservableList<Book> result = BookDB.search_by_bookID(masach_);

            table.setItems(result);

        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
    }

    void clearText() {
        the_loai.setText("");
        ten_sach.setText("");
        tac_gia.setText("");
        gia.setText("");
    }
    @FXML
    private final Button xong = new Button();
    @FXML
    public void close() {
        Stage stage = (Stage) xong.getScene().getWindow();
        stage.close();
    }
}
