package Client.View;

import Client.Model.Movie;
import Client.ViewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.text.Text;

import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ViewMovieDescriptionController {

    private ViewModelFactory viewModelFactory;
    private ViewHandler viewHandler;

    @FXML private Label name;
    @FXML private Label year;
    @FXML private Label genres;
    @FXML private Text description;
    @FXML private Text actors;
    @FXML private ImageView image;

    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler, int currentMovie) throws IOException, NotBoundException {
        this.viewModelFactory = viewModelFactory;
        this.viewHandler = viewHandler;
        loadInformation(currentMovie);
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

    public void setSceneToHomepage() throws IOException, NotBoundException {
        viewHandler.openHomePage();
    }


    public void logOut() throws IOException
    {
        viewHandler.start();
    }

    @FXML void addToWatchLater()
    {
        viewModelFactory.getMovieViewModel().addToWatchLater(getMovieId(name.getText(), description.getText()), viewModelFactory.getLoginViewModel().getUsername().getValue());

    }

    @FXML public void addToWatched()
        throws RemoteException
    {
        String title;
        String description;
        String username;
        title = name.getText();
        description = this.description.getText();
        username = viewModelFactory.getLoginViewModel().getUsername().getValue();
        viewModelFactory.getMovieViewModel().addToWatched(title,description,username);
    }

    @FXML public void addToFavorite()
        throws RemoteException
    {
        viewModelFactory.getMovieViewModel().addToFavorite(getMovieId(name.getText(), description.getText()), viewModelFactory.getLoginViewModel().getUsername().getValue());
    }


    public void loadInformation(int currentMovie) throws RemoteException {
        Movie movie = viewModelFactory.getMovieViewModel().getMovies().get(currentMovie);
        name.setText(movie.getTitle());
        year.setText(movie.getYear());
        description.setText(movie.getDescription());
        image.setImage(new Image(movie.getImageURL()));

        String genres = "";
        for (int i = 0; i < viewModelFactory.getMovieViewModel().getGenresForMovie(currentMovie+1).size(); i++) {
            genres += viewModelFactory.getMovieViewModel().getGenresForMovie(currentMovie+1).get(i);
            if (!(i == viewModelFactory.getMovieViewModel().getGenresForMovie(currentMovie+1).size()-1))
            {
                genres += ", ";
            }
        }
        this.genres.setText(genres);

        String actors = "";
        for (int i = 0; i < viewModelFactory.getMovieViewModel().getActorsForMovie(currentMovie+1).size(); i++) {
            actors += viewModelFactory.getMovieViewModel().getActorsForMovie(currentMovie+1).get(i);
            if (!(i == viewModelFactory.getMovieViewModel().getActorsForMovie(currentMovie+1).size()-1))
            {
                actors += ", ";
            }
        }
        this.actors.setText(actors);
    }

    public int getMovieId(String title, String description){
       return viewModelFactory.getMovieViewModel().getMovieId(title, description);
    }
}
