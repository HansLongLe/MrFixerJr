package Client.Model;

import Client.Network.ClientInterface;

import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * A class used for initializing an object of SimpleUser
 */

public class SimpleUser implements Serializable
{

  private String name;
  private String password;
  private String email;

  public SimpleUser(String name, String password, String email)
  {
      this.name = name;
      this.password = password;
      this.email = email;
  }

  public String getUserName() throws RemoteException
  {
    return name;
  }

  public String getPassword() throws RemoteException
  {
    return password;
  }

  public String getEmail() {
    return email;
  }
}
