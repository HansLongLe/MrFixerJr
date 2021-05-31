package Client.Model;

import Client.Network.ClientFactory;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * A class used for initializing and getting all DataModels
 */

public class ModelFactory
{
    private User user;
    private ClientFactory cf;
    private MovieDataModel movie;
    private GenreDataModel genre;

    public ModelFactory(ClientFactory cf){
        this.cf = cf;
    }


    public User getUser()
        throws RemoteException, NotBoundException, InterruptedException
    {
        if(user==null){
            user = new UserModelManager(cf.getClientInterface());
        }
        return user;
    }
    public MovieDataModel getMovieDataModel(){
        if (movie==null){
            movie = new MovieDataModelManager(cf.getClientInterface());
        }
        return movie;
    }

    public GenreDataModel getGenreDataModel() {
        if (genre == null)
        {
            genre = new GenreModelManager(cf.getClientInterface());
        }
        return genre;
    }
}
