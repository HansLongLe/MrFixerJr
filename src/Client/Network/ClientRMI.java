package Client.Network;

import Client.Model.User;
import Client.ViewModel.ViewModelFactory;
import Server.Network.ServerInterface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientRMI {
    private ServerInterface server;
    private ClientInterface broadcastClient;
    private ViewModelFactory viewModelFactory;

    public ClientRMI(ViewModelFactory viewModelFactory)
    {
        this.viewModelFactory = viewModelFactory;
    }
    public void startClient() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localHost", 1099);
        server = (ServerInterface) registry.lookup("userServer");
        broadcastClient = new ClientReceiver(viewModelFactory);
        server.addBroadcast(broadcastClient);
    }

    public void newUser(User user)
    {
        server.newUser(user);
    }
}
