/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

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
    private Button buttonShow, buttonClear;
    private TextField textFieldName, textFieldMajor, textFieldGrade;
    private TextArea textAreaView1, textAreaView2;
    @Override
    public void start(Stage primaryStage) throws Exception {
        FlowPane pane = new FlowPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);        
        textFieldName = new TextField();
        textFieldName.setMinWidth(20);
        textFieldName.setPromptText("Name");
        textFieldMajor = new TextField();
        textFieldMajor.setMinWidth(20);
        textFieldMajor.setPromptText("Major");
        textFieldGrade = new TextField();
        textFieldGrade.setMinWidth(20);
        textFieldGrade.setPromptText("Grade");
        VBox vBox1 = new VBox();
        vBox1.setSpacing(10);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.getChildren().addAll(textFieldName, textFieldMajor, textFieldGrade);
        
        buttonShow = new Button("View");
        buttonClear = new Button("Clear");
        HBox hBox1 = new HBox();
        hBox1.setSpacing(10);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(buttonShow, buttonClear);
        MyEventHandler myEventHandler = new MyEventHandler();
        buttonShow.setOnAction(myEventHandler);
        buttonClear.setOnAction(myEventHandler);
        textAreaView1 = new TextArea();
        textAreaView1.setMaxWidth(300);
        textAreaView1.setMaxHeight(150);
        textAreaView1.setPromptText("View 1");
        textAreaView2 = new TextArea();
        textAreaView2.setMaxWidth(300);
        textAreaView2.setMaxHeight(150);
        textAreaView2.setPromptText("View 2");
        VBox vBox2 = new VBox();
        vBox2.setSpacing(10);
        vBox2.setAlignment(Pos.CENTER);        
        vBox2.getChildren().addAll(textAreaView1, textAreaView2, hBox1);
        
        pane.getChildren().addAll(vBox1,vBox2);        
        Scene scene = new Scene(pane, 550,400);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("MVC Design Pattern");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
        
    }
    private class MyEventHandler implements EventHandler<ActionEvent>{
        
        @Override
        public void handle(ActionEvent event) {
            if(event.getSource() == buttonShow){
                Model model = new Model();
                model.setName(textFieldName.getText());
                model.setMajor(textFieldMajor.getText());
                model.setGrade(Double.parseDouble
                            (textFieldGrade.getText()));
                Controller controller = new 
                    Controller(model, new View1());
                textAreaView1.setText(controller.updateView());
                controller.setView(new View2());
                textAreaView2.setText(controller.updateView());
              
            }
            else if(event.getSource() == buttonClear){
               
            }
        }        
    }    
}
