package Client.Model;

import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;

public class SimpleUser implements User
{
  private String username;
  private String password;
  public SimpleUser(String userName, String password)
  {
    this.username=userName;
    this.password=password;
  }

  public String getPassword() {
    return password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  @Override public void logIn()
  {

  }

  @Override public void createAccount()
  {

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
