package in.bloomapp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;
import in.bloomapp.dao1.OrderSummaryDAO;
import in.bloomapp.exception.DBException;
import in.bloomapp.exception.ServiceException;
import in.bloomapp.model.Flower;
import in.bloomapp.model.Order;

public class SummaryManager {

	private SummaryManager() {}
	
	/**
	 * Gets the total orders for the date respective of the flowers
	 * @param summaryDate
	 * @return
	 * @throws ServiceException
	 */
	public static List<Flower> orderSummary(LocalDate summaryDate) throws ServiceException {
		List<Flower> summary=null;
		OrderSummaryDAO orderSummaryDAO=new OrderSummaryDAO();
		try {
			summary=orderSummaryDAO.getflowersOrdered(summaryDate);
		}catch (DBException e) {
			throw new ServiceException("Database not responding");
		}
		return summary;
	}
	
	/**
	 * Gets the orders which is to be delivered 
	 * @return
	 * @throws ServiceException
	 */
	public static List<Order> getOrders() throws ServiceException {
		List<Order> deliveryList=null;
		OrderSummaryDAO orderSummaryDAO=new OrderSummaryDAO();
		try {
			deliveryList =orderSummaryDAO.getOrderList();
		} catch (DBException e) {
			throw new ServiceException("Database not responding");
		}
		return deliveryList;
	}
	
	/**
	 * Gets order summary for a user this method is for user
	 * @param userName
	 * @return
	 */
	public static List<Order> getOrderSummary(String userName) {
		List<Order> orderSummary=null;
		OrderSummaryDAO orderSummaryDAO=new OrderSummaryDAO();
		try {
			orderSummary =orderSummaryDAO.getUserOrder(userName);
		} catch (DBException e) {
			e.printStackTrace();
		}
		return orderSummary;	
	}
	
	/**
	 * gets ordered items
	 * @param userName
	 * @return
	 */
	public static List<Order> getOrderList(String userName){
		
		List<Order> orderList=null;
		OrderSummaryDAO orderSummaryDAO=new OrderSummaryDAO();
		try {
			orderList =orderSummaryDAO.getOrderItems(userName);
		} catch (DBException e) {
			e.printStackTrace();
		}
		return orderList;
		
	}
}