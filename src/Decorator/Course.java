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
public class Course implements Program{
    protected Program program;
    @Override
    public void addProgram(Program program) {
        this.program = program;
    }

    @Override
    public String Show() {
        return this.program.Show();
    }
    
}
