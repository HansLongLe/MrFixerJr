package Server.Network;

import Client.Model.SimpleUser;
import Client.Model.User;
import Client.Network.ClientInterface;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.util.ArrayList;

public interface ServerInterface extends Remote {
    void addBroadcast(ClientInterface clientReceiver) throws RemoteException;
    void newUser(User user) throws RemoteException;
    void start() throws RemoteException, AlreadyBoundException;
    ArrayList<User> logIn() throws RemoteException;
    String getRole(User user) throws RemoteException;
    void addGenre(String genre, boolean genreExists) throws RemoteException;
    ArrayList<String> getGenresFromDatabase() throws RemoteException;
    String getRole(String username) throws RemoteException;
}
