package in.bloomapptest.util;



import java.sql.Connection;

import in.bloomapp.util.ConnectionUtil;

public class ConnectionUtilTest {

		public static void main(String[] args) {

			Connection connection = ConnectionUtil.getConnection();
			System.out.println(connection);
		}
	}


 