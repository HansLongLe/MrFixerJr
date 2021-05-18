package Client.Model;

import Client.Network.ClientInterface;
import Client.Network.ClientRMI;
import Server.Database.DatabaseConnection;
import Server.Network.ServerInterface;
import Server.Network.ServerRMI;
import org.junit.jupiter.api.Test;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static org.junit.jupiter.api.Assertions.*;

class UserModelManagerTest
{
  ServerInterface server = new ServerRMI("Hoytt200117");
  ClientInterface clientInterface = new ClientRMI();

  UserModelManagerTest() throws RemoteException
  {
  }

  @Test void logIn()
      throws NotBoundException, RemoteException, AlreadyBoundException
  {
    server.start();
    clientInterface.startClient();
    ClientInterface clientInterface = new ClientRMI();
    assertNotNull(clientInterface.logIn());
  }

  @Test void createAccount()
      throws RemoteException, NotBoundException, AlreadyBoundException
  {
    server.start();
    clientInterface.startClient();
    String username = "123";
    String password = "123";
    String email = "123";
    User user = new SimpleUser();
    user.set(username, password, email);

    clientInterface.newUser(user);
    assertNotNull(server.logIn());
  }
}