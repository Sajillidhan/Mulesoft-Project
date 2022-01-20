package net.sqlitetutorial;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateTable {


        public static void createNewTable() {
            // SQLite connection string
            String url = "jdbc:sqlite:C://sqlite/db/Database.db";

            // SQL statement for creating a new table
            String sql = "CREATE TABLE IF NOT EXISTS movies (\n"
                    + " id integer PRIMARY KEY,\n"
                    + " movie_name String,\n"
                    + " actor String,\n"
                    + " actress String,\n"
                    + " director String,\n"
                    + " year_of_release int\n"
                    + ");";

            try{
                Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                stmt.execute(sql);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        public static void main(String[] args) {
            createNewTable();
        }

    }

