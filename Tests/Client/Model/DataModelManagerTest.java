package Client.Model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DataModelManagerTest
{

  @Test void getSimpleUsers()
  {
    SimpleUser simpleUser = new SimpleUser("Username", "12345678");
    ArrayList<SimpleUser> simpleUsers = new ArrayList<>();
    simpleUsers.add(simpleUser);
    assertNotNull(simpleUsers);
  }

  @Test void getUser()
  {
    User user;
    User simpleUser = new SimpleUser("Username","12345678");
    User moderatorUser = new Moderator("Username","12345678");

    user = simpleUser;
    if (user.equals(simpleUser))
    {
      assertNotNull(simpleUser);
    }
    else if (user.equals(moderatorUser))
    {
      assertNull(moderatorUser);
    }
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
    User simpleUser = new SimpleUser("Username","12345678");
    ArrayList<SimpleUser> simpleUsers = new ArrayList<>();
    simpleUsers.add((SimpleUser)simpleUser);
    assertNotNull(simpleUsers);
  }

  @Test void addSimpleUser()
  {
    ArrayList<SimpleUser> simpleUsers = new ArrayList<>();
    User simpleUser = new SimpleUser("Username","12345678");
    simpleUsers.add((SimpleUser) simpleUser);
    assertNotNull(simpleUsers);
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