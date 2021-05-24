package Client.View;

import Client.ViewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.rmi.NotBoundException;

public class WatchedController{

    private ViewModelFactory viewModelFactory;
    private Scene watchLaterScene;
    private Scene homepageScene;
    private Scene favoriteScene;
    private ViewHandler viewHandler;
    @FXML private ImageView manageImage;


    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler) throws IOException {
        this.viewModelFactory = viewModelFactory;
        this.viewHandler = viewHandler;
    }


    public void openManageWindow() throws IOException {
       viewHandler.openMovieManager();
    }


    public void setSceneToWatchLater() throws IOException {
        viewHandler.openWatchLater();
    }
    public void setSceneToHomepage() throws IOException, NotBoundException
    {
        viewHandler.openHomePage();
    }
    public void setSceneToFavorite() throws IOException {
        viewHandler.openFavorite();
    }

    public void logOut() throws IOException
    {
        viewHandler.start();
    }

}
