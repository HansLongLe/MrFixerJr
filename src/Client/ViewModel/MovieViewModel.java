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
    public void createMovie(String imageURL, String title, String year, ArrayList<Object> chosenGenres, String description, String actors) throws NotBoundException, RemoteException, SQLException {
        movieDataModel.addMovie(imageURL, title, year, chosenGenres, description, actors);
    }
    public ArrayList<String> getGenres() throws NotBoundException, RemoteException {
        return movieDataModel.getGenres();
    }
    public ArrayList<Movie> getMovies() throws RemoteException {
        return movieDataModel.getMovies();
    }

    public ArrayList<Movie>  getListOfFavouriteMovies(String username){
        return movieDataModel.getListOfFavouriteMovies(username);
    }

    public ArrayList<Movie> loadMoviesByChosenGenre(String username)
    {
        try
        {
           return movieDataModel.loadMoviesByChosenGenre(username);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getGenresForMovie(int id){
        try
        {
            return movieDataModel.getGenresForMovie(id);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<String> getActorsForMovie(int id){
        try {
            return movieDataModel.getActorsForMovie(id);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addToFavorite(int id, String username) throws RemoteException
    {
        movieDataModel.addToFavorite(id, username);
    }

    public int getMovieId(String title, String description){
        try
        {
            return movieDataModel.getMovieId(title, description);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    public void addToWatchLater(int id, String username)
    {
        movieDataModel.addToWatchLater(id, username);
    }
}
