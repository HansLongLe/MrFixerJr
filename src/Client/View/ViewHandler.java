package Client.View;

import Client.ViewModel.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;


public class ViewHandler
{
  private Stage primaryStage;
  private ViewModelFactory viewModelFactory;



  public ViewHandler(ViewModelFactory ViewModel, Stage primarySTgae)
  {
    this.viewModelFactory = ViewModel;
    this.primaryStage = primarySTgae;

  }

  public void start() throws IOException
  {
    openView();
  }

  public void openHomePage() throws IOException
  {
    Stage stage = new Stage();
    Scene scene = null;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;

    loader.setLocation(getClass().getResource("Homepage.fxml"));
    root = loader.load();

    HomepageController controller = loader.getController();

    controller.init(viewModelFactory, stage);


    stage.setTitle("MyFlixerJr");
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    this.closeLogIn();
  }
  public void openHomePageForSimpleUser() throws IOException
  {
    Stage stage = new Stage();
    Scene scene = null;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;

    loader.setLocation(getClass().getResource("Homepage.fxml"));
    root = loader.load();

    HomepageController controller = loader.getController();

    controller.init(viewModelFactory, stage);
    controller.getManageImage().setVisible(false);


    stage.setTitle("MyFlixerJr");
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    this.closeLogIn();
  }

  public void openView() throws IOException
  {
    Scene scene = null;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;

    loader.setLocation(getClass().getResource("LogIn.fxml"));
    root = loader.load();
    LoginController controller = loader.getController();
    controller.init(viewModelFactory, this);
    primaryStage.setTitle("LogIn");
    scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public void openCreateAccount() throws IOException
  {
    Scene scene = null;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;

    loader.setLocation(getClass().getResource("CreateAccount.fxml"));
    root = loader.load();
    CreateAccountController controller = loader.getController();
    controller.init(this, viewModelFactory);
    primaryStage.setTitle("LogIn");
    scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public void closeLogIn()
  {
    primaryStage.close();
  }


}
