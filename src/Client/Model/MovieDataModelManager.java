package Client.Model;

import Client.Network.ClientInterface;
import javafx.scene.image.Image;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * A class used for managing logic part of the movie administration
 */

public class MovieDataModelManager implements MovieDataModel {
    private ClientInterface clientInterface;
    public MovieDataModelManager(ClientInterface clientInterface)
    {
        this.clientInterface = clientInterface;
    }

    /**
     * A method used for creating new movie and sending these information to the server
     * @param actor is a string of all the actors that will be split by ", "
     */

    @Override
    public void addMovie(String imageURL, String title, String year, ArrayList<Object> chosenGenres, String description, String actor) throws RemoteException, NotBoundException, SQLException {
        String[] actors = actor.split(", ");
        Movie movie = new Movie(imageURL, title,year,chosenGenres, description, actors);
        clientInterface.addMovies(movie);
    }



    @Override
    public ArrayList<String> getGenres() throws NotBoundException, RemoteException {
        return clientInterface.getExistingGenres();
    }

    public ArrayList<Movie> getListOfFavouriteMovies(String username){
        try
        {
            return clientInterface.getListOfFavouriteMovies(username);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Movie> getMovies() throws RemoteException {
        return clientInterface.getMovies();
    }

    /**
     * A method for getting sorted movies by the 3 favorite genres that have been chosen when creating an account
     */

    @Override public ArrayList<Movie> loadMoviesByChosenGenre(String username)
        throws RemoteException
    {
        return clientInterface.loadMoviesByChosenGenre(username);
    }

    /**
     * A method for getting all genres for specific movie with the movie id
     */

    @Override public ArrayList<String> getGenresForMovie(int id)
        throws RemoteException
    {
        return clientInterface.getGenresForMovie(id);
    }

    /**
     * A method for getting all actors for specific movie with the movie id
     */

    @Override
    public ArrayList<String> getActorsForMovie(int id) throws RemoteException {
        return clientInterface.getActorsForMovie(id);
    }

    /**
     * A method for adding a movie to Watched list
     */

    @Override public void addToWatched(String title, String description,
        String username) throws RemoteException
    {
        clientInterface.addToWatched(title,description,username);
    }
    @Override public void addToFavorite(int id,  String username)
        throws RemoteException
    {
        clientInterface.addToFavorite(id, username);
    }


    @Override public int getMovieId(String title, String description)
        throws RemoteException
    {
        return clientInterface.getMovieId(title, description);
    }

    @Override public void addToWatchLater(int id, String username)
    {
        try
        {
            clientInterface.addToWatchLater(id, username);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
    }

    @Override public ArrayList<Movie> loadWatchLater(String username)
        throws RemoteException
    {
        return clientInterface.loadWatchLater(username);
    }

    @Override public ArrayList<Movie> loadAlreadyWatched(String username)
        throws RemoteException
    {
        return clientInterface.loadAlreadyWatched(username);
    }

    /**
     * A method for getting sorted movies by genres that have been chosen on the homepage
     */

    @Override
    public ArrayList<Movie> sortMoviesByGenres(ArrayList<String> chosenGenres) throws RemoteException, SQLException {
        return clientInterface.sortMoviesByGenres(chosenGenres);
    }

    /**
     * A method for searching specific movies by part of their name or their full name
     * @param searchText text that will be searched by
     */

    @Override
    public ArrayList<Movie> searchByTitle(String searchText) throws RemoteException, SQLException {
        return clientInterface.searchByTitle(searchText);
    }


}
