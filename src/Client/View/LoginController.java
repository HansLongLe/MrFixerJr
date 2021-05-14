package Client.View;

import Client.ViewModel.*;


public class LoginController
{
  private LoginViewModel loginViewModel;
  private ViewHandler viewHandler;
  private Region region;

  public void init(ViewHandler viewHandler, LoginViewModel loginViewModel, Region region)
  {
    this.loginViewModel = loginViewModel;
    this.viewHandler = viewHandler;
    this.region = region;
  }

  public void LoginButton()
  {

  }

  public void CreateAccountButton()
  {
    viewHandler.openView("CreateAccount");
  }

  public void reset()
  {

  }

  public Region getRegion()
  {
    return region;
  }
}
