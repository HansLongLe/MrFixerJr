package Client.Model;

import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;

public class Moderator implements User
{
  private String username;
  private String password;
  public Moderator(String userName, String password)
  {
    this.username=userName;
    this.password=password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  @Override public void logIn()
  {

  }

  @Override public void createAccount(String username, String password, String email)
  {

  }

  @Override public String getUserName() throws RemoteException
  {
    return null;
  }

  @Override public String getEmail() throws RemoteException
  {
    return null;
  }

  @Override public void set(String username, String password, String email)
      throws RemoteException
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
