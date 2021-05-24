package Client.ViewModel;

import Client.Model.Movie;
import Client.Model.MovieDataModel;
import javafx.scene.image.Image;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieViewModel {
    private MovieDataModel movieDataModel;

    public MovieViewModel(MovieDataModel movieDataModel){
        this.movieDataModel = movieDataModel;
    }
    public void createMovie(String title, String year, ArrayList<Object> chosenGenres, String description, String actors) throws NotBoundException, RemoteException, SQLException {
        movieDataModel.addMovie( title, year, chosenGenres, description, actors);
    }
    public ArrayList<String> getGenres() throws NotBoundException, RemoteException {
        return movieDataModel.getGenres();
    }

    public ArrayList<Movie>  getListOfFavouriteMovies(String username){
        return movieDataModel.getListOfFavouriteMovies(username);
    }

}
