package Client.Model;

public class Admin extends User
{

  private final String adminName = "Admin";
  private final String adminPassword = "admin";


  private User user;
  private Moderator moderator;
  private DataModelManager dataModelManager;

  public Admin(String userName, String password)
  {
    super(userName, password);
  }


  public void createModerator(SimpleUser simpleUser){
    moderator = new Moderator(simpleUser.getUserName(), simpleUser.getPassword());
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
}
