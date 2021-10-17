/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visitor;

import java.util.Locale;

/**
 *
 * @author aashgar
 */
public class OrderitemVisitor2 implements OrderItemVisitor{

    @Override
    public String visit(Bread bread) {
        return "Bread".toUpperCase();
    }

    @Override
    public String visit(Cheese cheese) {
        return "Cheese".toUpperCase();
    }

    @Override
    public String visit(Tea tea) {
        return "Tead".toUpperCase();
    }

    @Override
    public String visit(Order order) {
        return "Order".toUpperCase();
    }
}
