package Homerealtor;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


//implementing the remote interface
public class AuthenticationImpl implements Methods_RMI{


    //Implement Authentication method
    public boolean Authenticate(String username, String password, String message) throws RemoteException, ClassNotFoundException, SQLException {
        //Connect to JDBC
        boolean loginValue;
        List<User> list = new ArrayList<User>();
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Open a connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Homerealtor","root","");

        //Execute a query
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE username = '"+username+"' AND password = '"+password+"'");

        //Get Data from result Set

        if (rs.next()) {
            //Get Data by Column name
            int id = rs.getInt("id");
            String userName = rs.getString("name");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String propertyAddress = rs.getString("propertyAddress");
            String phoneNum = rs.getString("phoneNumber");
            String time = rs.getString("Date");

            //Set the Values
            User user = new User();
            user.setId(id);
            user.setEmail(email);
            user.setName(name);
            user.setPhoneNum(phoneNum);
            user.setTime(time);
            list.add(user);
            Homerealtor.main(userName,name,email,propertyAddress,time);
            loginValue = true;

        }
        else {
            loginValue = false;

        }
        rs.close();
        return loginValue;
    }


    @Override

    //Implement Register Method
    public boolean Register(String name, String username, String phoneNum, String password, String propertyAddress, String email) throws RemoteException, ClassNotFoundException, SQLException,NumberFormatException {
        //Connecting to JDBC
        boolean rs;
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Open a connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/homerealtor","root","");

        //Execute Query
        if (name.isEmpty() || username.isEmpty() || password.isEmpty() || propertyAddress.isEmpty() || email.isEmpty()){

            rs = false;

        }else{
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO users(username,password,name,propertyAddress,phoneNumber,email) VALUES('"+username+"','"+password+"','"+name+"','"+propertyAddress+"','"+phoneNum+"','"+email+"')");

            rs = true;
        }
        connection.close();

        return rs;
    }


}