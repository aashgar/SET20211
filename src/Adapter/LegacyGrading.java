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
public class LegacyGrading {
    public int legCalcGrade(int mid, int lab, int fin){
        return mid*30/100 + lab*20/100 + fin*50/100;
    }
}
