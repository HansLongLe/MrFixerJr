package Client.Model;

import java.util.ArrayList;

public class DataModelManager implements DataModel
{
  private ArrayList<SimpleUser> simpleUsers;
  private ArrayList<Moderator> moderators;
  private Admin admin;
  private String userName;
  private User user;

  public DataModelManager(){
    simpleUsers = new ArrayList<SimpleUser>();
    moderators = new ArrayList<Moderator>();
    admin = new Admin("admin", "admin");
  }

  public ArrayList<SimpleUser> getSimpleUsers(){
    return simpleUsers;
  }


  @Override public User getUser()
  {
//    if(user instanceof SimpleUser){
//    for(int i=0; i<simpleUsers.size(); i++){
//      if(simpleUsers.get(i).getUserName().equals(userName)){
//        user = simpleUsers.get(i);
//      }
//    }
//    }
//    else if(user instanceof Moderator){
//      for (int i = 0; i < moderators.size(); i++){
//        if(moderators.get(i).getUserName().equals(userName)){
//          user = simpleUsers.get(i);
//        }
//      }
//    }
    return user;
  }


  public String getType(){
    if (user instanceof SimpleUser){
      return "SimpleUser";
    }
    else if (user instanceof Moderator){
      return "Moderator";
    }
    return null;
  }

//
//  @Override
//  public User getUser()
//  {
//    if(user instanceof SimpleUser){
//    for(int i=0; i<simpleUsers.size(); i++){
//      if(simpleUsers.get(i).getUserName().equals(userName)){
//        user = simpleUsers.get(i);
//      }
//    }
//    }
//    else if(user instanceof Moderator){
//      for (int i = 0; i < moderators.size(); i++){
//        if(moderators.get(i).getUserName().equals(userName)){
//          user = simpleUsers.get(i);
//        }
//      }
//    }
//    return user;
//  }


  public ArrayList<Moderator> getModerators(){
    return moderators;
  }


  //@Override public ArrayList<SimpleUser> getSimpleUser()
  //{
    //return simpleUsers;
  //}
//
  //@Override public void addSimpleUser(SimpleUser simpleUser)
  //{
  //  simpleUsers.add(simpleUser);
//
  //}


  @Override
  public void addSimpleUser(SimpleUser simpleUser)
  {
    simpleUsers.add(simpleUser);

  }


  @Override
  public void addModerator(Moderator moderator) {
    moderators.add(moderator);
  }

  public void addModerator(SimpleUser simpleUser){
    if(!(admin.equals(user))){
      admin.createModerator(simpleUser);
    }
  }

  public Admin getAdmin(){
    return admin;
  }


  @Override
  public ArrayList<SimpleUser> allSimpleUsers() {
    return simpleUsers;
  }

  public ArrayList<Moderator> allModerators(){
    return moderators;
  }
}
