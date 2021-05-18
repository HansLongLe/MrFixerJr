package Client.Network;

import Client.Model.SimpleUser;
import Client.Model.User;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.util.ArrayList;

public interface ClientInterface extends Remote {
  void startClient() throws RemoteException, NotBoundException;
  public void newUser(User user) throws RemoteException, NotBoundException;
  ArrayList<SimpleUser> logIn() throws RemoteException, NotBoundException;
}
