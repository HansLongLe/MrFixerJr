package Client.Network;

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
