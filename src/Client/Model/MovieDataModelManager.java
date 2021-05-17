package Client.Model;

import java.util.ArrayList;

public class MovieDataModelManager implements MovieDataModel {
    @Override
    public void addMovie(String title, String year, ArrayList<String> genres, String description, String actors){
        Movie movie = new Movie(title, year, genres);
        movie.setDescription(description);
        movie.setActors(actors);
    }
}
