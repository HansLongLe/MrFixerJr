package Client.Model;

import Client.Network.ClientInterface;

import java.util.ArrayList;

public class MovieDataModelManager implements MovieDataModel {
    private ClientInterface clientInterface;
    @Override
    public void addMovie(String title, String year, ArrayList<String> genres, String description, String actors){
        Movie movie = new Movie(title, year, genres);
        movie.setDescription(description);
        movie.setActors(actors);
    }

}
