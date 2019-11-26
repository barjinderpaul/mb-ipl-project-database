package com.company;

public class Constants {

    public static final String MATCH_COLUMN = "";

    public static final String MATCH_FILE_PATH = "/home/barjinder/matches.csv";
    public static final String DELIVERY_FILE_PATH = "/home/barjinder/deliveries.csv";

    public static final String MATCH_TABLE_NAME = "matches";
    public static final String DELIVERY_TABLE_NAME = "deliveries";
    public static final String FILL_MATCH_DATA = "copy "+ MATCH_TABLE_NAME + " from '" + MATCH_FILE_PATH + "' DELIMITER ',' CSV HEADER;";
    public static final String FILL_DELIVERY_DATA = "copy "+ DELIVERY_TABLE_NAME + " from '"+ DELIVERY_FILE_PATH + "' DELIMITER ',' CSV HEADER;";

    public static final String CREATE_MATCH_TABLE_SQL = "CREATE TABLE IF NOT EXISTS "+MATCH_TABLE_NAME+" (" +
            "id int primary key," +
            "season int," +
            "city varchar(20)," +
            "date date," +
            "team1 varchar(50)," +
            "team2 varchar(50)," +
            "toss_winner varchar(30)," +
            "toss_decision varchar(10)," +
            "result varchar(10)," +
            "dl_applied bool," +
            "winner varchar(50)," +
            "win_by_runs int," +
            "win_by_wickets int," +
            "player_of_match varchar(50)," +
            "venue varchar(100)," +
            "umpire1 varchar(60)," +
            "umpire2 varchar(60)," +
            "umpire3 varchar(60)"
            +");";

    public static final String CREATE_DELIVERY_TABLE_SQL = "create table IF NOT EXISTS "+DELIVERY_TABLE_NAME+"(" +
            "    match_id int references matches (id)," +
            "    inning int," +
            "    batting_team varchar(50)," +
            "    bowling_team varchar(50)," +
            "    over int," +
            "    ball int," +
            "    batsman varchar(50)," +
            "    non_striker varchar(50)," +
            "    bowler varchar(50)," +
            "    is_super_over bool," +
            "    wide_runs int," +
            "    bye_runs int," +
            "    legbye_runs int," +
            "     noball_runs int," +
            "     penalty_runs int," +
            "     batsman_runs int," +
            "     extra_runs int," +
            "     total_runs int," +
            "     player_dismissed varchar(50)," +
            "     dismissal_kind varchar(50)," +
            "     fielder varchar(50)" +
            ");";


    public static final Integer ECONOMIC_BOWLER_YEAR = 2015;
    public static final String BOWLER_COLUMN = "bowler";
    public static final String TOTAL_RUNS_COLUMN = "total_runs";
    public static final String BALL_COLUMN = "ball";
    public static Double BALLS_PER_OVER = 6.0;
    public static final String SEASON_COLUMN = "season";

    public static final Integer EXTRA_RUNS_YEAR = 2016;
    public static final String BOWLING_TEAM_COLUMN = "bowling_team";
    public static final String EXTRA_RUNS_COLUMN = "extra_runs";
    public static final String ID_COLUMN = "id";
    public static final String MATCH_ID_COLUMN = "match_id";
    public static final String WINNER_COLUMN = "winner";
    public static final Integer EMPTY_INTEGER = null;


    public static final String GET_SEASON_COUNT_SQL = "select "+SEASON_COLUMN+", count("+SEASON_COLUMN+") as winnings from "+MATCH_TABLE_NAME+" group by "+SEASON_COLUMN+";";

    public static final String GET_WINNER_COUNT_SQL = "select "+WINNER_COLUMN+", count("+WINNER_COLUMN+") from "+MATCH_TABLE_NAME+" group by "+WINNER_COLUMN+";";

    public static final String GET_EXTRA_RUNS_SQL = "select "+BOWLING_TEAM_COLUMN+", sum("+EXTRA_RUNS_COLUMN+") from "+DELIVERY_TABLE_NAME+" join "+MATCH_TABLE_NAME+" on "+DELIVERY_TABLE_NAME+"."+MATCH_ID_COLUMN+" = "+MATCH_TABLE_NAME+"."+ID_COLUMN+" where "+SEASON_COLUMN+" = ? group by "+BOWLING_TEAM_COLUMN+";";

    public static final String GET_ECONOMIC_BOWLER_SQL = "select "+BOWLER_COLUMN+", sum("+TOTAL_RUNS_COLUMN+")/(count("+BALL_COLUMN+")/"+BALLS_PER_OVER+") as economy from "+DELIVERY_TABLE_NAME+" join "+MATCH_TABLE_NAME+" " +
            "on "+DELIVERY_TABLE_NAME+"."+MATCH_ID_COLUMN+" = "+MATCH_TABLE_NAME+"."+ID_COLUMN+" where "+SEASON_COLUMN+" = ? group by "+BOWLER_COLUMN+" " +
            "order by economy asc limit 5;";

    public static final String QUESTION1 = "Number of matches played per year of all the years in IPL.";
    public static final String QUESTION2 = "Number of matches won of all teams over all the years of IPL.";
    public static final String QUESTION3 = "For the year "+EXTRA_RUNS_YEAR+" get the extra runs conceded per team.";
    public static final String QUESTION4 = "For the year "+ECONOMIC_BOWLER_YEAR +" get the top economical bowlers.";
}
