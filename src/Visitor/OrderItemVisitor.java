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
public interface OrderItemVisitor {
    public String visit(Bread bread);
    public String visit(Cheese cheese);
    public String visit(Tea tea);
    public String visit(Order order);
}
