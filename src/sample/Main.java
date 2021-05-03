package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.controller.Guest_information_Controller;

public class Main extends Application {
    private Stage primaryStage;
    public static AnchorPane root;

    public static Guest_information_Controller g = new Guest_information_Controller();
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("test ");


        root = FXMLLoader.load(getClass().getResource("view/Guest_information.fxml"));
        g.setMain(this);
        this.primaryStage.setScene(new Scene(root, 576, 440));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
