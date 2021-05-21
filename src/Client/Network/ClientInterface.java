package Client.Network;

import Client.Model.Movie;
import Client.Model.SimpleUser;
import Client.Model.User;
import javafx.scene.image.Image;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.util.ArrayList;

public interface ClientInterface extends Remote {
  void startClient() throws RemoteException, NotBoundException;
  public void newUser(User user) throws RemoteException, NotBoundException;
  ArrayList<User> logIn() throws RemoteException, NotBoundException;
  void addGenre(String genre) throws RemoteException, NotBoundException;
  ArrayList<String> getExistingGenres() throws RemoteException, NotBoundException;
  String getRole(String username) throws RemoteException, NotBoundException;
  void removeGenre(String genreName) throws RemoteException;
  void addMovies(Movie movie) throws RemoteException, NotBoundException;
}
