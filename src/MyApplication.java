import Client.Model.ModelFactory;
import Client.View.ViewHandler;
import Client.ViewModel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MyApplication extends Application
{
  public void start (Stage primaryStage) throws IOException
  {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory, primaryStage);

    viewHandler.start(primaryStage);
  }
}
