package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Student;

import java.io.*;

public class Main extends Application {

    PrintStream out;

    @Override
    public void start(Stage primaryStage) throws Exception{

        try {
            File myObj = new File("C:\\JAVA\\Lab13_2\\Studentlist.csv");
            myObj.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            out = new PrintStream("C:\\JAVA\\Lab13_2\\Studentlist.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(createGridPane());

        primaryStage.setTitle("Grid Pane Example");
        primaryStage.setScene(scene);
        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);
    }

    public GridPane createGridPane() {
        Text emailText = new Text("Email: ");
        Text firstNameText = new Text("First Name: ");
        Text lastNameText = new Text("Last Name: ");

        TextField emailTextField = new TextField();
        TextField firstNameTextField = new TextField();
        TextField lastNameTextField = new TextField();

        Button submitButton = new Button("Submit");
        Button clearButton = new Button("Clear");

        GridPane gridPane = new GridPane();

        gridPane.setMinSize(300,200);
        gridPane.setPadding(new Insets(10, 10, 10, 10 ));

        gridPane.setVgap(5);
        gridPane.setHgap(5);

        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(firstNameText, 0,0);
        gridPane.add(lastNameText, 0,1);
        gridPane.add(emailText, 0,2);

        gridPane.add(firstNameTextField, 1,0);
        gridPane.add(lastNameTextField, 1,1);
        gridPane.add(emailTextField, 1,2);

        gridPane.add(submitButton, 0, 3);
        gridPane.add(clearButton,1, 3);


        submitButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {

                String firstName = firstNameTextField.getText();
                String lastName = lastNameTextField.getText();
                String email = emailTextField.getText();
                out.println(new Student(firstName,lastName, email));

                firstNameTextField.setText("");
                lastNameTextField.setText("");
                emailTextField.setText("");
            }
        });
        clearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                firstNameTextField.setText("");
                lastNameTextField.setText("");
                emailTextField.setText("");
            }
        });
        return gridPane;
    }
}
