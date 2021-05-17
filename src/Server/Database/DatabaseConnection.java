package Server.Database;

import Client.Model.SimpleUser;
import Client.Model.User;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private Connection connection;

    public DatabaseConnection(String password)
    {
        String driver = "org.postgresql.Driver";

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";



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

    public void addUser(User user) throws RemoteException
    {
        System.out.println("Data got to the last class" + user);
        System.out.println(user.getUserName()+ user.getPassword());
        String sql = "INSERT INTO MyFlixerJr.GeneralUser(username, email, password,role)  VALUES( " + "'" + user.getUserName() + "','" +  user.getEmail() + "','" +  user.getPassword() + "','SimpleUser');";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
            System.out.println("New user in database!!!!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
