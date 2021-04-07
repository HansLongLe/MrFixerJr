package Server.Network;

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

  public void broadcast(ArrayList<Model.Moderator> moderators, ArrayList<Model.SimpleUser> simpleUsers)
  {

  }
}
