package com.cgi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.cgi.config.SpringConfig;
import com.cgi.service.OrderServiceImpl;
import com.cgi.service.UserServiceImpl;
import java.sql.SQLException;
import java.util.Scanner;
import com.cgi.model.Orders;

public class App {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		OrderServiceImpl ordersService = context.getBean("orderService", OrderServiceImpl.class);
		UserServiceImpl userService = context.getBean("userService", UserServiceImpl.class);
		System.out.println("Enter valid UserID and Password");

		if (validateUser(userService)) {
			openOrderManagement(ordersService);
		} else {
			System.out.println("Incorrect credentials. Maximum Attempts Over! Try again later !!");
		}
	}

	private static boolean validateUser(UserServiceImpl userService) throws SQLException {
		int maxCount = 3;

		boolean validUser = false;
		do {
			System.out.println("UserId: ");
			int userId = scanner.nextInt();

			System.out.println("Password: ");
			String password = scanner.next();
			validUser = userService.validateLogin(userId, password);
			if (!validUser) {
				maxCount--;
				System.out.println("Attempts left " + maxCount);
			} else {
				return true;
			}
		} while (maxCount != 0);

		return false;
	}

	private static void openOrderManagement(OrderServiceImpl ordersService) throws SQLException {
		int choice = 0;
		do {
			System.out.println("1. Create Order");
			System.out.println("2. View All Orders");
			System.out.println("3. Find Order By OrderId");
			System.out.println("4. Find Maximum OrderValue from All Orders");
			System.out.println("5. Find Minimum OrderValue from All Orders");
			System.out.println("6. Delete All Orders");
			System.out.println("7. Delete Order By OrderId");
			System.out.println("8. Update OrderPrice By OrderName");
			System.out.println("Enter any one of the above options.");

			choice = Integer.parseInt(scanner.next());

			switch (choice) {
			case 1:
				Orders createOrders = new Orders();
				System.out.print("Enter Order Id: ");
				createOrders.setOrderId(scanner.nextInt());
				System.out.print("Enter Order Name: ");
				createOrders.setOrderName(scanner.next());
				System.out.print("Enter Order Price: ");
				createOrders.setOrderPrice(scanner.nextInt());
				ordersService.createOrder(createOrders);
				System.out.print("Order is placed! ");
				break;

			case 2:
				System.out.println("Find All Available orders");
				System.out.println(ordersService.getAllOrders());
				break;

			case 3:
				System.out.println("Find Order By OrderId");
				int orderId = scanner.nextInt();
				Orders orderDetails = ordersService.findOrderById(orderId);
				if (orderDetails != null) {
					System.out.println("Order details for order id  " + orderId);
					System.out.println(orderDetails);
				} else {
					System.out.println("Matching Order Id Not Found !!");
				}
				break;

			case 4:
				System.out.println("Find Maximum OrderValue from All Order");
				int maxOrder = ordersService.findMaxOrderedValue();
				System.out.println("Maximum Order value is " + maxOrder);
				break;

			case 5:
				System.out.println("Find Minimum OrderValue from All Order");
				int minOrder = ordersService.findMinOrderedValue();
				System.out.println("Minimum Order value is " + minOrder);
				break;

			case 6:
				System.out.println("Delete All Order");
				ordersService.deleteAllOrders();
				break;

			case 7:
				System.out.println("Delete  Order by OrderId");
				int deleteId = scanner.nextInt();
				ordersService.deleteOrderById(deleteId);
				break;

			case 8:
				System.out.println("Enter OrderName");
				String orderName = scanner.next();
				System.out.println("Enter OrderPrice");
				int orderPrice = scanner.nextInt();
				ordersService.updateOrderByOrderName(orderName, orderPrice);
				;
				break;
			}
		} while (choice != 0);
	}

}
