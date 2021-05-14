package Client.View;

import Client.ViewModel.*;

import javafx.scene.layout.Region;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
