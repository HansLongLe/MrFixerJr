package Server.Network;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * A class used for starting the server
 */
public class ServerMain
{
  public static void main(String[] args)
      throws RemoteException, AlreadyBoundException
  {
    System.out.println("Type in the password: ");
    Scanner scanner = new Scanner(System.in);
    String databasePassword = scanner.next();
    ServerInterface server = new ServerRMI(databasePassword);
    server.start();
  }
}
