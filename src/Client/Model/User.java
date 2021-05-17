package Client.Model;

import Client.Network.ClientInterface;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface User extends PropertyChangeSubject
{
  ArrayList<SimpleUser> logIn();
  void createAccount(String username, String password, String email)
      throws RemoteException, NotBoundException;

  String getUserName() throws RemoteException;
  String getPassword() throws RemoteException;
  String getEmail() throws RemoteException;
  public void set(String username, String password, String email) throws RemoteException;

}
