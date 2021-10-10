/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    private TextField textFieldMid, textFieldLab, textFieldFin;
    private RadioButton radioButtonIt, radioButtonEng, radioButtonArt;
    private TextArea textArea;
    private Context context;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FlowPane pane = new FlowPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        textFieldMid = new TextField();
        textFieldMid.setMinWidth(20);
        textFieldMid.setPromptText("MID");
        textFieldLab = new TextField();
        textFieldLab.setMinWidth(20);
        textFieldLab.setPromptText("LAB");
        textFieldFin = new TextField();
        textFieldFin.setMinWidth(20);
        textFieldFin.setPromptText("FINAL");

        radioButtonIt = new RadioButton("IT");
        radioButtonIt.setSelected(true);
        radioButtonEng = new RadioButton("Eng");
        radioButtonArt = new RadioButton("Art");
        ToggleGroup toggleGroup = new ToggleGroup();
        radioButtonIt.setToggleGroup(toggleGroup);
        radioButtonEng.setToggleGroup(toggleGroup);
        radioButtonArt.setToggleGroup(toggleGroup);
        VBox vBox1 = new VBox();
        vBox1.setSpacing(10);
        vBox1.setAlignment(Pos.BASELINE_LEFT);
        vBox1.getChildren().addAll(textFieldMid, textFieldLab, textFieldFin,
                radioButtonIt, radioButtonEng, radioButtonArt);

        buttonShow = new Button("Show");
        buttonClear = new Button("Clear");
        HBox hBox1 = new HBox();
        hBox1.setSpacing(10);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(buttonShow, buttonClear);
        MyEventHandler myEventHandler = new MyEventHandler();
        radioButtonIt.setOnAction(myEventHandler);
        radioButtonEng.setOnAction(myEventHandler);
        radioButtonArt.setOnAction(myEventHandler);
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
        primaryStage.setScene(scene);
        primaryStage.setTitle("Strategy Design Pattern");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }

    private class MyEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            if (event.getSource() == buttonShow) {
                if (radioButtonIt.isSelected()) {
                    context = new Context(new ItStudent());
                } else if (radioButtonEng.isSelected()) {
                    context = new Context(new EngStudent());
                } else if (radioButtonArt.isSelected()) {
                    context = new Context(new ArtStudent());
                }

                textArea.appendText(
                        context.computeGrade(
                                Double.parseDouble(textFieldMid.getText()),
                                Double.parseDouble(textFieldLab.getText()),
                                Double.parseDouble(textFieldFin.getText()))
                        + "\n"
                );
            } else if (event.getSource() == buttonClear) {
                textArea.setText("");
            }
        }
    }
}
