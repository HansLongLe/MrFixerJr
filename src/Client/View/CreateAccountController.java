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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateAccountController
{
  @FXML private TextField username;
  @FXML private PasswordField password;
  @FXML private PasswordField repeatPassword;
  @FXML private TextField email;
  @FXML private Button create;
  @FXML private Button back;

  private ViewModelFactory viewModelFactory;
  private Region region;
  private ViewHandler viewHandler;

  public void init( ViewHandler viewHandler, ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    this.viewModelFactory = viewModelFactory;

  }
  @FXML
  public void CreateButton() throws IOException {
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
  }

    public void goBack () throws IOException
    {
    viewHandler.openView();
  }

    public void reset () {
  }

    public Region getRegion () {
    return region;
  }
  }

