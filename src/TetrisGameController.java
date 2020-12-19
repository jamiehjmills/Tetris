import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;

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

    public void startGame(){

    }

    public void speedUpGame(){

    }

    public void pauseGame(){

    }

    public void endGame(){

    }
}
