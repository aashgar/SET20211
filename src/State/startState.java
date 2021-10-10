/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

/**
 *
 * @author aashgar
 */
public class startState implements State{

    @Override
    public String doAction(Context context) {
        context.setState(this);
        return "Processing Start State ...";
    }

    @Override
    public String toString() {
        return "Start State";
    }
    
    
}
