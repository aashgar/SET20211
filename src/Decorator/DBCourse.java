/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

/**
 *
 * @author aashgar
 */
public class DBCourse extends Course{
   
    @Override
    public void addProgram(Program program) {
        super.addProgram(program);
    }
    
     @Override
    public String Show() {
        return super.Show() + "\nDB Course";  
    }

}
