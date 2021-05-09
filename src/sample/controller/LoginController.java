package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import sample.Main;
import sample.model.LoginDB;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

public class LoginController {

    String name;
    String pass;
    public  static  int val;
    public  static Main ob;

    public MenuController menuController;
    public  static  void setMain(Main b){
        ob=b;
    }



    @FXML

    private TextField user_id;

    @FXML
    private PasswordField password_id;

    @FXML
    void forget_action() throws  Exception{
        File newTextFile = new File(System.getProperty("user.dir") +"\\src\\sample\\controller\\output.txt");

        FileWriter fw = new FileWriter(newTextFile);
        fw.write("User Name : Euser\n");
        fw.write("Password : 123");
        fw.close();
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle("Attention");
        alert.setContentText("Username and Password is sent to your Secret File.");
        alert.show();

    }

    @FXML
    void login_action() throws Exception{
        String name=user_id.getText();
        String  pass=password_id.getText();
        int t= LoginDB.pass_match(name,pass);
        val=t;

        if(t==2 || t==1) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Menu.fxml"));
            FileInputStream inputstream = new FileInputStream(new File(System.getProperty("user.dir") + "\\src\\sample\\icon1.jpg"));
            Image image = new Image(inputstream);


            Parent root = loader.load();


            ob.primaryStage.close();
            ob.primaryStage.setTitle("Hệ thống quản lý nhà sách");
            ob.primaryStage.getIcons().add(image);
            ob.primaryStage.setScene(new Scene(root));
            ob.primaryStage.show();

        } else {
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("Attention");
            alert.setContentText("Tên đăng nhập hoặc mật khẩu không đúng.");
            alert.show();
        }


    }


}
