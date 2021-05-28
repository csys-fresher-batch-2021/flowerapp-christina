package in.bloomapptest.util;



import static org.junit.Assert.fail;
import in.bloomapp.exception.DBException;
import in.bloomapp.util.ConnectionUtil;

public class ConnectionUtilTest {

		public static void main(String[] args) {

			try {
				ConnectionUtil.getConnection();
			} catch (DBException e) {
				fail();
			}
		}
	}


 