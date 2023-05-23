package com.cgi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cgi.dao.OrderDao;
import com.cgi.model.Orders;

@Component("OrderDao")
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private DataSource dataSource;

	@Override
	public List<Orders> getAllOrders() throws SQLException {
		List<Orders> list = new ArrayList<Orders>();
		Connection connection = dataSource.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from orders");

		while (resultSet.next()) {
			Orders orders = new Orders();
			orders.setOrderId(resultSet.getInt(1));
			orders.setOrderName(resultSet.getString(2));
			orders.setOrderPrice(resultSet.getInt(3));
			list.add(orders);
		}

		return list;
	}

	@Override
	public Orders createOrder(Orders order) throws SQLException {

		Connection connection = dataSource.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into orders values(?,?,?)");
		preparedStatement.setInt(1, order.getOrderId());
		preparedStatement.setString(2, order.getOrderName());
		preparedStatement.setInt(3, order.getOrderPrice());
		preparedStatement.executeUpdate();

		return order;
	}

	@Override
	public Orders findOrderById(int orderId) throws SQLException {
		Connection connection = dataSource.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from orders where orderId=?");
		preparedStatement.setInt(1, orderId);
		ResultSet resultSet = preparedStatement.executeQuery();
		Orders result = null;
		while (resultSet.next()) {
			result = new Orders(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
		}
		return result;
	}

	@Override
	public int findMaxOrderedValue() throws SQLException {
		Connection connection = dataSource.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select Max(orderPrice) from orders");
		ResultSet resultSet = preparedStatement.executeQuery();
		int maxVal = 0;
		while (resultSet.next()) {
			maxVal = resultSet.getInt(1);
		}
		return maxVal;
	}

	@Override
	public int findMinOrderedValue() throws SQLException {
		Connection connection = dataSource.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select Min(orderPrice) from orders");
		ResultSet resultSet = preparedStatement.executeQuery();
		int minVal = 0;
		while (resultSet.next()) {
			minVal = resultSet.getInt(1);
		}
		return minVal;
	}

	@Override
	public void deleteAllOrders() throws SQLException {
		Connection connection = dataSource.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("truncate table orders");
		preparedStatement.executeUpdate();

	}

	@Override
	public void deleteOrderById(int orderId) throws SQLException {
		Connection connection = dataSource.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("delete from orders where orderId=?");
		preparedStatement.setInt(1, orderId);
		int result = preparedStatement.executeUpdate();
		if(result !=0) {
		System.out.println("OrderId deleted " +orderId);
		}
		else
		{
			System.out.println("No OrderId found to be deleted");
		}
	}

	@Override
	public void updateOrderByOrderName(String orderName, int orderPrice) throws SQLException {
		Connection connection = dataSource.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from orders where orderName='" + orderName + "' ");
		boolean isPresent = false;
		while (resultSet.next()) {
			Statement statement2 = connection.createStatement();
			statement2.execute("update assignmenttestdb.orders set orderPrice='" + orderPrice + "' where orderName='" + orderName + "' ");
			isPresent = true;
			System.out.println("OrderPrice updated " + orderPrice + " for given OrderName " +  orderName);
		}
		if (!isPresent) {
			System.out.println("OrderName not found");
		}
	}

}
