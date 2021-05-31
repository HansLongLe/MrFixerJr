package Client.View;

import Client.Model.ModelFactory;
import Client.View.ViewHandler;

import Client.ViewModel.CreateAccountViewModel;
import Client.ViewModel.GenreViewModel;
import Client.ViewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * A class used for giving functionality to CreateAccount FXML
 */

public class CreateAccountController {
  @FXML private TextField username;
  @FXML private Label error;
  @FXML private PasswordField password;
  @FXML private PasswordField repeatPassword;
  @FXML private TextField email;
  @FXML private ComboBox firstGenre;
  @FXML private ComboBox secondGenre;
  @FXML private ComboBox thirdGenre;
  private String firstGnere;
  private String secondGnere;
  private String thirdGnere;



  private ViewModelFactory viewModelFactory;
  private CreateAccountViewModel createAccountViewModel;
  private ViewHandler viewHandler;
  private GenreViewModel genreViewModel;


  public void init( ViewHandler viewHandler, ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    this.viewModelFactory = viewModelFactory;
    genreViewModel = viewModelFactory.getGenreViewModel();
    createAccountViewModel = viewModelFactory.getCreateAccountViewModel();

    for (int i = 0; i < genreViewModel.getGenre().size(); i++)
    {

      firstGenre.getItems().add(genreViewModel.getGenre().get(i));
      secondGenre.getItems().add(genreViewModel.getGenre().get(i));
      thirdGenre.getItems().add(genreViewModel.getGenre().get(i));

    }
  }

  public void saveThreeGenresToUser(String username, String firstGenre1, String secondGenre2, String thirdGenre3)
      throws RemoteException
  {
    firstGenre1 = firstGenre.getValue().toString();
    secondGenre2 = secondGenre.getValue().toString();
    thirdGenre3 = thirdGenre.getValue().toString();

    firstGnere=firstGenre1;
    secondGnere=secondGenre2;
    thirdGnere=thirdGenre3;
    username = this.username.getText();
    createAccountViewModel.chooseThreeGenresForUser(username, firstGnere, secondGnere, thirdGnere);

    System.out.println(firstGenre1);
  }

  /**
   * A method used for creating an account
   */

  public void createButton() throws IOException, NotBoundException {
    if ((password.getText().equals(repeatPassword.getText()))) {
      createAccountViewModel.createAccount(username.getText(), password.getText(), email.getText());
      saveThreeGenresToUser(username.getText(), firstGnere, secondGnere, thirdGnere);
      error.setVisible(false);
      viewHandler.openView();
    } else {
      error.setVisible(true);
    }
  }

  /**
   *  A method used for going to the Login
   */

  public void goBack() throws IOException {
    viewHandler.openView();
  }

}

