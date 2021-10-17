/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visitor;

/**
 *
 * @author aashgar
 */
public class OrderItemVisitor1 implements OrderItemVisitor{

    @Override
    public String visit(Bread bread) {
        return "Bread";
    }

    @Override
    public String visit(Cheese cheese) {
        return "Cheese";
    }

    @Override
    public String visit(Tea tea) {
        return "Tead";
    }

    @Override
    public String visit(Order order) {
        return "Order";
    }
    
}
