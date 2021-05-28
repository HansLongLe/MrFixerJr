package Client.View;

import Client.ViewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.control.Label;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class MovieManagerController {

    @FXML
    private VBox movies;

    private ViewModelFactory viewModelFactory;
    private Scene userScene;
    private Scene genreScene;
    private ViewHandler viewHandler;

    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler) throws IOException {
        this.viewModelFactory = viewModelFactory;
        this.viewHandler = viewHandler;

        loadMovies();
    }

    public void addMovie() throws IOException, NotBoundException {
        viewHandler.openCreateMovie();
    }


    public void setSceneToUser() throws IOException {
        viewHandler.openUserManager();
    }
    public void setSceneToGenre() throws IOException, NotBoundException
    {
       viewHandler.openGenreManager();
    }

    public void logOut() throws IOException
    {
        viewHandler.start();
    }
    public void loadMovies() throws RemoteException {
        int count = 0;
        HBox newRow = new HBox();
        for (int i = 0; i <viewModelFactory.getMovieViewModel().getMovies().size() ; i++) {

                VBox movie = new VBox();
                ImageView image = new ImageView(viewModelFactory.getMovieViewModel().getMovies().get(i).getImageURL());
                image.setFitWidth(150);
                image.setFitHeight(150);
                Label title = new Label(viewModelFactory.getMovieViewModel().getMovies().get(i).getTitle());
                Label year = new Label(viewModelFactory.getMovieViewModel().getMovies().get(i).getYear());
                String genres = "";
                for (int j = 0; j < viewModelFactory.getMovieViewModel().getMovies().get(i).getGenres().size(); j++) {
                   genres += viewModelFactory.getMovieViewModel().getMovies().get(i).getGenres().get(j);
                   if (!(j == viewModelFactory.getMovieViewModel().getMovies().get(i).getGenres().size()-1))
                   {
                       genres += ",";
                   }
                }
                Label genreLabel = new Label(genres);
                movie.getChildren().addAll(image, title, year, genreLabel);


                newRow.getChildren().add(movie);

                count++;
                if (count % 3 == 0)
                {
                    movies.getChildren().add(newRow);
                    newRow = new HBox();
                }
        }
        movies.getChildren().add(newRow);

    }

    public void back() throws IOException, NotBoundException {
        viewHandler.openHomePage();
    }
}
