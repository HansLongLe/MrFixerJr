package Client.Network;

import Client.ViewModel.ViewModelFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientReceiver implements ClientInterface{
    private ViewModelFactory viewModelFactory;

    public ClientReceiver(ViewModelFactory viewModelFactory)
    {
        this.viewModelFactory = viewModelFactory;
        try {
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
