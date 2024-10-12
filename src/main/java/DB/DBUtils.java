package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static String url="jdbc:postgresql://localhost:5432/football";
    private static String user="postgres";
    private static String password="1234";

    public static Connection getConnection()
    {
        Connection connection=null;
        try
        {
            connection=DriverManager.getConnection(url, user, password);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
       return connection;
    }
}
