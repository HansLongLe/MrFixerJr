package Client.ViewModel;

import Client.Model.MovieDataModel;

import java.util.ArrayList;

public class MovieViewModel {
    private MovieDataModel movieDataModel;

    public MovieViewModel(MovieDataModel movieDataModel){
        this.movieDataModel = movieDataModel;
    }
    public void createMovie(String title, String year, ArrayList<String> genres, String description, String actors){
        movieDataModel.addMovie(title, year, genres, description, actors);
    }
}
