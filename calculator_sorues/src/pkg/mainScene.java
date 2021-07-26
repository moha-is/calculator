package pkg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class mainScene extends Application {

    public static void main(String[] args) {
        launch(args);
    }//main


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../mainFXML.fxml"));
        Scene Scene = new Scene(loader.load());
        Scene.setFill(Color.TRANSPARENT); // this for hide main body


        stage.setScene(Scene);
        stage.initStyle(StageStyle.TRANSPARENT); //this for delete windows top bar
        stage.setTitle("calcolater");
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/img/calculator-icon.png")));// icon in Taskbar
        ((mainController)loader.getController()).init(stage);// get controller from mainController class
        stage.show();
    }//start

}//class
