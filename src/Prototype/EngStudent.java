/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prototype;

/**
 *
 * @author aashgar
 */
public class EngStudent extends Student{

    public EngStudent(String id, String name) {
        super(id, name);
        this.type = "ENG";
    }
    
    @Override
    public String show() {
        return this.getType() +" - "+
                this.getId() +" - " + this.getName();
    }
}
