package Client.View;


import Client.ViewModel.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class LoginController
{
  private LoginViewModel loginViewModel;
  private ViewHandler viewHandler;
  private ViewModelFactory viewModelFactory;

  @FXML private TextField username;
  @FXML private PasswordField password;




  public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler)
  {
    this.loginViewModel = viewModelFactory.getLoginViewModel();
    this.viewHandler = viewHandler;
    this.viewModelFactory = viewModelFactory;
    loginViewModel = viewModelFactory.getLoginViewModel();
    username.textProperty().bindBidirectional(loginViewModel.getUsername());
    password.textProperty().bindBidirectional(loginViewModel.getPassword());
  }
  @FXML
  public void LoginButton() throws IOException
  {
    String role = loginViewModel.getRole(username.getText());
    switch(loginViewModel.logIn()){
      case "true":
        System.out.println("Logged in!");
        if(role.equals("Admin") || role.equals("Moderator")){
          viewHandler.openHomepage();
        }
        else if(role.equals("SimpleUser")){
          viewHandler.openHomePageForSimpleUser();
        }


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

  public void createAccountButton() throws IOException
  {
  viewHandler.openCreateAccount();
  }


}
