package Client.Model;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface GenreDataModel {
    void addGenre(String genreName)
        throws RemoteException, NotBoundException;
    void removeGenre(String genreName) throws RemoteException;
    ArrayList<String> getGenre();
}
