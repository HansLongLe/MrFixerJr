package Client.Model;

import Client.Network.ClientInterface;
import Client.Network.ClientRMI;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * A class used for managing logic part of the login system
 * this class is connected to ClientInterface which is used for sending and receiving information to/from the server
 */

public class UserModelManager implements User
{
  private ClientInterface clientInterface;
  private ArrayList<SimpleUser> simpleUsers;

  /**
   * Constructor that connects this class to clientInterface and creates a list of SimpleUsers
   */
  public UserModelManager(ClientInterface clientInterface)
      throws RemoteException, NotBoundException
  {
    this.clientInterface = clientInterface;
    clientInterface = new ClientRMI();
    clientInterface.startClient();
    simpleUsers = new ArrayList<>();
  }

  /**
   * Method for receiving list of SimpleUsers from the server
   */

  @Override public ArrayList<SimpleUser> logIn()
  {
    try
    {
     simpleUsers = clientInterface.logIn();
    }
    catch (RemoteException | NotBoundException e)
    {
      e.printStackTrace();
    }
      return simpleUsers;
    }

  /**
   * A method for creating an account of SimpleUser and sending those information to the server
   */

  @Override public void createAccount(String username, String password, String email)
      throws RemoteException, NotBoundException
  {
    SimpleUser user = new SimpleUser(username, password, email);
    System.out.println("UMM");

    clientInterface.newUser(user);

  }



  @Override public String getRole(String username)
      throws RemoteException, NotBoundException
  {
    return clientInterface.getRole(username);
  }

  /**
   * A method for sending 3 preferables genres chosen when creating an account to the server
   */

  @Override public void chooseThreeGenresForUser(String username, String firstGenre, String secondGenre, String thirdGenre)
      throws RemoteException
  {
    clientInterface.chooseThreeGenresForUser(username, firstGenre,secondGenre, thirdGenre);
  }
}
