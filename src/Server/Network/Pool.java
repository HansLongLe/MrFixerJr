package Server.Network;

import Client.Model.Moderator;
import Client.Model.SimpleUser;

import java.util.ArrayList;

public class Pool
{
  private ArrayList<ServerSocketHandler> connections;

  public Pool()
  {

  }

  public void addConnection(ServerSocketHandler serverSocketHandler)
  {
    connections.add(serverSocketHandler);
  }

  public void broadcast(ArrayList<Moderator> moderators, ArrayList<SimpleUser> simpleUsers)
  {

  }
}
