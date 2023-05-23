package com.cgi.service;

import java.sql.SQLException;
import java.util.List;

import com.cgi.model.Orders;

public interface OrderService {

	public List<Orders> getAllOrders() throws SQLException;

	public Orders createOrder(Orders order) throws SQLException;

	public Orders findOrderById(int orderId) throws SQLException;

	public int findMaxOrderedValue() throws SQLException;

	public int findMinOrderedValue() throws SQLException;

	public void deleteAllOrders() throws SQLException;

	public void deleteOrderById(int orderId) throws SQLException;

	public void updateOrderByOrderName(String orderName, int orderPrice) throws SQLException;

	//public void updateOrderByPrice() throws SQLException;
}
