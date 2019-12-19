package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnect {

    public static Connection getConnecttion()  {
        Connection conn = null;
       try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dbURL = "jdbc:sqlserver://CEILINGWIN;" +
                        "databaseName=cnpm;user=sa;password=12345678";
                conn = DriverManager.getConnection(dbURL);
                if(conn != null){
                    System.out.println("ket noi thanh cong!");
                }
                else
                    System.out.println("ket noi that bai!");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }catch (SQLException e) {
                e.printStackTrace();
            }
       return conn;
    }


}
