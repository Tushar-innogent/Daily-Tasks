package entities;

public class Address {

	private int address_id;
	private long pin_Code;
	private String city;
	private int student_id;
	
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public long getPin_Code() {
		return pin_Code;
	}
	public void setPin_Code(long pin_Code) {
		this.pin_Code = pin_Code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	
	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", pin_Code=" + pin_Code + ", city=" + city + ", student_id="
				+ student_id + "]";
	}
	
	
}
