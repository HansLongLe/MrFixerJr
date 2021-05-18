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
import javafx.stage.Stage;

import java.io.IOException;


public class LoginController
{
  private LoginViewModel loginViewModel;
  private ViewHandler viewHandler;
  private ViewModelFactory viewModelFactory;
  private Region region;
  private CreateAccountViewModel cavm;

  @FXML private TextField username;
  @FXML private PasswordField password;
  @FXML private Button logIn;
  @FXML private Button createAccount;



  public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler)
  {
    this.loginViewModel = loginViewModel;
    this.viewHandler = viewHandler;
    this.viewModelFactory = viewModelFactory;
    loginViewModel = viewModelFactory.getLoginViewModel();
    username.textProperty().bindBidirectional(loginViewModel.getUsername());
    password.textProperty().bindBidirectional(loginViewModel.getPassword());
  }
  @FXML
  public void LoginButton() throws IOException
  {
    switch(loginViewModel.logIn()){
      case "true": {
        System.out.println("Logged in!");
        Stage stage = new Stage();
        Scene scene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;

        loader.setLocation(getClass().getResource("Homepage.fxml"));
        root = loader.load();

        HomepageController controller = loader.getController();
        controller.init(viewModelFactory);

        stage.setTitle("MyFlixerJr");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        break;
      }
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
