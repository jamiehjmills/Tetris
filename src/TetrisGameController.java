import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.util.Optional;

public class TetrisGameController {

    @FXML
    private Label playerName, scores;
    @FXML
    private Pane gameDisplay, root;
    @FXML
    private Button startButton;

    public void initialize(){
        getInfoFromUser();
        //startGame(); // once you click the start button, the game will start.
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

    // Temporarily built a button Todo: need to make other tool to replace the start button.
    public void startGame(ActionEvent event){

        Tetriminos block = new Tetriminos(100,100);

        Rectangle rectangle = new Rectangle(100,100);

        rectangle.setLayoutX(100);
        rectangle.setLayoutY(200);

        block.setX(100);
        block.setY(150);


        root.getChildren().addAll(block.getShape(rectangle));

//        Tetriminos[] blocks = new Tetriminos[3];
//
//        double x = 100;
//
//        for(int i = 0; i < blocks.length; i++){
//            blocks[i] = new Tetriminos(10,10);
//        }
//
//
//        blocks[0].setX(100);
//        blocks[0].setY(150);
//        blocks[0].shape(new Rectangle());


    }

    public void speedUpGame(){

    }

    public void pauseGame(){

    }

    public void endGame(){

    }
}
