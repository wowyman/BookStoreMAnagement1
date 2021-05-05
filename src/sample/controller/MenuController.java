package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;

public class MenuController {
    public static Main ob;
    public static void setMain(Main main) {
        MenuController.ob = main;
    }
    public static AnchorPane root;

    public static Book_information_controller bic;
    public static Book_supplier_controller bsc;
    public static Employee_controller ec;
    public static Guest_information_Controller gic;
    public static LoginController lc;
    public static Managementcardguest mc;
    public static searchbook sbc;
    public static searchemployee sec;
    public static searchguest sgc;
    public static PhieunhapController phieunhapController;
    public static User_controller user_controller;

    @FXML
    private AnchorPane appMother;

    @FXML
    ImageView imageView;
    public MenuController menu;

    @FXML
    void LoginController(ActionEvent event) {
        if(LoginController.val==1)
            return;
        try {

            //lc.setMenuController(this);
            //First, load EmployeeView from EmployeeView.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Login.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            LoginController.setMain(ob);
            stage.setTitle("Login");
            stage.setScene(new Scene(root));
            stage.show();
            ob.primaryStage.close();
            System.out.println("close thanh cong");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void user_controller(ActionEvent event) {

        try {

            //First, load EmployeeView from EmployeeView.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/User.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();

            stage.setTitle("User");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void phieunhapController(ActionEvent event) {
        if(LoginController.val==1)
            return;
        try {
            //First, load EmployeeView from EmployeeView.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/receipt.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();

            stage.setTitle("Phiếu nhập");
            stage.setScene(new Scene(root));
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void Book_information_controller_action(ActionEvent event) {
        if(LoginController.val==1)
            return;
        try {
            //First, load EmployeeView from EmployeeView.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Bookinformation.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();

            stage.setTitle("Thông tin sách");
            stage.setScene(new Scene(root));
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Book_supplier_controller(ActionEvent event) {
        if(LoginController.val==1)
            return;
        try {
            //First, load EmployeeView from EmployeeView.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Booksupplier.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();

            stage.setTitle("Nhà cung cấp");
            stage.setScene(new Scene(root));
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Employee_controller(ActionEvent event) {
        if(LoginController.val==1)
            return;
        try {
            //First, load EmployeeView from EmployeeView.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Employee.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();

            stage.setTitle("Nhân viên");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Guest_information_Controller(ActionEvent event) {
        if(LoginController.val==1)
            return;
        try {
            //First, load EmployeeView from EmployeeView.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Guest_information.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();

            stage.setTitle("Thông tin khách");
            stage.setScene(new Scene(root));
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @FXML
    void Managementcardguest(ActionEvent event) {
        if(LoginController.val==1)
            return;
        try {
            //First, load EmployeeView from EmployeeView.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/managementcardguests.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();

            stage.setTitle("Quản lý thẻ khách");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void ttnhom(ActionEvent event) {

        try {
            //First, load EmployeeView from EmployeeView.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/introduceprogram.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();

            stage.setTitle("Thông tin nhóm");
            stage.setScene(new Scene(root));
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void searchbook(ActionEvent event) {
        if(LoginController.val==1)
            return;
        try {
            //First, load EmployeeView from EmployeeView.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/searchebook.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();

            stage.setTitle("User");
            stage.setScene(new Scene(root));
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void searchemployee(ActionEvent event) {
        if(LoginController.val==1)
            return;
        try {
            //First, load EmployeeView from EmployeeView.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/searchemployee.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();

            stage.setTitle("User");
            stage.setScene(new Scene(root));
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void searchguest(ActionEvent event) {
        if(LoginController.val==1)
            return;
        try {
            //First, load EmployeeView from EmployeeView.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/searchguestinformation.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();

            stage.setTitle("User");
            stage.setScene(new Scene(root));
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void close() {
        ob.primaryStage.close();
    }
}
