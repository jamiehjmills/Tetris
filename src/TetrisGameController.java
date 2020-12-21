import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.util.Optional;

public class TetrisGameController {

    @FXML
    public Label playerName, scores;
    @FXML
    public Pane gameDisplay;

    public void initialize(){
        getInfoFromUser();
        startGame(); // once you click the start button, the game will start.
        speedUpGame(); // once socres reach a certain number, it will increase its speed.
        pauseGame(); // if you press a key, the game will stops.
        endGame(); // if you press a key, the game will end and finish.
    }

    public void getInfoFromUser(){

        Optional<String> response;

        TextInputDialog portDialog = new TextInputDialog();
        portDialog.setHeaderText("Enter your name");
        portDialog.setTitle("Player");

        response = portDialog.showAndWait();
        playerName.setText(response.get());

    }

    // Temproraly built a button
    public void startGame(){

        Rectangle rectangle

        Tetriminos tetriminos = new Tetriminos(10,10);

        tetriminos.setX(200);
        tetriminos.setY(1);


        tetriminos.shape(new Rectangle());
    }

    public void speedUpGame(){

    }

    public void pauseGame(){

    }

    public void endGame(){

    }
}
