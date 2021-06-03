package in.bloomapp.model;

/**
 * Main model class with required field for an user
 * @author chri2631
 *
 */
public class User {
	
	private String name;
	private String password; 
	private String email;
	private Long mobileNo;
	private String address;
	
	@SuppressWarnings("unused")
	private User(){
		
	}
	/**
	 *  Getter method for the field name(userName)
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 *  Getter method for the field password
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 *  Getter method for the field email
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 *  Getter method for the field mobile number
	 * @return
	 */
	public Long getMobileNo() {
		return mobileNo;
	}

	/**
	 *  Getter method for the field address
	 * @return
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Construct class for the main model class
	 * @param category
	 * @param type
	 * @param price
	 */
	public User(String name, String password, String email, Long mobileNo, String address) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.mobileNo = mobileNo;
		this.address = address;
	
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", mobileNo=" + mobileNo
				+ ", address=" + address + "]";
	}


}
