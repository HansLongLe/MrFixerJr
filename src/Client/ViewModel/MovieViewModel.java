package Client.ViewModel;

import Client.Model.MovieDataModel;
import javafx.scene.image.Image;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class MovieViewModel {
    private MovieDataModel movieDataModel;

    public MovieViewModel(MovieDataModel movieDataModel){
        this.movieDataModel = movieDataModel;
    }
    public void createMovie(Image image, String title, String year, ArrayList<Object> chosenGenres, String description, String actors) throws NotBoundException, RemoteException {
        movieDataModel.addMovie(image, title, year, chosenGenres, description, actors);
    }
    public ArrayList<String> getGenres() throws NotBoundException, RemoteException {
        return movieDataModel.getGenres();
    }

}
