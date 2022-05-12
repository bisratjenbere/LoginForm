
package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Button cancelButton;

    @FXML
    private Button createButton;

    @FXML
    private Button loginButton;

    @FXML
    private Label message;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private TextField usernamefild;

    @FXML
    void loginhandler(ActionEvent event) {

        if (usernamefild.getText().isEmpty() == false && passwordTextField.getText().isEmpty() == false) {
            userValidater();
        } else {

            Alert a = new Alert(AlertType.WARNING, "Give The Necessary info !!!");

            a.show();
        }

    }

    @FXML
    void createhandler(ActionEvent event) throws IOException {
        try {

            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/signup.fxml"));
            Stage stage = (Stage) usernamefild.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @FXML
    void cancelbuttonhandler(ActionEvent event) {
        Stage stage = (Stage) createButton.getScene().getWindow();
        stage.close();
    }

    private void userValidater() {
        DataBaseAcess c = new DataBaseAcess();
        Connection con = c.getconnection();

        String verify = ("select count(1) From User where userName ='" + usernamefild.getText()
                + "' and password = '" + passwordTextField.getText() + "'");

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(verify);
            while (rs.next())
                if (rs.getInt(1) == 1) {

                    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/Detail.fxml"));
                    Stage stage = (Stage) loginButton.getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                } else {
                    Alert a = new Alert(AlertType.WARNING, "user not exist");

                    a.show();

                }

        } catch (Exception e) {

        }
    }

}
