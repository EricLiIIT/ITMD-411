import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class LoanProcessing extends BankRecords{
  public static void main(String[] args) {

      BankRecords br = new BankRecords();
      br.readData();
      Dao dao = new Dao();
      dao.createTable();
      dao.insertRecords(bank_records); // perform inserts
      ResultSet rs = dao.retrieveRecords(); // fill result set object

      // Create heading for display
      System.out.println("Id: \t" + "Income: \t" + "PEP: \t");

      // Extract data from result set
      try {
        while (rs.next()) {
        // Retrieve data by column name (i.e., for id,income,pep)
          String id = rs.getString(2);
          double income = rs.getDouble(3);
          String pep = rs.getString(4);
        // Display values for id,income,pep
          System.out.println(id + income + pep);
          rs.close(); // closes result set object
        }
      } catch(SQLException e) {
        e.printStackTrace();
      }
  }
}

