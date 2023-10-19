package com.example.studentapplicationsystem;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class Util {
    protected User DBAccess;

    public void changeScene(String fileName, Stage oldStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fileName));
        oldStage.setScene(new Scene(root));
    }

    public void confirmBox(String content){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(content);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    public void errorBox(String content){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(content);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}
