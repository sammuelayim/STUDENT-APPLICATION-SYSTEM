package com.example.studentapplicationsystem;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.ResourceBundle;

public class FormController extends Util implements Initializable {
    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtFullName;
    @FXML
    private TextField txtDateOfBirth;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtDateSubmission;
    @FXML
    private ComboBox<String> cbProgramme;
    @FXML
    private CheckBox chMale;



    @FXML
    private CheckBox chFemale;

    private DBAccess dba;

    public void registerUser(User user) throws Exception {
        dba = new DBAccess();
        if (dba.registerStudent(user) == 1){
            changeScene("Preview.fxml", new Stage());
        }else{
            errorBox("Registration failed...Retry");
        }
    }

    public static User userDetails;

    public void setUserDetails() throws IOException {
        String program = cbProgramme.getValue();
        User user = new User(txtAddress.getText(), txtDateOfBirth.getText(), program, new Timestamp(new Date().getTime()), txtPhone.getText()
                , txtEmail.getText(), txtFullName.getText(), LoginController.getLoginId());
        userDetails = user;
        changeScene("Preview.fxml", StartApp.getWindow());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            dba = new DBAccess();
            ResultSet rs = dba.getAllProgram();
            ObservableList<String> programs = FXCollections.observableArrayList();
            while (rs.next()){
                programs.add(rs.getString("programme_name"));
            }
                cbProgramme.setItems(programs);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
