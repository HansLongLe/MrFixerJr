package Client.View;

import Client.Model.Movie;
import Client.ViewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;

public class FavoriteController {

    private ViewModelFactory viewModelFactory;
    private Scene watchLaterScene;
    private Scene watchedScene;
    private Scene homepageScene;
    private ViewHandler viewHandler;
    @FXML private ImageView manageImage;


    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler) throws IOException {
        this.viewModelFactory = viewModelFactory;
        this.viewHandler = viewHandler;
        getfavouriteMovies();
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
    public void setSceneToHomepage() throws IOException, NotBoundException
    {
        viewHandler.openHomePage();
    }

    public void logOut() throws IOException
    {
        viewHandler.start();
    }

    public void getfavouriteMovies(){
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies = viewModelFactory.getMovieViewModel().getListOfFavouriteMovies(viewHandler.getUserName());
        System.out.println(movies);
    }


}
