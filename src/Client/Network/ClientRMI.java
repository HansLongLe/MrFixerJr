package Client.Network;

import Client.Model.Movie;
import Client.Model.SimpleUser;
import Client.Model.User;
import Client.ViewModel.ViewModelFactory;
import Server.Network.ServerInterface;
import javafx.scene.image.Image;

import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * A class used for initializing client connection
 */

public class ClientRMI  implements ClientInterface, Serializable
{
    private ServerInterface server;

    /**
     * A method for getting an object of the server from the registry
     */
    public void startClient() throws RemoteException, NotBoundException {
        UnicastRemoteObject.exportObject(this, 0);
        Registry registry = LocateRegistry.getRegistry("localHost", 1099);
        server = (ServerInterface) registry.lookup("Server");
    }

    /**
     * A method used for sending information about the user to the server when creating an account
     */

    @Override public void newUser(SimpleUser user) throws RemoteException, NotBoundException
    {
        Registry registry = LocateRegistry.getRegistry("localHost", 1099);
        server = (ServerInterface) registry.lookup("Server");
        System.out.println(server + "!!!!!!!!");
        server.newUser(user);


    }

    /**
     * A method used for receiving all users from the server, for thr purpose of checking valid username and password, when trying to log in
     */

    @Override public ArrayList<SimpleUser> logIn()
        throws RemoteException, NotBoundException
    {
        Registry registry = LocateRegistry.getRegistry("localHost", 1099);
        server = (ServerInterface) registry.lookup("Server");
        return server.logIn();
    }

    /**
     * A method used for getting a role of specific user from the server
     */

    @Override public String getRole(String username)
        throws RemoteException, NotBoundException
    {
        Registry registry = LocateRegistry.getRegistry("localHost", 1099);
        server = (ServerInterface) registry.lookup("Server");
        return server.getRole(username);
    }

    @Override public void removeGenre(String genreName) throws RemoteException
    {
        server.removeGenre(genreName);
    }

    @Override public void chooseThreeGenresForUser(String username, String firstGenre, String secondGenre, String thirdGenre)
        throws RemoteException
    {
        server.chooseThreeGenresForUser(username, firstGenre, secondGenre, thirdGenre);
    }

    @Override
    public ArrayList<Movie> getMovies() throws RemoteException {
        return server.getMovies();
    }

    @Override
    public void addMovies(Movie movie) throws RemoteException, NotBoundException, SQLException {
        Registry registry = LocateRegistry.getRegistry("localHost", 1099);
        server = (ServerInterface) registry.lookup("Server");
        server.addMovieToDatabase(movie);
    }

    @Override
    public void addGenre(String genre)
        throws RemoteException, NotBoundException
    {
        Registry registry = LocateRegistry.getRegistry("localHost", 1099);
        server = (ServerInterface) registry.lookup("Server");
        server.addGenre(genre);
    }

    @Override
    public ArrayList<String> getExistingGenres()
        throws RemoteException, NotBoundException

    {

        Registry registry = LocateRegistry.getRegistry("localHost", 1099);
        server = (ServerInterface) registry.lookup("Server");
        try
        {
            return server.getGenresFromDatabase();
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        return null;
    }



    @Override public ArrayList<Movie> loadMoviesByChosenGenre(String username)
    {
        try
        {
            return server.loadMoviesByChosenGenre(username);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override public ArrayList<String> getGenresForMovie(int id)
        throws RemoteException
    {
        return server.getGenresForMovie(id);
    }

    @Override
    public ArrayList<String> getActorsForMovie(int id) throws RemoteException {
        return server.getActorsForMovie(id);
    }

    @Override public void addToWatched(String title, String description,
        String username) throws RemoteException
    {
        server.addToWathced(title,description,username);
    }

    @Override public void addToFavorite(int id, String username)
        throws RemoteException
    {
        server.addTofavorite(id, username);
    }

    /**
     * A method for getting a specific movie id using 2 elements that will differentiate all the movies from each other
     */

    @Override public int getMovieId(String title, String description)
        throws RemoteException
    {
        return server.getMovieid(title, description);
    }

    @Override public void addToWatchLater(int id, String username)
    {
        try
        {
            server.addToWatchlater(id, username);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
    }

    @Override public ArrayList<Movie> loadWatchLater(String username)
        throws RemoteException
    {
        return server.loadWatchLater(username);
    }

    @Override public ArrayList<Movie> loadAlreadyWatched(String username)
        throws RemoteException
    {
        return server.loadAlreadyWatched(username);
    }
    public ArrayList<Movie> getListOfFavouriteMovies(String username){
        try
        {
            return server.loadFavouriteList(username);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Movie> searchByTitle(String searchText) throws RemoteException, SQLException {
        return server.searchByTitle(searchText);
    }

    @Override
    public ArrayList<Movie> sortMoviesByGenres(ArrayList<String> chosenGenres) throws RemoteException, SQLException {
        return server.sortMoviesByGenres(chosenGenres);
    }

}
