package sudoku;

import java.sql.*;

public class SudokuDatabase {

    public SudokuDatabase()
    {
        initSudokuDatabase();
    }

    private void initSudokuDatabase()
    {
        String dbUser = ""; // Put your username for your phpMyAdmin localhost
        String dbPass = ""; // Put your password for your phpMyAdmin localhost

        String dbHost = "localhost";
        String dbPort = "3306";
        String dbName = "sudoku";

        try
        {
            // URL to connect to server
            String url = "jdbc:mysql://" +dbHost+":"+dbPort+"/" + dbName;
            // Use the driver .jar
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish connection
            Connection con = DriverManager.getConnection(url, dbUser, dbPass);
            System.out.println("Connection established brush");

            Statement stmt = con.createStatement();

            String sqlQuery1 = "insert into info values(now(), 'Won!');";

            stmt.executeUpdate(sqlQuery1);

            String sqlQuery2 = "select *from info;";

            ResultSet st = stmt.executeQuery(sqlQuery2);

            while (st.next())
            {
                date = st.getString("dtm");
                state = st.getString("state");

                System.out.println(date + " | " + state);
            }

            System.out.println("Insertion Completed");

            stmt.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found!");
            e.printStackTrace(System.out);
        } catch (SQLException e) {
            System.out.println("ERROR: Connection not established");
            e.printStackTrace(System.out);
        } catch (Exception e)
        {
            System.out.println("Error");
        }
    }

    public String getSqlQueryResult()
    {
        return  this.date + "" + this.state;
    }


    private String date;
    private String state;
}
