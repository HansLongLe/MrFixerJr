package Client.Model;

public class User
{
  private String userName;
  private String password;


  public User(String userName, String password){
    this.userName = userName;
    this.password = password;
  }

  public String getUserName(){
    return userName;
  }
  public String getPassword(){
    return password;
  }
  public void setPassword(String password){
    this.password = password;
  }
  public boolean equals(Object obj){
    if(!(userName.equals(obj))){
      return false;
    }
    User temp = (User)obj;
    return temp.getUserName().equals(userName) &&
        temp.getPassword().equals(password);
  }

  protected void changeToModerator()
  {
    Moderator newModerator = new Moderator(userName, password);
  }
}
