package Server.Model;

import Client.Model.SimpleUser;
import Client.Model.User;
import Server.Database.DatabaseConnection;

import java.rmi.RemoteException;
import java.sql.*;
import java.util.ArrayList;

/**
 * A class used for testing database connection
 */

public class test
{
  public static void main(String[] args)
      throws ClassNotFoundException, SQLException, RemoteException
  {
    String driver = "org.postgresql.Driver";
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres";
    String password = "postgres";

    Class.forName(driver);
    Connection connection= DriverManager.getConnection(url,user,password);
    String sql = "SELECT username, password FROM MyFlixerJr.GeneralUser WHERE role= 'SimpleUser';";
    PreparedStatement preparedStatement=connection.prepareStatement(sql);
    ResultSet rs= preparedStatement.executeQuery();
    ArrayList<SimpleUser> users=new ArrayList<>();

    while (rs.next()){
      String username=rs.getString("username");
      String password1=rs.getString("password");
      String role1 = rs.getString("role");

      SimpleUser user1= new SimpleUser(username, password1, "");
      users.add(user1);
    }

    System.out.println(users.size());
    System.out.println(users);

  }


}
