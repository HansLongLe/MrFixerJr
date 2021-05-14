package Client.View;

import Client.View.ViewHandler;

import Client.ViewModel.CreateAccountViewModel;
import Client.ViewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateAccountController
{
  @FXML private TextField username;
  @FXML private PasswordField password;
  @FXML private PasswordField repeatPassword;
  @FXML private TextField email;
  @FXML private Button create;
  @FXML private Button back;
  private CreateAccountViewModel cavm;
  private ViewHandler vh;
  private CreateAccountViewModel createAccountViewModel;
  public void init(ViewModelFactory viewModelFactory, ViewHandler viewHAndler)
  {
    this.vh =vh;
    cavm = viewModelFactory.getCreateAccountViewModel();
    username.textProperty().bind(cavm.);
    password.textProperty().bind(cavm.);
    repeatPassword.textProperty().bind(cavm.);
    email.textProperty().bind(cavm.);

  }
  @FXML
  public void CreateButton(){

  }

  @FXML public void goBack(){

  }
}
