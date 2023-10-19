package com.example.studentapplicationsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PreviewController extends Util implements Initializable {
    @FXML
    private Button btnSubmit;

    @FXML
    private TextArea txtDisplay;

    @FXML
    private Button btnCancel;

    private DBAccess dba;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            dba = new DBAccess();
//            User user = dba.findUserProfile(LoginController.getLoginId());
            User user = FormController.userDetails;

            txtDisplay.setText("" +
                    "\t\t\t\tREVIEW YOUR DETAILS\n" +
                    "FUll Name : "+user.getName()+"\n" +
                    "Date Of Birth : "+user.getDOB()+"\n" +
                    "Address : "+user.getAddress()+"\n" +
                    "Program : "+user.getProgram()+"\n" +
                    "Phone Number : "+user.getPhoneNumber()+"\n" +
                    "Email : "+user.getEmail()+"\n");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registerUser() throws Exception {
        User user = FormController.userDetails;
         DBAccess dba = new DBAccess();
        if (dba.registerStudent(user) == 1){
            changeScene("Login.fxml", StartApp.getWindow());
        }else{
            errorBox("Registration failed...Retry");
            changeScene("Login.fxml", StartApp.getWindow());
        }
    }


    public void returnTOForm(ActionEvent event) throws IOException {
//        ((Stage)((Node)(event.getSource())).getScene().getWindow()).close();
        changeScene("form.fxml", StartApp.getWindow());
    }
}
