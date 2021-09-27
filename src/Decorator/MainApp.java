/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

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
    private Button buttonAdd, buttonShow, buttonClear;
    private TextField textFieldStudent, textFieldCource;
    private TextArea textArea;
    private Program course=null;
    @Override
    public void start(Stage primaryStage) throws Exception {
        FlowPane pane = new FlowPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);        
        textFieldStudent = new TextField();
        textFieldStudent.setMinWidth(20);
        textFieldStudent.setPromptText("Student");
        textFieldCource = new TextField();
        textFieldCource.setMinWidth(20);
        textFieldCource.setPromptText("Course");       
        VBox vBox1 = new VBox();
        vBox1.setSpacing(10);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.getChildren().addAll(textFieldStudent, textFieldCource);
        
        buttonAdd = new Button("Add");
        buttonShow = new Button("Show");
        buttonClear = new Button("Clear");
        HBox hBox1 = new HBox();
        hBox1.setSpacing(10);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(buttonAdd,buttonShow, buttonClear);
        MyEventHandler myEventHandler = new MyEventHandler();
        buttonAdd.setOnAction(myEventHandler);
        buttonShow.setOnAction(myEventHandler);
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
        primaryStage.setTitle("Decorator Design Pattern");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
        
    }
    private class MyEventHandler implements EventHandler<ActionEvent>{
        
        @Override
        public void handle(ActionEvent event) {
            if(event.getSource() == buttonAdd){               
               if(course == null){
                   course = new SECourse();
                   course.addProgram(
                           new Student(textFieldStudent.getText()));
               }
               else{
                   if(textFieldCource.getText()
                           .equalsIgnoreCase("se")){
                       Program newCourse = new SECourse();
                       newCourse.addProgram(course);
                       course = newCourse;
                   }
                   else if(textFieldCource.getText()
                           .equalsIgnoreCase("db")){
                       Program newCourse = new DBCourse();
                       newCourse.addProgram(course);
                       course = newCourse;
                   }
                   else if(textFieldCource.getText()
                           .equalsIgnoreCase("prog")){
                       Program newCourse = new PROGCourse();
                       newCourse.addProgram(course);
                       course = newCourse;
                   }
               }
               textFieldCource.setText("");
            }
            else if(event.getSource() == buttonShow){
                textArea.setText(course.Show());
            }
            else if(event.getSource() == buttonClear){
               textArea.setText("");
               course = null;
            }
        }        
    }    
}
