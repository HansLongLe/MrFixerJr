package Client.Model;

import Client.Network.ClientInterface;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface User
{
  ArrayList<SimpleUser> logIn();
  void createAccount(String username, String password, String email)
      throws RemoteException, NotBoundException;

  void chooseThreeGenresForUser(String username, String firstGenre, String secondGenre, String thirdGenre)
      throws RemoteException;

  String getRole(String username) throws RemoteException, NotBoundException;
}
