package Client.View;

import Client.Model.Movie;
import Client.ViewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;

/**
 * A class used for giving functionality to WatchedLater FXML
 */

public class WatchLaterController{

    private ViewModelFactory viewModelFactory;
    private ViewHandler viewHandler;
    @FXML private VBox movies0;
    private ArrayList<Movie> watchLaterMovies;



    public void init(ViewModelFactory viewModelFactory,ViewHandler viewHandler) throws IOException {
        this.viewModelFactory = viewModelFactory;
        this.viewHandler = viewHandler;
        getWatchLaterMoviesList();
    }

    public void setSceneToHomepage() throws IOException, NotBoundException
    {
        viewHandler.openHomePage();
    }
    public void setSceneToWatched() throws IOException {
        viewHandler.openWatched();
    }
    public void setSceneToFavorite() throws IOException {
       viewHandler.openFavorite();
    }

    public void logOut() throws IOException
    {
        viewHandler.start();
    }

    public void getWatchLaterMoviesList(){
        String username = viewHandler.getUserName();

        watchLaterMovies = viewModelFactory.getMovieViewModel().getListOfAlreadyWatchedMovies(username);
        int count = 0;
        HBox newRow = new HBox();



        for (int i = 0; i <watchLaterMovies.size() ; i++) {
            Movie movie0 = watchLaterMovies.get(i);
            VBox movie = new VBox();
            movie.setPrefWidth(216);
            movie.setPrefHeight(143);
            movie.setPadding(new Insets(15));

            int currentMovie = viewModelFactory.getMovieViewModel().getMovieId(movie0.getTitle(), movie0.getDescription());
            System.out.println(currentMovie + " Current movie ID");
            System.out.println(movie0.getMovieID()+" !!!!!!!!!!@");
            movie.setOnMouseClicked(mouseEvent -> {
                try {
                    openMovie(currentMovie-1);
                } catch (NotBoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            ImageView image = new ImageView(movie0.getImageURL());
            image.setFitWidth(113);
            image.setFitHeight(150);
            Label title = new Label(movie0.getTitle());
            Label year = new Label(movie0.getYear());
            String genres = "";
            for (int j = 0; j < movie0.getGenres().size(); j++) {
                genres += movie0.getGenres().get(j);

                if (!(j == movie0.getGenres().size()-1))
                {
                    System.out.println(movie0.getGenres().size());
                    genres += ",";
                }

            }

            Label genreLabel = new Label(genres);
            movie.getChildren().addAll(image, title, year, genreLabel);



            newRow.getChildren().add(movie);

            count++;
            if (count % 3 == 0)
            {
                movies0.getChildren().add(newRow);
                newRow = new HBox();
            }
        }
        movies0.getChildren().add(newRow);

        System.out.println("Loaded already watched movies");
    }

    public void openMovie(int currentMovie) throws NotBoundException, IOException {
        viewHandler.openViewMovieDescription(currentMovie, watchLaterMovies);
    }

}
