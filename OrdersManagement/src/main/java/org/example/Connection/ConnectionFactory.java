package org.example.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

/**
 * Clasa singleton care va realiza conexiunea SQL
 */
public class ConnectionFactory {
    private static final Logger logger = Logger.getLogger(ConnectionFactory.class.getName());
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String dburl = "jdbc:mysql://localhost:3306/ordersManagement";
    private static final String user = "root";
    private static final String pass = "135790";

    private static final ConnectionFactory singleInstance = new ConnectionFactory();

    public ConnectionFactory(){
        try {
            Class.forName(driver);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
    }

    private Connection createConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dburl, user, pass);
        }catch(Exception e) {
            System.out.println(e);
        }
        return connection;
    }

    public static Connection getConnection()
    {
        return singleInstance.createConnection();
    }

/*    public static void close(Connection connection)
    {
        try {
            connection.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void close(Statement statement)
    {
        try {
            statement.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void close(ResultSet resultSet)
    {
        try {
            resultSet.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }*/
}
