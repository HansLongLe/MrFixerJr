package Client.Model;

import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;

public interface PropertyChangeSubject
{
  public void addPropertyChangeListener(String name, PropertyChangeListener listener) throws
      RemoteException;;
  public void addPropertyChangeListener(PropertyChangeListener listener) throws RemoteException;;
  public void removePropertyChangeListener(String name, PropertyChangeListener listener) throws RemoteException;;
  public void removePropertyChangeListener(PropertyChangeListener listener) throws RemoteException;;

}
