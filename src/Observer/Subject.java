/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aashgar
 */
public class Subject {
    private List<Observer> observers =
            new ArrayList<Observer>();
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
        notifyAllObsevers();
    }
    public void attach(Observer observer){
        observers.add(observer);
    }
    public void notifyAllObsevers(){
        for(Observer o: observers){
            o.update();
        }
    }
}
