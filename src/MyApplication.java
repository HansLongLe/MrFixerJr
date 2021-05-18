import Client.Model.ModelFactory;
import Client.View.CreateMovieController;
import Client.View.HomepageController;
import Client.Model.UserModelManager;
import Client.Network.ClientFactory;
import Client.Network.ClientInterface;
import Client.Network.ClientRMI;
import Client.View.ViewHandler;
import Client.ViewModel.ViewModelFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.rmi.NotBoundException;

public class MyApplication extends Application
{
  public void start (Stage primaryStage)
      throws IOException, NotBoundException, InterruptedException
  {
    ClientFactory cf = new ClientFactory();

    ModelFactory modelFactory = new ModelFactory(cf);
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory, primaryStage);
    ClientInterface clientInterface = new ClientRMI();
    System.out.println(clientInterface);
    UserModelManager userModelManager = new UserModelManager(cf.getClientInterface());

    userModelManager.setClientInterface(clientInterface);
    viewHandler.start(primaryStage);
  }
}
