package Client.Model;

import javafx.scene.image.Image;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface MovieDataModel {

    void addMovie( String title, String year, ArrayList<Object> chosenGenres, String description, String actors) throws RemoteException, NotBoundException, SQLException;
    ArrayList<String> getGenres() throws NotBoundException, RemoteException;
}
