package com.example.studentapplicationsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserPanelController extends Util implements Initializable{
    @FXML
    private AnchorPane PnProfileView;

    @FXML
    private AnchorPane PnStatusView;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnStatus;

    @FXML
    private Button btnViewProfile;

    @FXML
    private Label lblUserName;

    @FXML
    private StackPane mainLayer;

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblPhone;

    @FXML
    private Label lblFullName2;

    @FXML
    private Label lblFullName3;

    private DBAccess dba;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            dba = new DBAccess();
            User user = dba.findUserProfile(LoginController.getLoginId());
            lblUserName.setText(user.getName());
            lblAddress.setText(user.getAddress());
            lblEmail.setText(user.getEmail());
            lblPhone.setText(user.getPhoneNumber());
            lblDate.setText(user.getDOB());
            lblFullName2.setText(user.getName());
            lblFullName3.setText(user.getName());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchScene(ActionEvent event) throws IOException {
        if (event.getSource().equals(btnViewProfile)){
            mainLayer.getChildren().setAll(PnProfileView);
        }else if (event.getSource().equals(btnStatus)) {
            mainLayer.getChildren().setAll(PnStatusView);
        }else{
            changeScene("Login.fxml", StartApp.getWindow());
        }
    }
}
