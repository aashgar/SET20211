/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapter;

/**
 *
 * @author aashgar
 */
public class Grading extends GradingAdpater{
    private String type;

    public Grading(String type) {
        this.type = type;        
    }
    
    @Override
    public double calcGrade(double mid, double lab, double fin) {
        if(type.equalsIgnoreCase("legacy")){
            this.legacyGrading = new LegacyGrading();
            return this.legacyGrading
                    .legCalcGrade(
                        (int) Math.round(mid),
                        (int) Math.round(lab),
                        (int) Math.round(fin));
        }
        else 
            return mid*0.3 + lab*0.2 + fin*0.5;
    }
    
}
