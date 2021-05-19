package Client.Model;

import java.rmi.RemoteException;

public interface GenreDataModel {
    void addGenre(String genreName) throws RemoteException;
    void removeGenre(String genreName);
    void changeGenre(String genreName);
}
