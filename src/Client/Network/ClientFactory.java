package Client.Network;

/**
 * A class used for initializing and getting clientInterface
 */

public class ClientFactory
{
  private ClientInterface clientInterface;
  public ClientInterface getClientInterface(){
    if(clientInterface==null){
      clientInterface = new ClientRMI();
    }
    return clientInterface;
  }
}
