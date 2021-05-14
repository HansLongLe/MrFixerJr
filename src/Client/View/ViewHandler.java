package Client.View;

import Client.ViewModel.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;


public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private ViewModelFactory modelFactory;

  private CreateAccountController createAccountController;
  private LoginController loginController;

  public ViewHandler(ViewModelFactory ViewModel)
  {
    this.modelFactory = ViewModel;
  }

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    openView("LogIn");
  }

  public void openView(String id)
  {
    Region root = null;
    switch (id)
    {
      case "CreateAccount":
        root = openCreateAccount("CreateAccount.fxml");
        break;
      case "LogIn":
        root = openLogIn("LogIn.fxml");
        break;
    }

    currentScene.setRoot(root);
    String title = "";
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }

    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.show();
  }

  public Region openCreateAccount(String fxml)
  {
    if (createAccountController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxml));
        Region root = loader.load();
        createAccountController = loader.getController();
        createAccountController.init(this,modelFactory.getCreateAccountViewModel(), root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      createAccountController.reset();
    }
    return createAccountController.getRegion();
  }

  public Region openLogIn(String fxml)
  {
    if (loginController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxml));
        Region root = loader.load();
        loginController = loader.getController();
        loginController.init(this,modelFactory.getLoginViewModel(), root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      loginController.reset();
    }
    return loginController.getRegion();
  }
}
