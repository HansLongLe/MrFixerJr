package Client.Model;

public class SimpleUser implements User
{
  private String username;
  private String password;
  public SimpleUser(String userName, String password)
  {
    this.username=userName;
    this.password=password;
  }

  public String getPassword() {
    return password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  @Override public void logIn()
  {

  }

  @Override public void register()
  {

  }
}
