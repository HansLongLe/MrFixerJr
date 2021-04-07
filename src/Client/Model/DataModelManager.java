package Model;

import java.util.ArrayList;

public class DataModelManager implements DataModel
{
  private ArrayList<SimpleUser> simpleUsers;
  private ArrayList<Moderator> moderators;
  private Admin admin;

  public DataModelManager(){
    simpleUsers = new ArrayList<SimpleUser>();
    moderators = new ArrayList<Moderator>();
    admin = new Admin("admin", "admin");
  }

  public ArrayList<SimpleUser> getSimpleUsers(){
    return simpleUsers;
  }
  public ArrayList<Moderator> getModerators(){
    return moderators;
  }
  public void addSimpleUser(SimpleUser simpleUser){
    simpleUsers.add(simpleUser);
  }
  public void addModerator(Moderator moderator){
    moderators.add(moderator);
  }

  public Admin getAdmin(){
    return admin;
  }



}
