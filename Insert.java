package net.sqlitetutorial;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {

    private Connection connect() {
        // SQLite connection string  
        String url = "jdbc:sqlite:C:/sqlite/db/Database.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public void insert(String moviename, String actor,String actress,int yearofrelease) {
        String sql = "INSERT INTO movies(movie_name,actor,actress,year_of_release)VALUES(?,?,?,?)";

        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, moviename);
            pstmt.setString(2, actor);
            pstmt.setString(3, actress);
            pstmt.setInt(4, yearofrelease);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        Insert i = new Insert();
        // insert four new rows
        i.insert("Interstellar","Matthew McConaughey","Mackenzie Foy",2014);
        i.insert("Inception","Leonardo DiCaprio","Elliot Page",2010);
        i.insert("Avatar","Sam Worthington","Sigourney Weavere",2009);
        i.insert("Spiderman","Tobey Maguire","Kirsten Dunst",2002);

    }

}  