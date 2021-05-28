package Client.View;

import Client.Model.Movie;
import Client.ViewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;

public class FavoriteController {

    private ViewModelFactory viewModelFactory;
    private Scene watchLaterScene;
    private Scene watchedScene;
    private Scene homepageScene;
    private ViewHandler viewHandler;
    @FXML private ImageView manageImage;
    @FXML private VBox movies0;



    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler) throws IOException {
        this.viewModelFactory = viewModelFactory;
        this.viewHandler = viewHandler;
        getfavouriteMovies();
    }


    public void openManageWindow() throws IOException {
        viewHandler.openMovieManager();
    }


    public void setSceneToWatchLater() throws IOException {
       viewHandler.openWatchLater();
    }
    public void setSceneToWatched() throws IOException {
       viewHandler.openWatched();
    }
    public void setSceneToHomepage() throws IOException, NotBoundException
    {
        viewHandler.openHomePage();
    }

    public void logOut() throws IOException
    {
        viewHandler.start();
    }

    public void getfavouriteMovies(){
        String username = viewHandler.getUserName();

        ArrayList<Movie> movies = viewModelFactory.getMovieViewModel().getListOfFavouriteMovies(username);
        int count = 0;
        HBox newRow = new HBox();



        for (int i = 0; i <movies.size() ; i++) {
            Movie movie0 = movies.get(i);
            VBox movie = new VBox();
            int currentMovie = viewModelFactory.getMovieViewModel().getMovieId(movie0.getTitle(), movie0.getDescription());
            System.out.println(currentMovie + " Current movie ID");
            System.out.println(movie0.getMovieID()+" !!!!!!!!!!@");
            movie.setOnMouseClicked(mouseEvent -> {
                try {
                    openMovie(currentMovie-1, movies);
                } catch (NotBoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            ImageView image = new ImageView(movie0.getImageURL());
            image.setFitWidth(150);
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
    }

    public void openMovie(int currentMovie, ArrayList<Movie> movies) throws NotBoundException, IOException {
        viewHandler.openViewMovieDescription(currentMovie, movies);
    }


}
