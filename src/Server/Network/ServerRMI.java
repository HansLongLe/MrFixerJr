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
}
