import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Arrays;
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

    boolean keyIsMoving;

    //8 columns by 12 rows
    Rectangle[][] rect = new Rectangle[10][15];
    // 1 column by 4 rows
    Rectangle[][] straightBoxes = new Rectangle[1][4];

    Group group = new Group();


    GridPane gridPane = new GridPane();

    int x = 2;
    int y = 0;

    public void initialize(){
        getInfoFromUser();
        bringTetriminos();
        tilesUsingGridPane();

        //tiles();
        //startGame(); // once you click the start button, the game will start.
        //speedUpGame(); // once socres reach a certain number, it will increase its speed.
        //pauseGame(); // if you press a key, the game will stops.
        //endGame(); // if you press a key, the game will end and finish.
    }

    public void getInfoFromUser(){

        Optional<String> response;

        TextInputDialog portDialog = new TextInputDialog();
        portDialog.setHeaderText("Enter your name");
        portDialog.setTitle("Player");

        response = portDialog.showAndWait();
        playerName.setText(response.get());

    }

    //http://www.java2s.com/Code/Java/JavaFX/AddingRectanglestoGroup.htm

    public void bringTetriminos(){
        Tetriminos straight = new Straight(40,40);
        straightBoxes = straight.shapeLayout(190, 50, 40);



        for(int i = 0; i < 1; i++){
            for(int j = 0; j < 4; j++){

                gridPane.add(straightBoxes[i][j],i,j);
                //group.getChildren().add(straightBoxes[i][j]);

            }
        }
        //gridPane.setAlignment(Pos.TOP_LEFT);

        root.getChildren().addAll(gridPane);

    }

    // Temporarily built a button
    // Todo: need to make other tool to replace the start button.
    public void startGame(ActionEvent event){

        //Todo: this is to test only

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

       //https://www.manongdao.com/q-1217836.html

       @Override
       public void run() {

           if (cancel() != true) {

               y++;

               keyIsMoving = true;

               System.out.println(y);

               gridPane.setRowIndex(straightBoxes[0][0], y);
               gridPane.setRowIndex(straightBoxes[0][1], y+1);
               gridPane.setRowIndex(straightBoxes[0][2], y+2);
               gridPane.setRowIndex(straightBoxes[0][3], y+3);
           }
       }

       @Override
       public boolean cancel() {

           if (y >= 11){
               keyIsMoving = false;
               return true;

           } return false;
       }

   };

        long delay = 0;
        timer.schedule(task, delay, 1000);

    }

    // it works!
    public void setKeyEvent(KeyEvent e){
        root.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {

                if(e.getCode() == KeyCode.NUMPAD4 && keyIsMoving){
                    System.out.println("LEFT - NUMPAD4"); // it means left
                    //bringTetriminos();
                }else if(e.getCode() == KeyCode.NUMPAD6 && keyIsMoving){
                    System.out.println("RIGHT - NUMPAD6"); // it means right
                    //bringTetriminos();
                }

            }

        });
    }

//    private class MyTimer extends AnimationTimer {
//
//        @Override
//        public void handle(long now) {
//
//            doHandle();
//        }
//
//        private void doHandle() {
//
//            y += 1;
//            rect[x][y].setFill(Color.BLACK);
//            System.out.println(y);
//
//
//        }
//    }


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





}
