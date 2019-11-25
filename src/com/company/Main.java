package com.company;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.company.Constants.*;
public class Main {
    public static void main(String[] args) throws SQLException {

        // Initialise connection
        Connection conn = new ConnectDB().getConnection();
        Statement stmt =  conn.createStatement();

        // Read data from file and store in database
        new ReadInput(stmt);

        // Solving all scenarios
        SolveScenarios solved = new SolveScenarios();

        Map<Object,Object> matchesPlayedPerSeason = solved.executeQuery(GET_SEASON_COUNT_SQL,stmt);
        Map<Object,Object> matchesWon = solved.executeQuery(GET_WINNER_COUNT_SQL,stmt);
        Map<Object,Object> extraRuns = solved.executeQuery(GET_EXTRA_RUNS_SQL,stmt);
        Map<Object,Object> economicBowlers = solved.executeQuery(GET_ECONOMIC_BOWLER_SQL,stmt);



        // Final output
        Map<String, Map<Object,Object >> finalOutput = new LinkedHashMap<String, Map<Object, Object>>();
        finalOutput.put(QUESTION1, matchesPlayedPerSeason);
        finalOutput.put(QUESTION2, matchesWon);
        finalOutput.put(QUESTION3, extraRuns);
        finalOutput.put(QUESTION4, economicBowlers);

        Iterator<Map.Entry<String, Map<Object, Object>>> mapIterator = finalOutput.entrySet().iterator();

        while (mapIterator.hasNext()) {
            Map.Entry<String, Map<Object, Object>> entry = mapIterator.next();
            String question = entry.getKey();
            Map<Object, Object> answer = entry.getValue();
            System.out.println(" >  " + question + " : ");
            for (Map.Entry<Object, Object> nestedEntry : answer.entrySet()) {
                System.out.println("\t" + nestedEntry.getKey() + " " + nestedEntry.getValue());
            }
            System.out.println();
        }


        conn.close();
        stmt.close();

    }
}

