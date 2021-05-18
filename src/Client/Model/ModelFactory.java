package Client.Model;

import Client.Network.ClientFactory;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ModelFactory
{
    private User user;
    private ClientFactory cf;
    private MovieDataModel movie;

    //    private ClientInterface clientInterface;
//
//    public ClientInterface getClientInterface(){
//        if(clientInterface==null){
//            clientInterface = new ClientRMI()
//        }
//    }

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
            movie = new MovieDataModelManager();
        }
        return movie;
    }
}
