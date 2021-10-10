/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author aashgar
 */
public class MainApp extends Application {

    private Button buttonShow, buttonClear;
    private Label labelState;
    private RadioButton radioButtonStart, radioButtonStop;
    private TextArea textArea;
    private Context context = new Context();

    @Override
    public void start(Stage stage) throws Exception {
        FlowPane pane = new FlowPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        labelState = new Label("State");
        radioButtonStart = new RadioButton("Start");
        radioButtonStop = new RadioButton("Stop");
        radioButtonStart.setSelected(true);
        ToggleGroup toggleGroup = new ToggleGroup();
        radioButtonStart.setToggleGroup(toggleGroup);
        radioButtonStop.setToggleGroup(toggleGroup);
        VBox vBox1 = new VBox();
        vBox1.setSpacing(10);
        vBox1.setAlignment(Pos.BASELINE_LEFT);
        vBox1.getChildren().addAll(labelState, radioButtonStart, radioButtonStop);

        buttonShow = new Button("Show");
        buttonClear = new Button("Clear");
        HBox hBox1 = new HBox();
        hBox1.setSpacing(10);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(buttonShow, buttonClear);
        MyEventHandler myEventHandler = new MyEventHandler();
        radioButtonStart.setOnAction(myEventHandler);
        radioButtonStop.setOnAction(myEventHandler);
        buttonShow.setOnAction(myEventHandler);
        buttonClear.setOnAction(myEventHandler);
        textArea = new TextArea();
        textArea.setMaxWidth(300);
        VBox vBox2 = new VBox();
        vBox2.setSpacing(10);
        vBox2.setAlignment(Pos.CENTER);
        vBox2.getChildren().addAll(textArea, hBox1);

        pane.getChildren().addAll(vBox1, vBox2);
        Scene scene = new Scene(pane, 550, 300);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("State Design Pattern");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }

    private class MyEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == radioButtonStart) {
                State startState = new startState();
                textArea.appendText(
                        startState.doAction(context) + "\n");
            } else if (event.getSource() == radioButtonStop) {
                State stoptState = new stopState();
                textArea.appendText(
                        stoptState.doAction(context) + "\n");
            } else if (event.getSource() == buttonShow) {
                textArea.appendText(context.getState() + "\n");
            } else if (event.getSource() == buttonClear) {
                textArea.setText("");

            }
        }
    }
}
