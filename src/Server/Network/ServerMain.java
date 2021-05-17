package Server.Network;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ServerMain
{
  public static void main(String[] args)
      throws RemoteException, AlreadyBoundException
  {
    System.out.println("Type in the password: \n");
    Scanner scanner = new Scanner(System.in);
    String password = scanner.nextLine();
    ServerInterface server = new ServerRMI();
    server.start();
  }
}
