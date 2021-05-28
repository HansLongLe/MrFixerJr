package Client.Model;

import javafx.scene.image.Image;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface MovieDataModel {

    void addMovie(String imageURL, String title, String year, ArrayList<Object> chosenGenres, String description, String actors) throws RemoteException, NotBoundException, SQLException;
    ArrayList<String> getGenres() throws NotBoundException, RemoteException;
    ArrayList<Movie> getListOfFavouriteMovies(String username);
    ArrayList<Movie> getMovies() throws RemoteException;
    ArrayList<Movie> loadMoviesByChosenGenre(String username) throws RemoteException;
    ArrayList<String> getGenresForMovie(int id) throws RemoteException;
    ArrayList<String> getActorsForMovie(int id) throws RemoteException;

    void addToWatched(String title, String description, String username)
        throws RemoteException;
  void addToFavorite (int id, String username) throws RemoteException;
  int getMovieId(String title, String description) throws RemoteException;
  void addToWatchLater(int id, String username);
}
