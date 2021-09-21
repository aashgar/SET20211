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
public abstract class Student implements Cloneable{
    private String id;
    private String name;
    protected String type;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
    public abstract String show();

    @Override
    protected Object clone()  {
    Object clone = null;
    try{
        clone = super.clone();
    }
    catch(CloneNotSupportedException e){
        e.printStackTrace();
    }
    return clone;
    }
    
}
