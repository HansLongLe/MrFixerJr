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

public class ClientRMI  implements ClientInterface, Serializable
{
    private ServerInterface server;
    private ClientInterface broadcastClient;
    private ViewModelFactory viewModelFactory;

    public ClientRMI()
    {
        this.viewModelFactory = viewModelFactory;
    }
    public void startClient() throws RemoteException, NotBoundException {
        UnicastRemoteObject.exportObject(this, 0);
        Registry registry = LocateRegistry.getRegistry("localHost", 1099);
        server = (ServerInterface) registry.lookup("Server");
//       broadcastClient = (ClientInterface) new ClientReceiver();
        server.addBroadcast(broadcastClient);
    }

    @Override public void newUser(User user) throws RemoteException, NotBoundException
    {
        Registry registry = LocateRegistry.getRegistry("localHost", 1099);
        server = (ServerInterface) registry.lookup("Server");
        System.out.println(server + "!!!!!!!!");
        server.newUser(user);


    }

    @Override public ArrayList<User> logIn()
        throws RemoteException, NotBoundException
    {
        Registry registry = LocateRegistry.getRegistry("localHost", 1099);
        server = (ServerInterface) registry.lookup("Server");
        return server.logIn();
    }

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

}
