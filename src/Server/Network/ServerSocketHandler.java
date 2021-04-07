package Server.Network;

import Client.Model.Moderator;
import Client.Model.SimpleUser;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerSocketHandler implements Runnable
{
  private ObjectOutputStream out;
  private ObjectInputStream in;
  public Socket socket;
  private Pool pool;

  public ServerSocketHandler(Socket socket, Pool pool)
  {

  }

  public void run()
  {

  }

  public void sendToAdmin(ArrayList<Moderator> moderators, ArrayList<SimpleUser> simpleUsers)
  {

  }
}
