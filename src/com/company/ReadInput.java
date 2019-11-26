package com.company;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.company.Constants.*;

public class ReadInput {

    public ReadInput() throws SQLException {

        Connection conn = new ConnectDB().getConnection();
        Statement stmt =  conn.createStatement();

        // creates and fills match table
        stmt.executeUpdate(CREATE_MATCH_TABLE_SQL);
        stmt.executeUpdate(FILL_MATCH_DATA);

        // creates and fills delivery table
        stmt.executeUpdate(CREATE_DELIVERY_TABLE_SQL);
        stmt.executeUpdate(FILL_DELIVERY_DATA);

        stmt.close();
        conn.close();

    }



}
