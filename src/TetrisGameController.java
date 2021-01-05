import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

public class TetrisGameController {

    @FXML
    private Label playerName, scores;
    @FXML
    private Pane gameDisplay, root;
    @FXML
    private Button startButton;

    //8 columns by 12 rows
    Rectangle[][] rect = new Rectangle[10][15];

    GridPane gridPane = new GridPane();

    int x = 2;
    int y = 0;

    public void initialize(){
        getInfoFromUser();
        //tiles();
        tilesUsingGridPane();
        //startGame(); // once you click the start button, the game will start.
        speedUpGame(); // once socres reach a certain number, it will increase its speed.
        pauseGame(); // if you press a key, the game will stops.
        endGame(); // if you press a key, the game will end and finish.

        moveTetrimino();
    }

    public void getInfoFromUser(){

        Optional<String> response;

        TextInputDialog portDialog = new TextInputDialog();
        portDialog.setHeaderText("Enter your name");
        portDialog.setTitle("Player");

        response = portDialog.showAndWait();
        playerName.setText(response.get());

    }

    // Temporarily built a button
    // Todo: need to make other tool to replace the start button.
    public void startGame(ActionEvent event){

//        Tetriminos block = new Straight(100,100);
//
//        Rectangle rectangle = new Rectangle(100,100);
//
//        rectangle.setLayoutX(100);
//        rectangle.setLayoutY(200);
//
//        block.setX(100);
//        block.setY(150);

        //root.getChildren().addAll(block.getShape(rectangle));

        //Todo: this is to test only


        //Todo: put cancle(); https://stackoverflow.com/questions/21492693/java-timer-cancel-v-s-timertask-cancel
        Timer timer = new Timer();
   TimerTask task = new TimerTask() {

       //https://www.manongdao.com/q-1217836.html

       @Override
       public void run() {

           if (cancel() != true) {
               y += 1;
               rect[x][y].setFill(Color.BLACK);
               moveTetrimino();
               System.out.println(y);
           }
       }

       @Override
       public boolean cancel() {

           if (y >= 14) return true;
           return false;
       }

   };

        long delay = 0;
        timer.schedule(task, delay, 1000);


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

    private class MyTimer extends AnimationTimer {

        @Override
        public void handle(long now) {

            doHandle();
        }

        private void doHandle() {

            y += 1;
            rect[x][y].setFill(Color.BLACK);
            System.out.println(y);


        }
    }


    public String moveTetrimino() {

        return "It is working?";

//        gameDisplay.setOnKeyPressed(e -> {
//            if (e.getCode() == KeyCode.LEFT) {
//                x--;
//                System.out.println("Is it working?");
//            } else if (e.getCode() == KeyCode.RIGHT) {
//                x++;
//            } else if (e.getCode() == KeyCode.DOWN) {
//                y--;
//            }
//        });
    }

    //Todo: Needs to move the grid to left from the right. It doesn't align with the pane

    public void tilesUsingGridPane(){

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 15; j++){

                rect[i][j] = new Rectangle(40,40);
                rect[i][j].setFill(null);
                rect[i][j].setStroke(Color.BLACK);

                gridPane.add(rect[i][j],i,j);
            }
        }
        //gridPane.setAlignment(Pos.TOP_LEFT);
        gameDisplay.getChildren().addAll(gridPane);
    }

    public void speedUpGame(){

    }

    public void pauseGame(){

    }

    public void endGame(){

    }
}
