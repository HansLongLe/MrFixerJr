package Client.View;

import Client.ViewModel.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController
{
  private LoginViewModel loginViewModel;
  private CreateAccountViewModel cavm;
  private ViewHandler vh;

  @FXML private TextField username;
  @FXML private PasswordField password;
  @FXML private Button logIn;
  @FXML private Button createAccount;


  public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler)
  {
    this.vh = viewHandler;
    loginViewModel = viewModelFactory.getLoginViewModel();
    username.textProperty().bind(loginViewModel.);
    password.textProperty().bind(loginViewModel.);



  }
  @FXML
  public void LoginButton(){

  }
  @FXML
  public void CreateAccountButton(){

  }
}
