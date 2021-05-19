package Client.Model;

import Client.Network.ClientInterface;

import java.rmi.RemoteException;

public class GenreModelManager implements GenreDataModel{

    private ClientInterface clientInterface;
    public GenreModelManager(ClientInterface clientInterface)
    {
        this.clientInterface = clientInterface;
    }
    @Override
    public void addGenre(String genreName) throws RemoteException {
        clientInterface.addGenre(genreName);
    }

    @Override
    public void removeGenre(String genreName) {

    }

    @Override
    public void changeGenre(String genreName) {

    }
}
