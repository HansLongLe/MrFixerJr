package Server.Network;

import Client.Model.User;
import Client.Network.ClientInterface;

import java.rmi.Remote;

public interface ServerInterface extends Remote {
    void addBroadcast(ClientInterface clientReceiver);
    void newUser(User user);
}
