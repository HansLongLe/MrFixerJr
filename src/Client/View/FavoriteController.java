package Client.View;

import Client.ViewModel.ViewModelFactory;
import javafx.scene.Scene;

import java.io.IOException;

public class FavoriteController {

    private ViewModelFactory viewModelFactory;
    private Scene watchLaterScene;
    private Scene watchedScene;
    private Scene homepageScene;
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
    public void setSceneToWatched() throws IOException {
       viewHandler.openWatched();
    }
    public void setSceneToHomepage() throws IOException {
        viewHandler.openHomepage();
    }


}
