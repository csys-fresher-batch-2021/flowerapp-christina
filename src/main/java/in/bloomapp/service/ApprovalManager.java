package in.bloomapp.service;

import in.bloomapp.dao1.ApprovalManagerDAO;
import in.bloomapp.exception.DBException;
import in.bloomapp.model.Order;

public class ApprovalManager {

	private ApprovalManager() {
	}

	/**
	 * This changes manages the approval status of an order
	 * @param order
	 * @throws DBException
	 */
	public static void setApprovalSts(Order order) throws DBException {
		ApprovalManagerDAO ApproveManagerDAO=new ApprovalManagerDAO(); 
		ApproveManagerDAO.UpdateApprovalSts(order);
	}
}
