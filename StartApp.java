package com.example.studentapplicationsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApp extends Application {
    private static Stage window;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApp.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Student Application System");
        stage.setScene(scene);
        window = stage;
        stage.show();
    }

    public static Stage getWindow() {
        return window;
    }

    public static void main(String[] args) {
        launch();
    }
}