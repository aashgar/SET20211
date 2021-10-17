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
public class Order implements OrderItem{
    private OrderItem oreItems[];

    public Order() {
        oreItems = new OrderItem[] {new Bread(), new Cheese(),
                    new Tea()};
    }
    
    @Override
    public String accept(OrderItemVisitor orderItemVisitor) {
        String output ="";
        output+= orderItemVisitor.visit(this)+"\n";
        for(OrderItem orderItem: oreItems)
            output+= orderItem.accept(orderItemVisitor)+"\n";
        
        return output;
    }
    
}
