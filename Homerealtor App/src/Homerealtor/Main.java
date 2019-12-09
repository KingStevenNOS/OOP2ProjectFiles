package Homerealtor;

import com.sun.javafx.scene.control.IntegerField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.*;

import java.lang.reflect.Field;
import java.rmi.RemoteException;
import java.sql.SQLException;


public class Main extends Application{
    Stage window;
    Button login,register,goBack,register2;
    TextField user;
    PasswordField pass;
    Label message,message2;
    Scene layout,layout2,Layout3;

    public static void main(String [] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {



        /* This Is for the First Login Scene */

        window = stage;
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);



        //Username Field
        Label lbluser = new Label("Username");
        user = new TextField();
        user.setPromptText("Enter your Username here");
        GridPane.setConstraints(lbluser,0,0);
        GridPane.setConstraints(user,3,0);

        //Password Field
        Label lblpassword = new Label("Password");
        pass = new PasswordField();
        pass.setPromptText("Enter Your Username");
        GridPane.setConstraints(lblpassword,0,3);
        GridPane.setConstraints(pass,3,3);

        //Login and Register Buttons

        login = new Button("Login");
        register = new Button("Register");
        GridPane.setConstraints(login,5,2);
        GridPane.setConstraints(register,7,2);


        // Set Message Bar
        message = new Label("Please Log In");
        GridPane.setConstraints(message,0,12);


        //Setting Scenes current configuration
        layout = new Scene(grid,550,170);
        grid.getChildren().addAll(lbluser,user,lblpassword,pass,login,register,message);


        //Showing the layout onto the stage
        window.setTitle("Property App: Please Log In");
        window.getIcons().add(new Image("file:logo.png"));
        window.setScene(layout);
        window.show();


//        ____________________________________________________________


        /* This Is for the Second Register Scene */

        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10, 10, 10, 10));
        grid2.setVgap(5);
        grid2.setHgap(5);

        //Username Field
        Label lblusername = new Label("Username");
        TextField username = new TextField();
        username.setPromptText("Enter your Username here");
        GridPane.setConstraints(lblusername,0,0);
        GridPane.setConstraints(username,0,1);

        //Name Field
        Label lblname = new Label("Full Name");
        TextField name = new TextField();
        name.setPromptText("Enter your Full Name Here");
        GridPane.setConstraints(lblname,0,2);
        GridPane.setConstraints(name,0,3);

        //Phone Number Field
        Label lblPhoneNum = new Label("Phone Number");
        TextField phoneNum = new TextField();
        phoneNum.setPromptText("Enter your Phone Number");
        GridPane.setConstraints(lblPhoneNum,0,4);
        GridPane.setConstraints(phoneNum,0,5);

        //Password Field
        Label lblNewPass = new Label("Password");
        PasswordField newPass = new PasswordField();
        newPass.setPromptText("Enter your Password here");
        GridPane.setConstraints(lblNewPass,0,6);
        GridPane.setConstraints(newPass,0,7);

        //Confirm Password Field
        Label lblConfPass = new Label("Confirm password");
        PasswordField confPass = new PasswordField();
        confPass.setPromptText("Enter your Password Again");
        GridPane.setConstraints(lblConfPass,0,8);
        GridPane.setConstraints(confPass,0,9);

        //email field
        Label lblEmail = new Label("Email");
        TextField email = new TextField();
        email.setPromptText("Enter your Email Here");
        GridPane.setConstraints(lblEmail,0,10);
        GridPane.setConstraints(email,0,11);

        //Property Address Field
        Label lblProperty = new Label("Property");
        TextArea property = new TextArea();
        property.setPromptText("Register Your Property");
        GridPane.setConstraints(lblProperty,0,12);
        GridPane.setConstraints(property,0,13);

        //Return and Register Buttons
        goBack = new Button("Return to Login");
        register2 = new Button("Register");
        GridPane.setConstraints(goBack,0,15);
        GridPane.setConstraints(register2,0,16);

        //Message Bar for Register

        message2 = new Label("Please register");
        GridPane.setConstraints(message2,0,19);

        //Setting Scenes Current Configuration
        layout2 = new Scene(grid2);
        grid2.getChildren().addAll(lblConfPass,lblusername,lblEmail,lblname,lblNewPass,lblProperty,property,newPass,name,username,confPass,email,goBack,register2,message2);





        /* Setting Button Actions */

        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AuthenticationImpl authentication = new AuthenticationImpl();
                if (user.getText() != null || pass.getText() != null){
                    boolean authenticate = false;
                    try {
                        authenticate = authentication.Authenticate(user.getText(), pass.getText(), message.getText());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    if (authenticate == true){

                        User user = new User();
                        int id = user.getId();
                        String name = user.getName();
                        String propertyAddress = user.getPropertyAddress();
                        String date = user.getTime();
                        YourProperty.display(name,propertyAddress,date);

                    }else{

                        message.setText("Invalid Login Credentials");
                        message.setStyle("-fx-text-fill: red");

                    }
                }

            }
        });

        register.setOnAction(event -> {
            window.setTitle("Property App: Register your Property Here");
            window.setScene(layout2);

        });

        register2.setOnAction(event -> {

            AuthenticationImpl authenticate = new AuthenticationImpl();
            boolean register = false;
            try {
                register = authenticate.Register(name.getText(), username.getText(),  phoneNum.getText(), newPass.getText(), property.getText(), email.getText());
            } catch (RemoteException e) {
                message2.setText("There is an error With your Data");
                message2.setStyle("-fx-text-fill: red");
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                message2.setText("There is an error With your Data");
                message2.setStyle("-fx-text-fill: red");
                e.printStackTrace();
            } catch (SQLException e) {
                message2.setText("There is an error With your Data");
                message2.setStyle("-fx-text-fill: red");
                e.printStackTrace();
            }
            if (register == true){
                window.setScene(layout);
                window.setTitle("Property App: Register your Property Here");
                message.setText("You have Registered Successfully");
                message.setStyle("-fx-text-fill: green");

            }else{
                message2.setText("There is an error With your Data");
                message2.setStyle("-fx-text-fill: red");
            }

        });


        goBack.setOnAction(event -> {
            window.setScene(layout);
            window.setTitle("Property App: Please Log In");
            message.setText("Please Log In");
        });
    }
}