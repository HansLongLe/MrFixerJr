package Client.View;

import Client.Model.ModelFactory;
import Client.View.ViewHandler;

import Client.ViewModel.CreateAccountViewModel;
import Client.ViewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CreateAccountController {
  @FXML
  private TextField username;
  @FXML
  private Label error;
  @FXML
  private PasswordField password;
  @FXML
  private PasswordField repeatPassword;
  @FXML
  private TextField email;


  private ViewModelFactory viewModelFactory;
  private CreateAccountViewModel createAccountViewModel;
  private ViewHandler viewHandler;

  public void init( ViewHandler viewHandler, ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    this.viewModelFactory = viewModelFactory;
    createAccountViewModel = viewModelFactory.getCreateAccountViewModel();

  }

  public void CreateButton() throws IOException, NotBoundException {
    if ((password.getText().equals(repeatPassword.getText()))) {
      createAccountViewModel.createAccount(username.getText(), password.getText(), email.getText());
      error.setVisible(false);
      viewHandler.openView();
    } else {
      error.setVisible(true);
    }
  }

  public void goBack() throws IOException {
    viewHandler.openView();
  }

}

