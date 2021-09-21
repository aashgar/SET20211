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
public class ArtStudent extends Student{

    public ArtStudent(String id, String name) {
        super(id, name);
        this.type = "ART";
    }
    
    @Override
    public String show() {
        return this.getType() +" - "+
                this.getId() +" - " + this.getName();
    }
}
