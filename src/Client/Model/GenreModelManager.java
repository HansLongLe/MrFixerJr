package Client.Model;

import Client.Network.ClientInterface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class GenreModelManager implements GenreDataModel{

    private ClientInterface clientInterface;
    public GenreModelManager(ClientInterface clientInterface)
    {
        this.clientInterface = clientInterface;
    }
    @Override
    public void addGenre(String genreName)
        throws RemoteException, NotBoundException
    {
        clientInterface.addGenre(genreName);
    }

    @Override
    public void removeGenre(String genreName) throws RemoteException
    {
        clientInterface.removeGenre(genreName);
    }

    @Override
    public void changeGenre(String genreName) {

    }

    @Override public ArrayList<String> getGenre()
    {
        try
        {
            return clientInterface.getExistingGenres();
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        catch (NotBoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
