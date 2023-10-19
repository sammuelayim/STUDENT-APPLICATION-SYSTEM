package com.example.studentapplicationsystem;

import com.example.studentapplicationsystem.model.Login;


import java.sql.*;

public class DBAccess {
    private final String DB_NAME = "student_appsystem";
    private final String USER = "root";
    private final String PASS = "";
    private Connection con;
    private ResultSet rs;
    private PreparedStatement pst;
    private final String DBCONNECTION = "jdbc:mysql://localhost:3306/"+DB_NAME;

    public DBAccess() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(DBCONNECTION, USER, PASS);
    }

    public int registerStudent(User user) throws SQLException {
        String query = "INSERT INTO `registrationform` VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?)";
        //String query = "INSERT INTO `registrationform`(`Registration_id`, `login_id`, `Date_Of_Birth`, `Address`, `Date_Of_Submission`, `Programme`, `Phone_Number`, `Email`, `Name`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?)";
        pst = con.prepareStatement(query);
        pst.setInt(1, user.getLoginId());
        pst.setString(2, user.getDOB());
        pst.setString(3, user.getAddress());
        pst.setTimestamp(4, user.getDateOfSubmission());
        pst.setString(5, user.getProgram());
        pst.setString(6, user.getPhoneNumber());
        pst.setString(7, user.getEmail());
        pst.setString(8, user.getName());


        return pst.executeUpdate();
    }

    public ResultSet Login(Login login) throws SQLException {
        pst = con.prepareStatement("SELECT * FROM `login` WHERE serial = ?");
        pst.setString(1, login.getSerial());
       // pst.setInt(2, login.getPin());
        rs = pst.executeQuery();
        return rs;
    }

    public int knowToRedirect(int loginId) throws SQLException {
        pst = con.prepareStatement("SELECT login_id FROM registrationform WHERE login_id = ?");
        pst.setInt(1, loginId);
        rs = pst.executeQuery();
        if(rs.next()){
            return 1;
        }else {
            return 0;
        }
    }


    public User findUserProfile(Integer loginId) throws SQLException {
        pst = con.prepareStatement("SELECT * FROM registrationform WHERE login_id = ?");
        pst.setInt(1, loginId);
        rs = pst.executeQuery();
        return getUserProfile();
    }

    private User getUserProfile() throws SQLException {

        if (rs.next()){
            User user = new User();
            user.setAddress(rs.getString("Address"));
            user.setDOB(rs.getString("Date_Of_Birth"));
            user.setDateOfSubmission(rs.getTimestamp("Date_Of_Submission"));
            user.setEmail(rs.getString("Email"));
            user.setProgram(rs.getString("Programme"));
            user.setPhoneNumber(rs.getString("Phone_Number"));
            user.setName(rs.getString("Name"));
            user.setRegistrationId(rs.getInt("registration_id"));
            return user;
        }
        return null;
    }

    public ResultSet getAllProgram() throws SQLException {
        pst = con.prepareStatement("SELECT programme_name from programme");
        rs = pst.executeQuery();
        return rs;
    }
}
