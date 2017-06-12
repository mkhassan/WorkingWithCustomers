



public class CustomerApp {

    public static void main(String[] args) throws Exception {
    	
    	// notice how the main method only calls the class
    	// and the class does all the work. This is a good design.
    	
    	Customer customer = new Customer();
    	
        MySQLHelper db = new MySQLHelper();
        
        db.readDataBase(customer);
    }
	

}
