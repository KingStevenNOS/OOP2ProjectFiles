package Homerealtor;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Homerealtor {
    public static void main(String username, String name,String email, String propertyAddress, String Date ) {
        Stage window = new Stage();

        //Setting new Layout
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10,10,10,10));
        layout.setHgap(8);
        layout.setVgap(10);

        //Name Field
        Label nameShow = new Label("name");
        Text nameArea = new Text(name);
        nameArea.setX(50);
        nameArea.setY(50);
        Group nameA = new Group(nameArea);
        GridPane.setConstraints(nameShow,0,0);
        GridPane.setConstraints(nameA,0,1);

        //Email Address Field
        Label emailShow = new Label("email");
        Text emailArea = new Text(email);
        emailArea.setX(50);
        emailArea.setY(50);
        Group emailA = new Group(emailArea);
        GridPane.setConstraints(emailShow,3,0);
        GridPane.setConstraints(emailA,3,1);

        //Property Field
        Label propShow = new Label("Your Registered Property");
        Text propArea = new Text(propertyAddress);
        propArea.setX(50);
        propArea.setY(50);
        Group propA = new Group(propArea);
        GridPane.setConstraints(propShow,2,4);
        GridPane.setConstraints(propA,2,5);

        layout.getChildren().addAll(nameShow,nameA,emailShow,emailA,propShow,propA);
        Scene scene = new Scene(layout,1280,720);




        window.setScene(scene);
        window.getIcons().add(new Image("file:logo.png"));
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Welcome Mr."+name);
        window.showAndWait();

    }
}
