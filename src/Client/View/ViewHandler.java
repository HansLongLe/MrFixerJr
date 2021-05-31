package Client.View;

import Client.Model.Movie;
import Client.ViewModel.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;

/**
 * A class used for initializing FXMls and switching between them
 */

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

  /**
   * A method that changes the scene to homepage for simple user
   */

  public void openHomePageForSimpleUser() throws IOException, NotBoundException
  {
    Scene scene = null;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;

    loader.setLocation(getClass().getResource("Homepage.fxml"));
    root = loader.load();

    HomepageController controller = loader.getController();

    controller.init(viewModelFactory, this);
    controller.getManageImage().setVisible(false);


    primaryStage.setTitle("MyFlixerJr");
    scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
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
    primaryStage.setResizable(false);
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
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public void openWatchLater() throws IOException
  {
    Scene watchLaterScene = null;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;

    loader.setLocation(getClass().getResource("WatchLater.fxml"));

    root = loader.load();

    WatchLaterController controller = loader.getController();
    controller.init(viewModelFactory,this);
    watchLaterScene = new Scene(root);
    primaryStage.setScene(watchLaterScene);
    primaryStage.setResizable(false);
  }

  public void openWatched() throws IOException
  {
    Scene watchedScene = null;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;

    loader.setLocation(getClass().getResource("Watched.fxml"));

    root = loader.load();

    WatchedController controller = loader.getController();
    controller.init(viewModelFactory, this);
    watchedScene = new Scene(root);
    primaryStage.setScene(watchedScene);
    primaryStage.setResizable(false);
  }

  public void openHomePage() throws IOException, NotBoundException
  {
    Scene homepageScene = null;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;

    loader.setLocation(getClass().getResource("Homepage.fxml"));

    root = loader.load();

    HomepageController controller = loader.getController();
    controller.init(viewModelFactory, this );
    homepageScene = new Scene(root);
    primaryStage.setScene(homepageScene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public void openMovieManager() throws IOException
  {
    Scene scene = null;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;

    loader.setLocation(getClass().getResource("MovieManager.fxml"));
    root = loader.load();
    MovieManagerController controller = loader.getController();
    controller.init(viewModelFactory, this);
    primaryStage.setTitle("Admin window");
    scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public void openUserManager() throws IOException
  {
    Scene userScene = null;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;

    loader.setLocation(getClass().getResource("UserManager.fxml"));

    root = loader.load();

    UserManagerController controller = loader.getController();
    controller.init(viewModelFactory, this);
    userScene = new Scene(root);
    primaryStage.setScene(userScene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public void  openFavorite() throws IOException
  {
    Scene favoriteScene = null;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;

    loader.setLocation(getClass().getResource("Favorite.fxml"));

    root = loader.load();

    FavoriteController controller = loader.getController();
    controller.init(viewModelFactory, this);
    favoriteScene = new Scene(root);
    primaryStage.setScene(favoriteScene);
    primaryStage.setResizable(false);
  }

  public void openCreateMovie() throws IOException, NotBoundException {
    Scene scene = null;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;

    loader.setLocation(getClass().getResource("CreateMovie.fxml"));
    root = loader.load();
    CreateMovieController controller = loader.getController();
    controller.init(viewModelFactory,this);
    primaryStage.setTitle("Create Movie");
    scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public void openGenreManager() throws IOException, NotBoundException
  {
    Scene genreScene = null;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;

    loader.setLocation(getClass().getResource("GenreManager.fxml"));

    root = loader.load();
    GenreManagerController controller = loader.getController();
    controller.init(viewModelFactory, this);
    genreScene = new Scene(root);
    primaryStage.setScene(genreScene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public void openEditMovieDescription() throws IOException, NotBoundException {
    Scene scene = null;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;

    loader.setLocation(getClass().getResource("EditMovieDescription.fxml"));
    root = loader.load();
    EditMovieDescriptionController controller = loader.getController();
    controller.init(viewModelFactory,this);
    primaryStage.setTitle("Edit Movie");
    scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public void openViewMovieDescription(int currentMovie, ArrayList<Movie> movies) throws IOException, NotBoundException {
    Scene scene = null;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;

    loader.setLocation(getClass().getResource("ViewMovieDescription.fxml"));
    root = loader.load();
    ViewMovieDescriptionController controller = loader.getController();

    controller.init(viewModelFactory,this, currentMovie, movies);

    primaryStage.setTitle("View Movie");
    scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public String getUserName(){
    String username = viewModelFactory.getLoginViewModel().getUsername().getValue();
    return username;
  }

}
