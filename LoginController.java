package com.example.studentapplicationsystem;

import com.example.studentapplicationsystem.model.Login;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController extends Util{
    @FXML
    private Button btnCancel;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtPin;

    @FXML
    private TextField txtSerialNumber;

    private DBAccess dba;
    private static int loginId;

    public void handleLogin() throws Exception {
        Login login = new Login(txtSerialNumber.getText(), Integer.parseInt(txtPin.getText()));
        dba = new DBAccess();
        ResultSet rs = dba.Login(login);
        if(rs.next()){
            loginId = rs.getInt(1);
            if (dba.knowToRedirect(loginId) == 1){
                changeScene("UserPanel.fxml", StartApp.getWindow());
            }else{
                changeScene("form.fxml", StartApp.getWindow());
            }
        }else{
            errorBox("Serial Number or pin incorrect!!!");
        }
    }

    public static int getLoginId() {
        return loginId;
    }

    public void closePage(){
        System.exit(0);
    }
}
