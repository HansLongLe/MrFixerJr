package Client.Model;

import Client.Network.ClientInterface;
import javafx.scene.image.Image;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class MovieDataModelManager implements MovieDataModel {
    private ClientInterface clientInterface;
    public MovieDataModelManager(ClientInterface clientInterface)
    {
        this.clientInterface = clientInterface;
    }
    @Override
    public void addMovie(Image image, String title, String year, ArrayList<Object> chosenGenres, String description, String actors) throws RemoteException, NotBoundException {
        Movie movie = new Movie(image, title,year,chosenGenres, description, actors);
        clientInterface.addMovies(movie);
    }

    @Override
    public ArrayList<String> getGenres() throws NotBoundException, RemoteException {
        return clientInterface.getExistingGenres();
    }

}
