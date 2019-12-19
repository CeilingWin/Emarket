/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Order;

/**
 *
 * @author Admin
 */
public interface OrderDAO {
    
    // xem danh sach hang order
    public List<Order> getOrder();
    
    // duyet don hang
    public void updateOrder(int id_order, int x);
    
    // them danh muc hang
    public void addOrder(Order o);
}
