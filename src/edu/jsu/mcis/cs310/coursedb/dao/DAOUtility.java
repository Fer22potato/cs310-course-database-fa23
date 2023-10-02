package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;
import java.util.ArrayList;

public class DAOUtility {
    
    public static final int TERMID_FA23 = 1;
    
    public static String getResultSetAsJson(ResultSet rs) {
        
        JsonArray records = new JsonArray();
        
        try {
        
            if (rs != null) {
                // INSERT YOUR CODE HERE
                ResultSetMetaData rsmd = rs.getMetaData();
                int numberColumns = rsmd.getColumnCount();
                while (rs.next()){
                    JsonObject count = new JsonObject();
                    for (int i =1; i <= numberColumns; i++){
                       String columnName = rsmd.getColumnName(i);
                       String columnValue = rs.getString(i);
                       count.put(columnName, columnValue);
                    }
                    records.add(count);
                }
                    
            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return Jsoner.serialize(records);
        
    }
    
}