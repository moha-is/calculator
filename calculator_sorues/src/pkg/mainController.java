package pkg;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class mainController {

    //fxml var
    @FXML private Pane topBar;
    @FXML private ImageView close,minimize;
    @FXML private Label resultView,process;

    //general var
    private double x , y;
    private double num1 = 0;
    private String operator = "+";
    private int changeable = 1;

    // method that control to the stage
    public void init(Stage stage){
        topBar.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });

        topBar.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX()-x);
            stage.setY(mouseEvent.getScreenY()-y);
        });

        close.setOnMouseClicked( e -> stage.close());//close app
        minimize.setOnMouseClicked(e -> stage.setIconified(true));//minimize app

    }//init method


    @FXML
    void numClick(MouseEvent event) {
        int value = Integer.parseInt(((Pane)event.getSource()).getId().replace("btn",""));// get number from id

        String view = resultView.getText();
        resultView.setText(view + value);

        String processView = process.getText();
        process.setText(processView + value);
    }// number

    @FXML
    void symbolClick(MouseEvent event) {
        String symbol = ((Pane)event.getSource()).getId().replace("btn","");// get symbol name from id
        if (symbol.equals("Result")){
            double num2 = Double.parseDouble(resultView.getText());
            switch (operator){
                case "+":
                    resultView.setText(String.valueOf(num1+(num2)));
                    break;
                case "-":
                    resultView.setText(String.valueOf(num1-(num2)));
                    break;
                case "*":
                    resultView.setText(String.valueOf(num1*(num2)));
                    break;
                case "/":
                    resultView.setText(String.valueOf(num1/(num2)));
                    break;
                case "%":
                    resultView.setText(String.valueOf(num1%(num2)));
                    break;
            }
            operator = ".";
        }
        else if (symbol.equals("Clear")){
            resultView.setText("");
            process.setText("");
            operator = ".";
        }
        else{
            switch (symbol) {
                case "Add":
                    operator = "+";
                    break;
                case "Sub":
                    operator = "-";
                    break;
                case "Mul":
                    operator = "*";
                    break;
                case "Div":
                    operator = "/";
                    break;
                case "Remin":
                    operator = "%";
                    break;
            }
            num1 = Double.parseDouble(resultView.getText());
            String view = process.getText();
            process.setText(view + operator);
            resultView.setText("");
        }
    }// symbol

    @FXML
    void comma(MouseEvent event) {
        String view = resultView.getText();
        resultView.setText(view +".");

        String processView = process.getText();
        process.setText(processView + ".");
    }//comma

    @FXML
    void change(MouseEvent event) {

        if (changeable == 1){
            String view = resultView.getText();
            resultView.setText("-" + view);
            changeable = 0;
        } else {
            String view = resultView.getText().replace("-","");
            resultView.setText(view);
            changeable = 1;
        }

    }//change


    @FXML
    void back(MouseEvent event) {
        String view = resultView.getText();
        String view1 = process.getText();

        if (!view.equals("")) {
            int len = view.length() - 1;
            String text = view.substring(0, len);
            resultView.setText(text);

            //for process Label
            int len1 = view1.length() - 1;
            String text1 = view1.substring(0, len1);
            process.setText(text1);
        }
    }//back

}//mainController class
