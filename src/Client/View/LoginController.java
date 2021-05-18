package Client.View;

import Client.Model.SimpleUser;
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
import java.rmi.RemoteException;
import java.util.ArrayList;

public class LoginController
{
  private LoginViewModel loginViewModel;
  private ViewHandler viewHandler;
  private Region region;
  private CreateAccountViewModel cavm;

  @FXML private TextField username;
  @FXML private PasswordField password;
  @FXML private Button logIn;
  @FXML private Button createAccount;



  public void init(ViewHandler viewHandler, ViewModelFactory vmf)
  {
    this.loginViewModel = vmf.getLoginViewModel();
    this.viewHandler = viewHandler;
    username.textProperty().bindBidirectional(loginViewModel.getUsername());
    password.textProperty().bindBidirectional(loginViewModel.getPassword());
  }
  @FXML
  public void LoginButton() throws RemoteException
  {
    switch(loginViewModel.logIn()){
      case "true":
        System.out.println("Logged in!");
        break;
      case "Wrong password":
        System.out.println("Wrong password");
        break;
      case "Wrong username":
        System.out.println("Wrong username");
        break;
      case "false":
        System.out.println("false");
        break;
    }

  }

  public String getUsername(){
    return username.getText();
  }

  public String getPas(){
    return username.getText();
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
