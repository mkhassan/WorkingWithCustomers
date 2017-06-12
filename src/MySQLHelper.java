

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Date;

public class MySQLHelper {
	
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    


	public void readDataBase(Customer mycustomer) throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
        	// The MySQL driver is a JAR file that must be in the Build Path
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager.getConnection("jdbc:mysql://localhost/Customers?user=root&password=password");



            String qry = "SELECT CustomerID,Title,FirstName,LastName, StreetAddress,City,State,ZipCode,EmailAddress,Position, Company from Customers.customers WHERE customers.LastName = "+mycustomer.getLastname();
            preparedStatement = connect.prepareStatement(qry);
            
            resultSet = preparedStatement.executeQuery();
            writeResultSet(resultSet);

            // Remove again the insert comment
            preparedStatement = connect.prepareStatement("delete from feedback.comments where myuser= ? ; ");
            preparedStatement.setString(1, "Test");
            preparedStatement.executeUpdate();

            resultSet = statement.executeQuery("select * from feedback.comments");
            writeMetaData(resultSet);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String title = resultSet.getString("Title");
            String firstname = resultSet.getString("FirstName");
            String lastname = resultSet.getString("LastName");
            String streetaddress  = resultSet.getString("StreetAddress");
            String city = resultSet.getString("City");
            String state = resultSet.getString("State");
            String zipcode = resultSet.getString("ZipCode");
            String email = resultSet.getString("EmailAddress");
            String position = resultSet.getString("Position");
            String company = resultSet.getString("Company");
            String customerid = resultSet.getString("CustomerID");
            System.out.println("Customer Number: " + customerid);
            System.out.println(title +" "+firstname+" "+lastname);
            System.out.println(streetaddress);
            System.out.println(email);
            System.out.println(city+", "+state+" "+zipcode);
            System.out.println(position+" at "+company);
        }
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}
