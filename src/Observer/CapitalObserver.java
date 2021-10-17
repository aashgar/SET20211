/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author aashgar
 */
public class CapitalObserver extends VBox implements Observer{
    private Subject subject;
    private TextField textField;
    
    public CapitalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
        textField = new TextField();
           textField.setPromptText("Capital Observer");
        Button button = new Button("Update");
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(textField, button);
        button.setOnAction(e->
            this.subject.setData(textField.getText())
        );
        
    }
    @Override
    public void update() {
        textField.setText(this.subject.getData().toUpperCase());
    }
    
}
