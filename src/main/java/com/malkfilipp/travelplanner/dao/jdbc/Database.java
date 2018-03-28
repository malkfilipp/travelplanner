package com.malkfilipp.travelplanner.dao.jdbc;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    private static DataSource travelDatabase;

    static {
        try {
            InitialContext initContext = new InitialContext();
            travelDatabase = (DataSource)
                    initContext.lookup("java:comp/env/jdbc/TravelDatabase");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;

        try {
            conn = travelDatabase.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
