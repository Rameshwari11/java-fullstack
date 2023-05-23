package com.cgi.service;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cgi.dao.impl.OrderDaoImpl;
import com.cgi.model.Orders;

@Component("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDaoImpl orderDaoImpl;

	@Override
	public Orders createOrder(Orders orders) throws SQLException {
		return orderDaoImpl.createOrder(orders);
	}

	@Override
	public List<Orders> getAllOrders() throws SQLException {
		return orderDaoImpl.getAllOrders();
	}

	@Override
	public Orders findOrderById(int orderId) throws SQLException {
		return orderDaoImpl.findOrderById(orderId);
	}

	@Override
	public int findMaxOrderedValue() throws SQLException {
		return orderDaoImpl.findMaxOrderedValue();
	}

	@Override
	public int findMinOrderedValue() throws SQLException {
		return orderDaoImpl.findMinOrderedValue();
	}

	@Override
	public void deleteAllOrders() throws SQLException {
		orderDaoImpl.deleteAllOrders();

	}

	@Override
	public void deleteOrderById(int orderId) throws SQLException {
		orderDaoImpl.deleteOrderById(orderId);
	}

	@Override
	public void updateOrderByOrderName(String orderName,int orderPrice) throws SQLException {
		orderDaoImpl.updateOrderByOrderName(orderName,orderPrice);

	}

	/*@Override
	public void updateOrderByPrice() throws SQLException {
		orderDaoImpl.updateOrderByPrice();

	}*/

}