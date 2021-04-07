package Model;

import javax.xml.crypto.Data;

public class Admin extends User
{
  private User user;
  private Moderator moderator;
  private DataModelManager dataModelManager;

  public Admin(String userName, String password)
  {
    super(userName, password);
  }
  public void createModerator(SimpleUser simpleUser){
    dataModelManager.getModerators().add(new Moderator(simpleUser.getUserName(),
        simpleUser.getPassword()));
    dataModelManager.getSimpleUsers().remove(simpleUser);
  }
}
