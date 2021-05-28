package Client.View;

import Client.ViewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.rmi.NotBoundException;

public class WatchLaterController{

    private ViewModelFactory viewModelFactory;
    private Scene homepageScene;
    private Scene watchedScene;
    private Scene favoriteScene;
    private ViewHandler viewHandler;
    @FXML private ImageView manageImage;


    public void init(ViewModelFactory viewModelFactory,ViewHandler viewHandler) throws IOException {
        this.viewModelFactory = viewModelFactory;
        this.viewHandler = viewHandler;
    }


    public void openManageWindow() throws IOException {
       viewHandler.openMovieManager();
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

}
