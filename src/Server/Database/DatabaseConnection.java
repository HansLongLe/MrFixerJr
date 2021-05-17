package Server.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private Connection connection;

    public DatabaseConnection()
    {
        String driver = "org.postgresql.Driver";

        String url = "jdbc:postgresql://localhost:5432/Company";
        String user = "postgres";
        String password = "cjj2468830035";


        connection = null;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }

    public void addUser()
    {


        String sql = "insert into movie.role(movieId, personName, role)\n" +
                "values (003, 'Chen', 'Actor');";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
            System.out.println("Data got to the last class");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
