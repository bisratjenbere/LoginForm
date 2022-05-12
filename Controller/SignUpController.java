
package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

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
import javafx.stage.Stage;

public class SignUpController {

    @FXML
    private Button cancelbutton;

    @FXML
    private TextField et;

    @FXML
    private TextField ft;

    @FXML
    private TextField lt;

    @FXML
    private Label messageSignupButton;

    @FXML
    private PasswordField ppt;

    @FXML
    private Button signup;

    @FXML
    private TextField un;

    @FXML
    void signup(ActionEvent event) {
        if (ft.getText().isEmpty() == false && lt.getText().isEmpty() == false
                && et.getText().isEmpty() == false && ppt.getText().isEmpty() == false
                && un.getText().isEmpty() == false) {
            store();
        } else {
            Alert a = new Alert(AlertType.ERROR, "Fild cann't be empty");
            a.show();

        }
    }

    @FXML
    void cancelhandler(ActionEvent event) {
        Stage stage = (Stage) cancelbutton.getScene().getWindow();
        stage.close();
    }

    public void store() {
        DataBaseAcess c = new DataBaseAcess();
        Connection con = c.getconnection();

        String sql = ("insert into User(firstName,lastName,email,userName,password) values(?,?,?,?,?)");
        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, ft.getText());
            st.setString(2, lt.getText());
            st.setString(3, et.getText());
            st.setString(4, un.getText());
            st.setString(5, ppt.getText());

            st.executeUpdate();

            mainWindow();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void mainWindow() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/login.fxml"));
        Stage stage = (Stage) cancelbutton.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    };

}