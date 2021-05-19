package Client.Network;

import Client.Model.SimpleUser;
import Client.Model.User;
import Client.ViewModel.ViewModelFactory;
import Server.Network.ServerInterface;

import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
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
//        UnicastRemoteObject.exportObject(this, 0);
        Registry registry = LocateRegistry.getRegistry("localHost", 1099);
        server = (ServerInterface) registry.lookup("Server");
//       broadcastClient = (ClientInterface) new ClientReceiver();
        server.addBroadcast(broadcastClient);
    }

    @Override public void newUser(User user) throws RemoteException, NotBoundException
    {

        System.out.println(server + "!!!!!!!!");
        server.newUser(user);


    }

    @Override public ArrayList<User> logIn()
        throws RemoteException, NotBoundException
    {
//
        return server.logIn();
    }

    @Override public String getRole(String username) throws RemoteException
    {
        return server.getRole(username);
    }

    @Override
    public void addGenre(String genre)
        throws RemoteException, NotBoundException
    {

        server.addGenre(genre);
    }

    @Override
    public ArrayList<String> getExistingGenres()

    {


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


}
