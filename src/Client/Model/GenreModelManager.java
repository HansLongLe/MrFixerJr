package Client.Model;

import Client.Network.ClientInterface;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class GenreModelManager implements GenreDataModel{

    private ClientInterface clientInterface;
    public GenreModelManager(ClientInterface clientInterface)
    {
        this.clientInterface = clientInterface;
    }
    @Override
    public void addGenre(String genreName, boolean genreExists) throws RemoteException {
        clientInterface.addGenre(genreName, genreExists);
    }

    @Override
    public void removeGenre(String genreName) {

    }

    @Override
    public void changeGenre(String genreName) {

    }
}
