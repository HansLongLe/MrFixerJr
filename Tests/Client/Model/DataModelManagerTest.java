package Client.Model;

import Client.Network.ClientRMI;
import Client.ViewModel.ViewModelFactory;
import org.junit.jupiter.api.Test;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DataModelManagerTest
{

  @Test void getSimpleUsers() throws RemoteException, NotBoundException
  {
//    SimpleUser simpleUser = new SimpleUser(new ClientRMI(new ViewModelFactory()));
//    ArrayList<SimpleUser> simpleUsers = new ArrayList<>();
//    simpleUsers.add(simpleUser);
//    assertNotNull(simpleUsers);
  }

  @Test void getUser()
  {
//    User user;
//    User simpleUser = new SimpleUser();
//    User moderatorUser = new Moderator("Username","12345678");
//
//    user = simpleUser;
//    if (user.equals(simpleUser))
//    {
//      assertNotNull(simpleUser);
//    }
//    else if (user.equals(moderatorUser))
//    {
//      assertNull(moderatorUser);
//    }
  }

  @Test void getModerators()
  {
    User moderator = new Moderator("Username","12345678");
    ArrayList<Moderator> moderators = new ArrayList<>();
    moderators.add((Moderator)moderator);
    assertNotNull(moderators);
  }

  @Test void getSimpleUser()
  {
//    User simpleUser = new SimpleUser();
//    ArrayList<SimpleUser> simpleUsers = new ArrayList<>();
//    simpleUsers.add((SimpleUser)simpleUser);
//    assertNotNull(simpleUsers);
  }

  @Test void addSimpleUser()
  {
//    ArrayList<SimpleUser> simpleUsers = new ArrayList<>();
//    User simpleUser = new SimpleUser();
//    simpleUsers.add((SimpleUser) simpleUser);
//    assertNotNull(simpleUsers);
  }

  @Test void addModerator()
  {

  }

  @Test void getAdmin()
  {
    Admin admin = new Admin("Username", "12345678");
    assertNotNull(admin);
  }
}