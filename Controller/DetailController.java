package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

public class DetailController {

    @FXML
    private Circle circle;
    private double y;
    private double x;

    @FXML
    void down(ActionEvent event) {
        circle.setCenterY(y += 30);
    }

    @FXML
    void left(ActionEvent event) {
        circle.setCenterX(x -= 30);
    }

    @FXML
    void right(ActionEvent event) {
        circle.setCenterX(x += 30);
    }

    @FXML
    void up(ActionEvent event) {
        circle.setCenterY(y -= 30);

    }

}
