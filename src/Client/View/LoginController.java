package Client.View;

import Client.ViewModel.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController
{
  private LoginViewModel loginViewModel;
  private ViewHandler viewHandler;
  private Region region;
  private CreateAccountViewModel cavm;
  private ViewHandler vh;

  @FXML private TextField username;
  @FXML private PasswordField password;
  @FXML private Button logIn;
  @FXML private Button createAccount;


  public void init(ViewHandler viewHandler, LoginViewModel loginViewModel)
  {
    this.loginViewModel = loginViewModel;
    this.viewHandler = viewHandler;
    this.region = region;
  }

  public void LoginButton()
  {

  }

  public void CreateAccountButton() throws IOException
  {
  viewHandler.openCreateAccount();
  }

  public void reset()
  {

  }

  public Region getRegion()
  {
    return region;
  }
}
