package Client.Network;

import Client.Model.*;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocketHandler implements Runnable
{
  private ObjectInputStream in;
  private ObjectOutputStream out;
  private Socket socket;

  public ClientSocketHandler(Socket socket)
  {
    this.socket = socket;
  }

  public void run()
  {

  }

  public void sendUser(User user)
  {

  }
}