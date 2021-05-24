package Client.Model;

import Client.Network.ClientInterface;
import javafx.scene.image.Image;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieDataModelManager implements MovieDataModel {
    private ClientInterface clientInterface;
    public MovieDataModelManager(ClientInterface clientInterface)
    {
        this.clientInterface = clientInterface;
    }
    @Override
    public void addMovie( String title, String year, ArrayList<Object> chosenGenres, String description, String actors) throws RemoteException, NotBoundException, SQLException {
        Movie movie = new Movie( title,year,chosenGenres, description, actors);
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

}
