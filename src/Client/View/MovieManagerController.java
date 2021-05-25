package Client.View;

import Client.Model.Movie;
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
          Movie movie0 = viewModelFactory.getMovieViewModel().getMovies().get(i);
                VBox movie = new VBox();
                ImageView image = new ImageView(movie0.getImageURL());
                image.setFitWidth(150);
                image.setFitHeight(150);
                Label title = new Label(movie0.getTitle());
                Label year = new Label(movie0.getYear());
                String genres = "";
//          System.out.println(viewModelFactory.getMovieViewModel().getMovies().get(i).getGenres().get(i));
                for (int j = 0; j < movie0.getGenres().size(); j++) {
                   genres += movie0.getGenres().get(j);
                   if (!(j == movie0.getGenres().size()-1))
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
