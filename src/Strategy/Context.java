/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

/**
 *
 * @author aashgar
 */
public class Context {
    private Student student;

    public Context(Student student) {
        this.student = student;
    }
    public double computeGrade(double mid, double lab, double fin){
        return this.student.calcGrade(mid, lab, fin);
    }
}
