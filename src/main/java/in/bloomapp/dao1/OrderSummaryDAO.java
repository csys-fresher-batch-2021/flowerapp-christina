package in.bloomapp.dao1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import in.bloomapp.exception.DBException;
import in.bloomapp.model.Flower;
import in.bloomapp.model.Order;
import in.bloomapp.util.ConnectionUtil;

public class OrderSummaryDAO {
	
	//jdbc template which helps in giving and closing connections
	private static JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	/**
	 * This methods gets the total flowers that was ordered for the given date
	 * @param summaryDate
	 * @return
	 * @throws DBException
	 */
	public List<Flower> getflowersOrdered(LocalDate summaryDate) throws DBException {
		Connection connection=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<Flower> summary=new ArrayList<>();
		try {
			connection =ConnectionUtil.getConnection();			
			String sql="select flowersdata.category AS flower_category, flowersdata.name AS type , sum(orders.quantity) AS total from orders"
					+ " left Join flowersdata on orders.flower_id =flowersdata.id  Where order_date=?"
					+ " group by flowersdata.category ,flowersdata.name order by total";		
			pst=connection.prepareStatement(sql);	
			pst.setObject(1,summaryDate);
			rs = pst.executeQuery();
			while(rs.next()){
				Flower flower =new Flower();
				flower.setCategory(rs.getString("flower_category"));
				System.out.println("sql");
				flower.setType(rs.getString("type") );
				flower.setQuantity(rs.getInt("total") );
				summary.add(flower);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to get summary list");
		}
		finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return summary;
	}
	
	/**
	 * Gets the order list that is not yet delivered
	 * @return
	 * @throws DBException
	 */
	public List<Order> getOrderList() throws DBException {
		List<Order> orders=new ArrayList<>();
		Connection connection=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			connection=ConnectionUtil.getConnection();
		
			String sql="select category,name,quantity,price,delivery_city,delivery_address,"
					+ "deliver_date,delivery_time,user_name,mobile_no,"
					+ "order_date from orders WHERE delivery_status='yetToDeliver' AND status=1";
			pst=connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
			Order subject=new Order();
			subject.setOrderCategory(rs.getString("category")); 
			subject.setOrderType(rs.getString("name"));
			subject.setOrderPrice(rs.getInt("price"));
			subject.setOrderQuantity(rs.getInt("quantity"));
			subject.setDeliveryCity(rs.getString("delivery_city"));
			subject.setDeliverAddress(rs.getString("delivery_address"));
			subject.setDeliveryDate(LocalDate.parse(rs.getString("deliver_date")));
			Time deliveryTime=(rs.getTime("delivery_time"));
			String time=deliveryTime.toString();
			LocalTime parsedTime=LocalTime.parse(time);
			subject.setDeliveryTime(parsedTime);
			subject.setUserName(rs.getString("user_name"));
			subject.setUserMobileNo(rs.getLong("mobile_no"));
			subject.setOrderDate(LocalDate.parse(rs.getString("order_date")));
			orders.add(subject);
			}
		}
		catch(SQLException e) {
			throw new DBException("unable to get order list");
		}
		finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return orders;
	}
	
	/**
	 * 
	 * @param userName
	 * @return
	 * @throws DBException
	 */
	public List<Order> getUserOrder(String userName) throws DBException {
		List<Order> orders=null;
		try {
			String sql="select delivery_city,delivery_address,deliver_date,delivery_time,user_name"
					+ ",mobile_no,order_date ,sum(quantity) AS total_flowers, SUM(price) AS total_sum "
					+ "from orders WHERE user_name=? AND delivery_status='yetToDeliver' AND"
					+ " status=1 group by delivery_city,delivery_address,deliver_date,delivery_time,"
					+ "user_name,mobile_no,order_date" ;
			
			//fields that is to be passed to the query are given as parameter
			Object[] params= {userName};
			//And the returned data is stored in a variable
			orders = jdbcTemplate.query(sql, (rs,rowNo)->{
			Order subject=new Order();
			subject.setDeliveryCity(rs.getString("delivery_city"));
			subject.setDeliverAddress(rs.getString("delivery_address"));
			subject.setDeliveryDate(LocalDate.parse(rs.getString("deliver_date")));
			Time deliveryTime=(rs.getTime("delivery_time"));
			String time=deliveryTime.toString();
			LocalTime parsedTime=LocalTime.parse(time);
			subject.setDeliveryTime(parsedTime);
			subject.setUserName(rs.getString("user_name"));
			subject.setUserMobileNo(rs.getLong("mobile_no"));
			subject.setOrderDate(LocalDate.parse(rs.getString("order_date")));
			subject.setOrderQuantity(rs.getInt("total_flowers"));
			subject.setOrderPrice(rs.getInt("total_sum"));
			return subject;
			}, params);
			}
		catch(DataAccessException e) {
			throw new DBException("unable to get user order list");
		}
		return orders;
	}
	
	/**
	 * Gets the order of the particular user that is shown as order summary
	 * @param userName
	 * @return
	 * @throws DBException
	 */
	public List<Order> getOrderItems(String userName) throws DBException {
		
		List<Order> orders=null;
		try {
			String sql="select category,name,price,quantity,delivery_city,delivery_address,deliver_date,delivery_time,user_name"
					+ ",mobile_no,order_date ,sum(quantity) AS total_flowers, SUM(price) AS total_sum"
					+ "	from orders WHERE user_name=? AND delivery_status='yetToDeliver' AND"
					+ "	status=1 group by category,name,price,quantity,delivery_city,delivery_address,deliver_date,delivery_time,"
					+ "user_name,mobile_no,order_date";

			//fields that is to be passed to the query are given as parameter
			Object[] params= {userName};
			//And the returned data is stored in a variable
			orders = jdbcTemplate.query(sql, (rs,rowNo)->{
			Order subject=new Order();
			subject.setOrderCategory(rs.getString("category"));
			subject.setOrderType(rs.getString("name"));
			subject.setOrderPrice(rs.getInt("price"));
			subject.setOrderQuantity(rs.getInt("quantity"));
			subject.setDeliveryCity(rs.getString("delivery_city"));
			subject.setDeliverAddress(rs.getString("delivery_address"));
			subject.setDeliveryDate(LocalDate.parse(rs.getString("deliver_date")));
			Time deliveryTime=(rs.getTime("delivery_time"));
			String time=deliveryTime.toString();
			LocalTime parsedTime=LocalTime.parse(time);
			subject.setDeliveryTime(parsedTime);
			subject.setUserName(rs.getString("user_name"));
			subject.setUserMobileNo(rs.getLong("mobile_no"));
			subject.setOrderDate(LocalDate.parse(rs.getString("order_date")));
			subject.setOrderQuantity(rs.getInt("total_flowers"));
			subject.setOrderPrice(rs.getInt("total_sum"));
			return subject;
			}, params);
			}
		catch(DataAccessException e) {
			throw new DBException("unable to get user order list");
		}
		return orders;
	}

}
