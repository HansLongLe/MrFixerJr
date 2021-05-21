package Client.Model;

import javafx.scene.image.Image;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MovieDataModel {

    void addMovie(Image image, String title, String year, ArrayList<Object> chosenGenres, String description, String actors) throws RemoteException, NotBoundException;
    ArrayList<String> getGenres() throws NotBoundException, RemoteException;
}
