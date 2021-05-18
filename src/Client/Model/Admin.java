package Client.Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Admin implements User
{
  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private final String adminName = "Admin";
  private final String adminPassword = "admin";


  private Moderator moderator;

  public Admin(String userName, String password)
  {

  }


  public void createModerator(SimpleUser simpleUser){
//    dataModelManager.getModerators().add(moderator);
  }


  public boolean equals(Object obj){
    if(!(obj instanceof Admin)){
      return false;
    }
    Admin temp = (Admin)obj;
    return temp.adminName.equals(adminName)&&
        temp.adminPassword.equals(adminPassword);
  }



  @Override public ArrayList<SimpleUser> logIn()
  {
    return null;
  }

  @Override public void createAccount(String username, String password, String email)
  {

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

  @Override public void set(String username, String password, String email)
      throws RemoteException
  {

  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener) throws RemoteException
  {
    support.addPropertyChangeListener(name, listener);
  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener) throws RemoteException
  {
  support.addPropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(String name,
      PropertyChangeListener listener) throws RemoteException
  {
    support.removePropertyChangeListener(name, listener);
  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener) throws RemoteException
  {
    support.removePropertyChangeListener(listener);
  }
}
