package Client.Model;

public class Admin implements User
{

  private final String adminName = "Admin";
  private final String adminPassword = "admin";


  private Moderator moderator;
  private DataModelManager dataModelManager;

  public Admin(String userName, String password)
  {

  }


  public void createModerator(SimpleUser simpleUser){
    dataModelManager.getModerators().add(moderator);
    dataModelManager.getSimpleUsers().remove(simpleUser);
  }


  public boolean equals(Object obj){
    if(!(obj instanceof Admin)){
      return false;
    }
    Admin temp = (Admin)obj;
    return temp.adminName.equals(adminName)&&
        temp.adminPassword.equals(adminPassword);
  }

  @Override public void logIn()
  {

  }

  @Override public void register()
  {

  }
}
