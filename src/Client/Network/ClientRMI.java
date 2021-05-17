package Client.Network;

import Client.Model.User;
import Client.ViewModel.ViewModelFactory;
import Server.Network.ServerInterface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ClientRMI  implements ClientInterface{
    private ServerInterface server;
    private ClientInterface broadcastClient;
    private ViewModelFactory viewModelFactory;

    public ClientRMI()
    {
//        this.viewModelFactory = viewModelFactory;
    }
    public void startClient() throws RemoteException, NotBoundException {
        UnicastRemoteObject.exportObject(this, 0);
        Registry registry = LocateRegistry.getRegistry("localHost", 1099);
        server = (ServerInterface) registry.lookup("Server");
        System.out.println(server + "Server in client");
//       broadcastClient = (ClientInterface) new ClientReceiver();
        server.addBroadcast(broadcastClient);
    }

    public void newUser(User user) throws RemoteException
    {
        System.out.println(server + "!!!!!!!!");
        server.newUser(user);

    }
}
