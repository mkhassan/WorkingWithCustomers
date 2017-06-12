import java.io.InputStream;
import java.util.Scanner;

public class Customer {
	
	private String title;
	private String firstname;
	private String lastname;
	private String city;
	private String state;
	private String email;
	private String position;
	private String companyid;
	private String customerid;
	
	
	public Customer() {
	
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Enter your last name");
		
		String lastName = kb.nextLine();
		this.lastname = lastName;
		
	}

	



	public String getTitle() {
		return title;
	}





	public void setTitle(String title) {
		this.title = title;
	}





	public String getFirstname() {
		return firstname;
	}





	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}





	public String getLastname() {
		return lastname;
	}





	public void setLastname(String lastname) {
		this.lastname = lastname;
	}





	public String getCity() {
		return city;
	}





	public void setCity(String city) {
		this.city = city;
	}





	public String getState() {
		return state;
	}





	public void setState(String state) {
		this.state = state;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getPosition() {
		return position;
	}





	public void setPosition(String position) {
		this.position = position;
	}





	public String getCompanyid() {
		return companyid;
	}





	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}





	public String getCustomerid() {
		return customerid;
	}





	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}





	public Customer(String title, String firstname, String lastname, String city, String state, String email,
			String position, String companyid, String customerid) {
		super();
		this.title = title;
		this.firstname = firstname;
		this.lastname = lastname;
		this.city = city;
		this.state = state;
		this.email = email;
		this.position = position;
		this.companyid = companyid;
		this.customerid = customerid;
	}

}

