package Server.Network;

import Client.Model.Movie;
import Client.Model.SimpleUser;
import Client.Model.User;
import Client.Network.ClientInterface;
import javafx.scene.image.Image;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ServerInterface extends Remote {
    void addBroadcast(ClientInterface clientReceiver) throws RemoteException;
    void newUser(User user) throws RemoteException;
    void start() throws RemoteException, AlreadyBoundException;
    ArrayList<User> logIn() throws RemoteException;
    void addGenre(String genre) throws RemoteException;
    ArrayList<String> getGenresFromDatabase() throws RemoteException;
    String getRole(String username) throws RemoteException;
    void addMovieToDatabase(Movie movie) throws RemoteException, SQLException;
    void removeGenre(String genreName) throws RemoteException;
  void chooseThreeGenresForUser(String username, String firstGnere, String secondGnere, String thirdGnere) throws RemoteException;
    ArrayList<Movie> loadFavouriteList(String username) throws RemoteException;
  ArrayList<Movie> getMovies() throws RemoteException;
  ArrayList<Movie> loadMoviesByChosenGenre(String username) throws RemoteException;
  ArrayList<String> getGenresForMovie(int id) throws RemoteException;
    ArrayList<String> getActorsForMovie(int id) throws RemoteException;
    void addToWathced(String title, String description,String username) throws RemoteException;
  void addTofavorite(int id, String username) throws RemoteException;
  int getMovieid(String title, String description) throws RemoteException;
  void addToWatchlater(int id, String username) throws RemoteException;
}

