package Client.View;

import Client.Model.Movie;
import Client.ViewModel.LoginViewModel;
import Client.ViewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.CheckComboBox;

import java.awt.*;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class HomepageController {

    private ViewModelFactory viewModelFactory;
    private Scene watchLaterScene;
    private Scene watchedScene;
    private Scene favoriteScene;
    private ViewHandler viewHandler;
    @FXML private CheckComboBox genresToChose;
    @FXML private VBox movies;

   @FXML private ImageView manageImage;

    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler)
        throws IOException, NotBoundException
    {
        this.viewModelFactory = viewModelFactory;
        this.viewHandler = viewHandler;
        loadMovies();
      LoginViewModel loginViewModel = viewModelFactory.getLoginViewModel();
      String role = loginViewModel.getRole(loginViewModel.getUsername().getValue());
      switch(loginViewModel.logIn()){
        case "true":
          if(role.equals("Admin") || role.equals("Moderator")){
            manageImage.setVisible(true);
          }
          else if(role.equals("SimpleUser")){
            manageImage.setVisible(false);
          }
          break;
      }
      for(int i=0; i<viewModelFactory.getGenreViewModel().getGenre().size(); i++){
        genresToChose.getItems().add(viewModelFactory.getGenreViewModel().getGenre().get(i));
      }


    }
    public ImageView getManageImage(){
        return manageImage;
    }

    public void openManageWindow() throws IOException {
        viewHandler.openMovieManager();
    }


    public void setSceneToWatchLater() throws IOException {
        viewHandler.openWatchLater();
    }
    public void setSceneToWatched() throws IOException {
        viewHandler.openWatched();
    }
    public void setSceneToFavorite() throws IOException {
       viewHandler.openFavorite();
    }

    public void logOut() throws IOException
    {
      viewHandler.start();
    }

  public void loadMovies() throws RemoteException
  {
    int count = 0;
    HBox newRow = new HBox();


    String username = viewHandler.getUserName();

    for (int i = 0; i <viewModelFactory.getMovieViewModel().loadMoviesByChosenGenre(username).size() ; i++) {
      Movie movie0 = viewModelFactory.getMovieViewModel().loadMoviesByChosenGenre(username).get(i);
      System.out.println(viewModelFactory.getMovieViewModel().getGenresForMovie(movie0.getMovieID()));
      VBox movie = new VBox();

      int currentMovie = i;
        movie.setOnMouseClicked(mouseEvent -> {
            try {
                openMovie(currentMovie);
            } catch (NotBoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        ImageView image = new ImageView(movie0.getImageURL());
      image.setFitWidth(150);
      image.setFitHeight(150);
      Label title = new Label(movie0.getTitle());
      Label year = new Label(movie0.getYear());
      String genres = "";
      for (int j = 0; j < viewModelFactory.getMovieViewModel().getGenresForMovie(movie0.getMovieID()).size(); j++) {
        genres += viewModelFactory.getMovieViewModel().getGenresForMovie(movie0.getMovieID()).get(j);

        if (!(j == viewModelFactory.getMovieViewModel().getGenresForMovie(movie0.getMovieID()).size()-1))
        {
          genres += ",";
        }
      }
      Label genreLabel = new Label(genres);
      movie.getChildren().addAll(image, title, year, genreLabel);


      newRow.getChildren().add(movie);

      count++;
      if (count % 3 == 0)
      {
        movies.getChildren().add(newRow);
        newRow = new HBox();
      }
    }
    movies.getChildren().add(newRow);

  }

  public void openMovie(int currentMovie) throws NotBoundException, IOException {
      viewHandler.openViewMovieDescription(currentMovie);
  }

}
