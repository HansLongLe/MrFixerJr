package Client.Network;

import Client.Model.Movie;
import Client.Model.SimpleUser;
import Client.Model.User;
import javafx.scene.image.Image;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ClientInterface extends Remote {
  void startClient() throws RemoteException, NotBoundException;
  public void newUser(User user) throws RemoteException, NotBoundException;
  ArrayList<User> logIn() throws RemoteException, NotBoundException;
  void addGenre(String genre) throws RemoteException, NotBoundException;
  ArrayList<String> getExistingGenres() throws RemoteException, NotBoundException;
  String getRole(String username) throws RemoteException, NotBoundException;
  void removeGenre(String genreName) throws RemoteException;
  void addMovies(Movie movie) throws RemoteException, NotBoundException, SQLException;
  public void chooseThreeGenresForUser(String username, String firstGnere, String secondGnere, String thirdGnere) throws RemoteException;
  ArrayList<Movie> getMovies() throws RemoteException;
  ArrayList<Movie> getListOfFavouriteMovies(String username) throws RemoteException;
  ArrayList<Movie> loadMoviesByChosenGenre(String username) throws RemoteException;
  ArrayList<String> getGenresForMovie(int id) throws RemoteException;
  ArrayList<String> getActorsForMovie(int id) throws RemoteException;

  void addToFavorite(int id, String username) throws RemoteException;
  int getMovieId(String title, String description) throws RemoteException;
  void addToWatchLater(int id, String username) throws RemoteException;
}

