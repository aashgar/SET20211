/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prototype;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author aashgar
 */
public class StudentChache {
    private static Map<String, Student> 
            studentMap = new HashMap<>();
    public static void addStudent(String id, 
            String name, String type){
        if(type.equalsIgnoreCase("it"))
            studentMap.put(id, new ItStudent(id, name));
        else if(type.equalsIgnoreCase("eng"))
            studentMap.put(id, new EngStudent(id, name));
        else if(type.equalsIgnoreCase("art"))
            studentMap.put(id, new ArtStudent(id, name));
    }
    public static Student getStudent(String id){
        Student student = studentMap.get(id);
        return (Student) student.clone();
    }
}
