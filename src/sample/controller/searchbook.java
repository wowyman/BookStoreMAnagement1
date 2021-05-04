package sample.controller;

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
import sample.model.Book;
import sample.model.BookDB;
import sample.model.Employee;
import sample.model.EmployeeDB;

import java.sql.SQLException;

public class searchbook {
    @FXML
    TextField tensach;
    @FXML
    TextField tentacgia;
    @FXML
    TableView<Book> bookTableView ;
    String ts;
    String ttg;
    @FXML
    TableColumn<Book, String> ms_col;
    @FXML
    TableColumn<Book, String> name_col;
    @FXML
    TableColumn<Book, String> theloai_col;
    @FXML
    TableColumn<Book, String> author_col;
    @FXML
    TableColumn<Book, String> price_col;
    @FXML
    TableColumn<Book, String> vitritru_col;
    @FXML
    TableColumn<Book, String> sochomuon_col;
    @FXML
    TableColumn<Book, String> sotonlai_col;
    ObservableList<Book> true_list1 = FXCollections.observableArrayList();
    ObservableList<Book> true_list2 = FXCollections.observableArrayList();
    @FXML
    public void handle_tensach() throws SQLException, ClassNotFoundException {
        ObservableList<Book> listView = BookDB.search_all_book();
        ts= tensach.getText();
        System.out.println(listView.get(0).getBookTitle());
        System.out.println(listView.size());
        ms_col.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        name_col.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        theloai_col.setCellValueFactory(new PropertyValueFactory<>("theLoai"));
        author_col.setCellValueFactory(new PropertyValueFactory<>("author"));
        price_col.setCellValueFactory(new PropertyValueFactory<>("price"));
        vitritru_col.setCellValueFactory(new PropertyValueFactory<>("namXB"));
        sochomuon_col.setCellValueFactory(new PropertyValueFactory<>("tap"));
        sotonlai_col.setCellValueFactory(new PropertyValueFactory<>("soLuong"));
        for (Book book : listView) {
            if (ts.equals(book.getBookTitle())) {
                true_list1.add(book);
                System.out.println("ss");
                bookTableView.setItems(true_list1);
            }
        }

    }
    @FXML
    public void handle_ttg() {
        ttg = tentacgia.getText();
        for (Book book : true_list1) {
            if (ttg.equals(book.getAuthor())) {
                true_list2.add(book);
                System.out.println("ss");
                bookTableView.refresh();
                bookTableView.setItems(true_list2);
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
            AnchorPane root1 = FXMLLoader.load(getClass().getResource("/src/sample/view/Bookinformation.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("thong tin sach");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
