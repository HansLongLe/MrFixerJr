package Client.Model;

public class Moderator implements User
{
  private String username;
  private String password;
  public Moderator(String userName, String password)
  {
    this.username=userName;
    this.password=password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  @Override public void logIn()
  {

  }

  @Override public void register()
  {

  }
}
