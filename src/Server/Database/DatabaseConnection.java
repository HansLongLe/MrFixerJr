
package Server.Database;

import Client.Model.SimpleUser;
import Client.Model.User;

import java.rmi.RemoteException;
import java.sql.*;
import java.util.ArrayList;

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

    public ResultSet logIn(){

        String sql = "SELECT username, password, role FROM MyFlixerJr.GeneralUser";
        PreparedStatement preparedStatement = null;
        try
        {
            preparedStatement = connection.prepareStatement(sql);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

        try
        {
            return preparedStatement.executeQuery();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    public ResultSet getRole(String username) throws RemoteException
    {
        String sql = "SELECT role FROM MyFlixerJr.GeneralUser WHERE username = '"+ username+ "';";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(sql);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        try{
            return  preparedStatement.executeQuery();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }
    public void addGenre(String genre, boolean genreExists)
    {
        String sql = "INSERT INTO MyFlixerJr.Genre(genre) VALUES(" + "'" + genre +"');";

        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
            genreExists = false;
        } catch (SQLException throwable) {
            genreExists = true;
        }
    }

    public ArrayList<String> getGenresFromDatabase()
    {
        String sql = "";
        return null;
    }
}