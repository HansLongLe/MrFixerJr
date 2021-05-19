package Client.View;

import Client.ViewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MovieManagerController {

    private ViewModelFactory viewModelFactory;
    private Scene userScene;
    private Scene genreScene;
    private ViewHandler viewHandler;

    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler) throws IOException {
        this.viewModelFactory = viewModelFactory;
        this.viewHandler = viewHandler;
    }

    public void addMovie() throws IOException {
        viewHandler.openCreateMovie();
    }


    public void setSceneToUser() throws IOException {
        viewHandler.openUserManager();
    }
    public void setSceneToGenre() throws IOException {
       viewHandler.openGenreManager();
    }


}
