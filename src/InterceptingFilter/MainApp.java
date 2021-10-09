/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterceptingFilter;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
    private TextField textFieldRequest;
    private CheckBox checkBoxAuth, checkBoxDebug;
    private TextArea textArea;
    @Override
    public void start(Stage primaryStage) throws Exception {
        FlowPane pane = new FlowPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);        
        textFieldRequest = new TextField();
        textFieldRequest.setMinWidth(20);
        textFieldRequest.setPromptText("Request");
        checkBoxAuth = new CheckBox("Authentication");
        checkBoxDebug = new CheckBox("Debug");
        VBox vBox1 = new VBox();
        vBox1.setSpacing(10);
        vBox1.setAlignment(Pos.BASELINE_LEFT);
        vBox1.getChildren().addAll(textFieldRequest, checkBoxAuth, checkBoxDebug);
        
        buttonShow = new Button("Show");
        buttonClear = new Button("Clear");
        HBox hBox1 = new HBox();
        hBox1.setSpacing(10);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(buttonShow, buttonClear);
        MyEventHandler myEventHandler = new MyEventHandler();
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
        primaryStage.setTitle("Intercepting Filter Design Pattern");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
        
    }
    private class MyEventHandler implements EventHandler<ActionEvent>{
        
        @Override
        public void handle(ActionEvent event) {
            if(event.getSource() == buttonShow){
               FilterManager filterManager = new
                    FilterManager(new Target());
               if(checkBoxAuth.isSelected())
               {
                   filterManager.setFilter(new AuthenticationFilter());
               }
               if(checkBoxDebug.isSelected())
               {
                   filterManager.setFilter(new DebugFilter());
               }
               Client client = new Client(filterManager);
               textArea.setText(
               client.sendRequest(textFieldRequest.getText()));
            }
            else if(event.getSource() == buttonClear){
                textArea.setText("");
            }
        }        
    }    
}
