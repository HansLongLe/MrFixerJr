package Server.Network;

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

  public void sendToAdmin(ArrayList<Model.Moderator> moderators, ArrayList<Model.SimpleUser> simpleUsers)
  {

  }
}
