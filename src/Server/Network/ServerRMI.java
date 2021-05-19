package Server.Network;

import Client.Model.SimpleUser;
import Client.Model.User;
import Client.Network.ClientInterface;
import Server.Database.DatabaseConnection;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ServerRMI implements ServerInterface{

    private ArrayList<ClientInterface> connectedUsers;
    private DatabaseConnection databaseConnection;


    public ServerRMI(String databasePassword) throws RemoteException
    {
        UnicastRemoteObject.exportObject( this, 0);
        connectedUsers = new ArrayList<>();
        databaseConnection = new DatabaseConnection(databasePassword);
    }
    @Override
    public void addBroadcast(ClientInterface clientReceiver) {
        connectedUsers.add(clientReceiver);
    }

    @Override
    public void newUser(User user) throws RemoteException{
       databaseConnection.addUser(user);
        System.out.println("new user in server");
    }

    @Override public void start() throws RemoteException, AlreadyBoundException
    {
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("Server", this);
        System.out.println("Server started!");
        Scanner scanner = new Scanner(System.in);

    }

    @Override public ArrayList<User> logIn()
        throws RemoteException
    {      ResultSet rs = null;
            ArrayList<User> simpleUsers = new ArrayList<>();
        System.out.println("array");

        rs=databaseConnection.logIn() ;
        try{
                    while(rs.next()){
                        String username1 = rs.getString("username");
                        String password1 = rs.getString("password");

                        User temp = new SimpleUser();
                        temp.set(username1, password1, "");
                        simpleUsers.add( temp);
                    }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

        return simpleUsers;
    }

    @Override public String getRole(User user) throws RemoteException
    {
        ResultSet rs= null;
        rs = databaseConnection.getRole();
        ArrayList<String> roles = new ArrayList<>();
        String role = "";
        role = user.getRole();
        try
        {
            while(rs.next()){
            role = rs.getString("role");
            roles.add(role);

            }
            for (int i=0; i<roles.size(); i++){
                if(roles.get(i).equals("Admin")){
                    return "Admin";
                }
                else if(roles.get(i).equals("Moderator"))
                    return "Moderator";
            }

        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    return "SimpleUser";
    }

    @Override
    public void addGenre(String genre) throws RemoteException {
        databaseConnection.addGenre(genre);
    }

}
