/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author aashgar
 */
public class MainApp extends Application{
    private Button buttonCalc, buttonClear;
    private TextField textFieldType, textFieldMid, textFieldLab, textFieldFin;
    private TextArea textArea;
    @Override
    public void start(Stage primaryStage) throws Exception {
        FlowPane pane = new FlowPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);        
        textFieldType = new TextField();
        textFieldType.setMinWidth(20);
        textFieldType.setPromptText("Type");
        textFieldMid = new TextField();
        textFieldMid.setMinWidth(20);
        textFieldMid.setPromptText("Mid");
        textFieldLab = new TextField();
        textFieldLab.setMinWidth(20);
        textFieldLab.setPromptText("Lab");
        textFieldFin = new TextField();
        textFieldFin.setMinWidth(20);
        textFieldFin.setPromptText("Final");
        VBox vBox1 = new VBox();
        vBox1.setSpacing(10);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.getChildren().addAll(textFieldType, textFieldMid, textFieldLab, textFieldFin);
        
        buttonCalc = new Button("Calculate");
        buttonClear = new Button("Clear");
        HBox hBox1 = new HBox();
        hBox1.setSpacing(10);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(buttonCalc, buttonClear);
        MyEventHandler myEventHandler = new MyEventHandler();
        buttonCalc.setOnAction(myEventHandler);
        buttonClear.setOnAction(myEventHandler);
        textArea = new TextArea();
        textArea.setMaxWidth(300);
        VBox vBox2 = new VBox();
        vBox2.setSpacing(10);
        vBox2.setAlignment(Pos.CENTER);        
        vBox2.getChildren().addAll(textArea,hBox1);
        
        pane.getChildren().addAll(vBox1,vBox2);        
        Scene scene = new Scene(pane, 550,300);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Adapter Design Pattern");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
        
    }
    private class MyEventHandler implements EventHandler<ActionEvent>{
        
        @Override
        public void handle(ActionEvent event) {
            if(event.getSource() == buttonCalc){
             Grading grading = new Grading(textFieldType.getText());
             textArea.setText(
                   grading.calcGrade(
                     Double.parseDouble(textFieldMid.getText()),                     
                     Double.parseDouble(textFieldLab.getText()),                             
                     Double.parseDouble(textFieldFin.getText()))
             +""
             );
            
            
            }
            else if(event.getSource() == buttonClear){
                textArea.setText("");
            }
        }        
    }    
}
