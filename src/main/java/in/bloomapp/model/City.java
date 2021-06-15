package in.bloomapp.model;

/**
 * Defines eligible fields for city
 * @author chri2631
 *
 */
public class City {
	String city;
	int districtCode;
	int delivaryCharge;
	int status=1;

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(int districtCode) {
		this.districtCode = districtCode;
	}
	public int getDelivaryCharge() {
		return delivaryCharge;
	}
	public void setDelivaryCharge(int delivaryCharge) {
		this.delivaryCharge = delivaryCharge;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "City [city=" + city + ", districtCode=" + districtCode + ", delivaryCharge=" + delivaryCharge
				+ ", status=" + status + "]";
	}
}
