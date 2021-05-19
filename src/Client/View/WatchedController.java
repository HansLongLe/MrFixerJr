package Client.View;

import Client.ViewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class WatchedController {

    private ViewModelFactory viewModelFactory;
    private Scene watchLaterScene;
    private Scene homepageScene;
    private Scene favoriteScene;
    private ViewHandler viewHandler;

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
    public void setSceneToHomepage() throws IOException {
        viewHandler.openHomepage();
    }
    public void setSceneToFavorite() throws IOException {
        viewHandler.openFavorite();
    }
}
