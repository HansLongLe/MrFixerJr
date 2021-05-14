package Client.View;

import Client.View.ViewHandler;

import Client.ViewModel.CreateAccountViewModel;
import Client.ViewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CreateAccountController
{
  @FXML private TextField username;
  @FXML private PasswordField password;
  @FXML private PasswordField repeatPassword;
  @FXML private TextField email;
  @FXML private Button create;
  @FXML private Button back;

  private ViewHandler viewHandler;
  private CreateAccountViewModel createAccountViewModel;
  public void init(CreateAccountViewModel createAccountViewModel, ViewHandler viewHAndler)
  {
    this.createAccountViewModel=createAccountViewModel;
    this.viewHandler=viewHAndler;
  }
  @FXML
  public void CreateButton(){
    viewHandler.openLogIn();
  }

  @FXML public void goBack(){
    viewHandler.openLogIn();
  }
}
