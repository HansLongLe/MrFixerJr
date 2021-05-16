package Server.Database;

import Client.Model.SimpleUser;
import Client.Model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private Connection connection;

    public DatabaseConnection()
    {
        String driver = "org.postgresql.Driver";

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "postgres";


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

    public void addUser(User user)
    {
        System.out.println("Data got to the last class" + user);

        String sql = "INSERT INTO GeneralUser VALUES(";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
