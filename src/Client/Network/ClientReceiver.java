package Client.Network;

import Client.Model.SimpleUser;
import Client.Model.User;
import Client.ViewModel.ViewModelFactory;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

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

    @Override public void startClient()
        throws RemoteException, NotBoundException
    {

    }

    @Override public void newUser(User user) throws RemoteException
    {

    }

    @Override public ArrayList<SimpleUser> logIn() throws RemoteException
    {
        return null;
    }
}
