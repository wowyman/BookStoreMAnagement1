package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.controller.Guest_information_Controller;
import sample.controller.LoginController;
import sample.controller.MenuController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main extends Application {
    public Stage primaryStage;
    public static AnchorPane root;
    @FXML
    ImageView imageView;
    public MenuController menu;
    public LoginController loginController;

    public static Guest_information_Controller g = new Guest_information_Controller();

    @Override
    public void start(Stage primaryStage) {

        //1) Declare a primary stage (Everything will be on this stage)
        this.primaryStage = primaryStage;

        //Optional: Set a title for primary stage
        this.primaryStage.setTitle("Hệ thống quản lý nhà sách");
        LoginController.setMain(this);
        MenuController.setMain(this);
        //2) Initialize RootLayout
        initRootLayout();


    }



    public void initRootLayout() {
        try {

            root = FXMLLoader.load(getClass().getResource("view/Login.fxml"));
            //MenuController.setImageView();
            FileInputStream inputstream = new FileInputStream(new File(System.getProperty("user.dir") + "\\src\\sample\\icon1.jpg"));
            Image image = new Image(inputstream);
            //Second, show the scene containing the root layout.
            Scene scene = new Scene(root,668,303); //We are sending rootLayout to the Scene.
            primaryStage.setScene(scene);
            primaryStage.getIcons().add(image);
            LoginController.setMain(this);
            primaryStage.show(); //Display the primary stage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);

    }
}
