package com.company;

import java.sql.*;
import java.util.HashMap;

import static com.company.Constants.*;

public class SolveScenarios {

    private HashMap<Object,Object> getResults(PreparedStatement preparedStatement) throws SQLException {
        HashMap<Object, Object> results = new HashMap<>();

        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Object columnOne = rs.getObject(1);
            Object columnTwo = rs.getObject(2);
            results.put(columnOne, columnTwo);
        }
        rs.close();
        return results;

    }

    public HashMap<Object, Object> executeQuery(String query) throws SQLException {
        // creating connection with database
        Connection connection = new ConnectDB().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        HashMap<Object, Object> result = getResults(preparedStatement);

        // closing connections;
        preparedStatement.close();
        connection.close();

        return result;
    }


    public HashMap<Object, Object> executeQuery(String query, Integer YEAR_PARAMETER) throws SQLException {
        // creating connection with database
        Connection connection = new ConnectDB().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,YEAR_PARAMETER);

        HashMap<Object, Object> result = getResults(preparedStatement);

        // closing connections;
        preparedStatement.close();
        connection.close();

        return result;
    }
}
