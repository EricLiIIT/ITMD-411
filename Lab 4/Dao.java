import java.sql.SQLException;
import java.sql.*;
public class Dao {

DbConnect conn = null;
Statement stmt = null;

public Dao() { //create db object instance
  conn = new DbConnect();
}
public void createTable() {
try {
// Open a connection
System.out.println("Connecting to a selected database to create Table...");
System.out.println("Connected database successfully...");

// Execute create query
System.out.println("Creating table in given database...");

stmt = conn.connect().createStatement();

String sql = "CREATE TABLE yourTableName_tab " +
            "(pid INTEGER not NULL AUTO_INCREMENT, " +
          " id VARCHAR(10), " +
    " income numeric(8,2), " +
    " pep VARCHAR(4), " +
  " PRIMARY KEY ( pid ))";

stmt.executeUpdate(sql);
System.out.println("Created table in given database...");
conn.connect().close(); //close db connection
} catch (SQLException se) {
// Handle errors for JDBC
se.printStackTrace();
}
}
// INSERT INTO METHOD
public void insertRecords(BankRecords[] bank_records) {
  try {
  // Execute a query
  System.out.println("Inserting records into the table...");
  stmt = conn.connect().createStatement();
  String sql = null;

// Include all object data to the database table
for (int i = 0; i < bank_records.length; ++i) {

// finish string assignment to insert all object data
// (id, income, pep) into your database table

sql = "INSERT INTO E_Li_tab(Id, Income, Pep)" + "Values ('" +bank_records[i].getId()+"','" +bank_records[i].getIncome()+ "' ,'" +bank_records[i].getPep()+"')";

stmt.executeUpdate(sql);
  }
  conn.connect().close();
  } catch (SQLException se) { se.printStackTrace(); }
}

public ResultSet retrieveRecords() {
  ResultSet rs = null;

  try {
  stmt = conn.connect().createStatement();
  } catch (SQLException e) {
    e.printStackTrace();
  }
  String sql = "SELECT * from  E_Li_tab";
  try {
  rs = stmt.executeQuery(sql);
  } catch (SQLException e) {
    e.printStackTrace();
  }
  try {
  conn.connect().close();
  }
  catch (SQLException e) {
    e.printStackTrace();
  }
  return rs;
}
}


