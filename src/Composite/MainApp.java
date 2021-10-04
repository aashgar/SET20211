/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Composite;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
    private Label label;
    private TextArea textArea;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FlowPane pane = new FlowPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        label = new Label("Composite DP  ");
        VBox vBox1 = new VBox();
        vBox1.setSpacing(10);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.getChildren().addAll(label);

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
        vBox2.getChildren().addAll(textArea, hBox1);

        pane.getChildren().addAll(vBox1, vBox2);
        Scene scene = new Scene(pane, 550, 300);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Composite Design Pattern");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }

    private class MyEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == buttonShow) {
                Employee Ceo = new Employee(111, "Ahmad", "CEO", 2400);

                Employee salesManager = new Employee(222, "Sami", "Head Sales", 2000);
                Employee sales1 = new Employee(333, "Huda", "Sales", 1800);
                Employee sales2 = new Employee(444, "Maher", "Sales", 1880);
                salesManager.addEmployee(sales1);
                salesManager.addEmployee(sales2);
                Ceo.addEmployee(salesManager);

                Employee marketingManager = new Employee(555, "Hamada", "Head Marketing", 2100);
                Employee marketing1 = new Employee(666, "Ali", "Marketing", 1950);
                Employee marketing2 = new Employee(777, "Mohammed", "Marketing", 1920);
                marketingManager.addEmployee(marketing1);
                marketingManager.addEmployee(marketing2);
                Ceo.addEmployee(marketingManager);

                textArea.appendText(Ceo + "\n");
                Ceo.getSubordinates()
                        .stream()
                        .forEach(manager -> {
                            textArea.appendText(manager + "\n");
                            manager.getSubordinates()
                                    .stream()
                                    .forEach(employee
                                            -> textArea.appendText(employee + "\n"));
                        });  
          
                
            } else if (event.getSource() == buttonClear) {
                textArea.setText("");
            }
        }
    }
}
