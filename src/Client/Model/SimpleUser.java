package Client.Model;

import Client.Network.ClientInterface;

import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;

public class SimpleUser implements User
{

  private String name;
  private String password;
  private String email;
  public SimpleUser() {}

  public void set(String username, String password, String email){
    this.name = username;
    this.password = password;
     this.email = email;
  }

  @Override public void logIn()
  {

  }

  @Override public void createAccount(String username, String password, String email)
      throws RemoteException
  {
//    SimpleUser user = new SimpleUser();
//    user.set(username, password, email);
//    System.out.println("UMM");
  }

  @Override public String getUserName() throws RemoteException
  {
    return null;
  }

  @Override public String getPassword() throws RemoteException
  {
    return null;
  }

  @Override public String getEmail() throws RemoteException
  {
    return null;
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener) throws RemoteException
  {

  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener) throws RemoteException
  {

  }

  @Override public void removePropertyChangeListener(String name,
      PropertyChangeListener listener) throws RemoteException
  {

  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener) throws RemoteException
  {

  }
}
