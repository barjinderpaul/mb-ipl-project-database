package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import static com.company.Constants.*;

public class SolveScenarios {

    public HashMap<Object,Object> executeQuery(String query, Statement stmt) throws SQLException {
        HashMap<Object, Object> result = new HashMap<>();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            Object columnOne = rs.getObject(1);
            Object columnTwo = rs.getObject(2);
            result.put(columnOne,columnTwo);
        }
        return result;
    }
}
