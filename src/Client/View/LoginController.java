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
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * A class used for giving functionality to Login FXML
 */

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
    username.clear();
    password.clear();
  }

  public String getCurrentRole(){
    try
    {
      return loginViewModel.getRole(username.getText());
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    catch (NotBoundException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * A method used to logging in as an User or an Admin
   */

  public void LoginButton() throws IOException, NotBoundException
  {
    String role = loginViewModel.getRole(username.getText());
    switch(loginViewModel.logIn()){
      case "true":
        System.out.println("Logged in!");
        if(role.equals("Admin") || role.equals("Moderator")){
          viewHandler.openHomePage();
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
