package com.janardhan.cronjob;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author janardhan randhi
 */
public class SqlConnection {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.134/mef", "mefadmin", "m3f@2k!6");
        //System.out.println("connection----" + connection);
        return connection;
    }
}
