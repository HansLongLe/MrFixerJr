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


  public void openHomePageForSimpleUser() throws IOException
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
  }

  public void openHomepage() throws IOException
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
  }

  public void openCreateMovie() throws IOException
  {
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
    primaryStage.show();
  }

  public void openGenreManager() throws IOException
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
    primaryStage.show();
  }

  public void closeLogIn()
  {
    primaryStage.close();
  }


}
