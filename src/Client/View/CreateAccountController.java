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
import javafx.scene.layout.Region;
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
  private Region region;
  private ViewHandler viewHandler;

  public void init( ViewHandler viewHandler, CreateAccountViewModel createAccountViewModel, Region region)
  {
    this.viewHandler = viewHandler;
    this.createAccountViewModel = createAccountViewModel;
    this.region = region;
  }
  @FXML
  public void CreateButton()
  {

  }

  @FXML public void goBack()
  {
    viewHandler.openView("LogIn");
  }

  public void reset()
  {

  }

  public Region getRegion()
  {
    return region;
  }
}
