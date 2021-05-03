package sample.DB;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import java.sql.*;

public class DBUtil {
    private static String DB_URL = "jdbc:mysql://localhost:3306/quanlythuvien";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";
    private static Connection connection = null;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ResultSet rs = dbExecuteQuery("select * from book");
        if(rs != null) {
            while (rs.next()) {
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  "
                                 + rs.getString(3) + "  " + rs.getInt(4) + "  "
                                 + rs.getString(5) + "  " + rs.getDate(6)+ "  "
                                 + rs.getInt(7)+ "  " + rs.getInt(8) + "  " + rs.getInt(9));
            }
        } else {
            System.out.println("rs bi null. Xem lai dbExecuteQuery");
        }
    }

    public static void dbDisconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public static void dbConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
    }

    public static ResultSet dbExecuteQuery(String query) throws SQLException {
        Statement stmt = null;
        ResultSet resultSet = null;
        CachedRowSet cachedRowSet;
        try {
            dbConnect();
            
            System.out.println("Select statement: " + query + "\n");
            stmt = connection.createStatement();
            
            resultSet = stmt.executeQuery(query);
            RowSetFactory factory = RowSetProvider.newFactory();
            cachedRowSet = factory.createCachedRowSet();
            cachedRowSet.populate(resultSet);
        } catch (SQLException e) {
            System.out.println("Xay ra su co voi executeQuery : " + e);
            throw e;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            dbDisconnect();
        }
        return cachedRowSet;
    }

    public static void dbExecuteUpdate(String sqlStmt) throws SQLException,ClassCastException {
        Statement stmt = null;
        try {
            dbConnect();

            stmt = connection.createStatement();
            stmt.executeUpdate(sqlStmt);
        } catch (SQLException e) {
            System.out.println("Xay ra su co voi executeQuery : " + e);
            throw e;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            dbDisconnect();
        }
    }
}
