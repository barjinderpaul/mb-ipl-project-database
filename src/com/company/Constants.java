package com.company;

public class Constants {

    public static final String MATCH_FILE_PATH = "/home/barjinder/matches.csv";
    public static final String DELIVERY_FILE_PATH = "/home/barjinder/deliveries.csv";

    public static final String FILL_MATCH_DATA = "copy matches from '" + MATCH_FILE_PATH + "' DELIMITER ',' CSV HEADER;";
    public static final String FILL_DELIVERY_DATA = "copy deliveries from '"+ DELIVERY_FILE_PATH + "' DELIMITER ',' CSV HEADER;";

    public static final String CREATE_MATCH_TABLE_SQL = "CREATE TABLE IF NOT EXISTS matches (" +
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

    public static final String CREATE_DELIVERY_TABLE_SQL = "create table IF NOT EXISTS deliveries(" +
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

    public static final String GET_SEASON_COUNT_SQL = "select season, count(season) as winnings from matches group by season;";

    public static final String GET_WINNER_COUNT_SQL = "select winner, count(winner) from matches group by winner;";

    public static final String GET_EXTRA_RUNS_SQL = "select bowling_team, sum(extra_runs) from deliveries join matches on deliveries.match_id = matches.id where season = 2016 group by bowling_team;";

    public static final String GET_ECONOMIC_BOWLER_SQL = "select bowler, sum(total_runs)/(count(ball)/6.0) as economy from deliveries join matches " +
            "on deliveries.match_id = matches.id where season = 2015 group by bowler " +
            "order by economy asc limit 5;";

    public static final String QUESTION1 = "Number of matches played per year of all the years in IPL.";
    public static final String QUESTION2 = "Number of matches won of all teams over all the years of IPL.";
    public static final String QUESTION3 = "For the year 2016 get the extra runs conceded per team.";
    public static final String QUESTION4 = "For the year 2015 get the top economical bowlers.";
}
