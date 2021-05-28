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
import java.util.ArrayList;

public class ViewMovieDescriptionController {

    private ViewModelFactory viewModelFactory;
    private ViewHandler viewHandler;

    @FXML private Label name;
    @FXML private Label year;
    @FXML private Label genres;
    @FXML private Text description;
    @FXML private Text actors;
    @FXML private ImageView image;

    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler, int currentMovie, ArrayList<Movie> movies) throws IOException, NotBoundException {
        this.viewModelFactory = viewModelFactory;
        this.viewHandler = viewHandler;
        loadInformation(currentMovie, movies);
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
        System.out.println(viewModelFactory.getMovieViewModel().getMovies().get(0).getTitle() + "!!!!!!!!!!!!!!!!!!!!!!");
    public void loadInformation(int currentMovie, ArrayList<Movie> movies) throws RemoteException {
        Movie movie = movies.get(currentMovie);
        System.out.println(movie.getTitle());
        System.out.println(currentMovie);
        name.setText(movie.getTitle());
        year.setText(movie.getYear());
        description.setText(movie.getDescription());
        image.setImage(new Image(movie.getImageURL()));

        String genres = "";
        for (int i = 0; i < movies.get(currentMovie).getGenres().size(); i++) {
            genres += movies.get(currentMovie).getGenres().get(i);
            if (!(i == movies.get(currentMovie).getGenres().size()-1))
            {
                genres += ", ";
            }
        }
        this.genres.setText(genres);

        String actors = "";
        for (int i = 0; i < movies.get(currentMovie).getActors().length; i++) {
            actors += movies.get(currentMovie).getActors()[i];
            if (!(i == movies.get(currentMovie).getActors().length-1))
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
