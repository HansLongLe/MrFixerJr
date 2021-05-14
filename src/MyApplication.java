import Client.Model.ModelFactory;
import Client.View.ViewHandler;
import Client.ViewModel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class MyApplication extends Application
{
  public void start (Stage primaryStage)
  {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory);

    viewHandler.start(primaryStage);
  }
}
