package Client.View;

import Client.ViewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.IOException;
import java.rmi.NotBoundException;

public class ViewMovieDescriptionController {

    private ViewModelFactory viewModelFactory;
    private ViewHandler viewHandler;

    @FXML private Label name;
    @FXML private Label year;
    @FXML private Label genres;
    @FXML private Text description;
    @FXML private Text actors;
    @FXML private ImageView image;

    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler) throws IOException, NotBoundException {
        this.viewModelFactory = viewModelFactory;
        this.viewHandler = viewHandler;
    }

    public void setSceneToWatchLater() throws IOException {
        viewHandler.openWatchLater();
    }
    public void setSceneToWatched() throws IOException {
        viewHandler.openWatched();
    }
    public void setSceneToFavorite() throws IOException {
        viewHandler.openFavorite();
    }

    public void setSceneToHomepage() throws IOException, NotBoundException {
        viewHandler.openHomePage();
    }


    public void logOut() throws IOException
    {
        viewHandler.start();
    }

    public void addToWatchLater()
    {

    }

    public void addToWatched()
    {

    }

    public void addToFavorite()
    {

    }
}
