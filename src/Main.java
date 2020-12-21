import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 420, 650));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
