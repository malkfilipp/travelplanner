package com.malkfilipp.travelplanner.dao.jdbc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Queries {
    static public final String CHEAPEST_TICKET = getQuery("/getCheapestTicket.sql");

    private static String getQuery(String filename) {
        String sql = null;

        try {
            File file = new File(Queries.class.getResource(filename).getFile());

            sql = new Scanner(file).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return sql;
    }
}
