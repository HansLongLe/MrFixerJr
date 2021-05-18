package Client.View;

import Client.ViewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class FavoriteController {

    private ViewModelFactory viewModelFactory;
    private Stage stage;
    private Scene watchLaterScene;
    private Scene watchedScene;
    private Scene homepageScene;

    public void init(ViewModelFactory viewModelFactory, Stage stage) throws IOException {
        this.viewModelFactory = viewModelFactory;
        this.stage = stage;
    }


    public void openManageWindow() throws IOException {
        Stage stage = new Stage();
        Scene scene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;

        loader.setLocation(getClass().getResource("MovieManager.fxml"));
        root = loader.load();
        MovieManagerController controller = loader.getController();
        controller.init(viewModelFactory, stage);
        stage.setTitle("Admin window");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void setSceneToWatchLater() throws IOException {
        watchLaterScene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;

        loader.setLocation(getClass().getResource("WatchLater.fxml"));

        root = loader.load();

        WatchLaterController controller = loader.getController();
        controller.init(viewModelFactory, stage);
        watchLaterScene = new Scene(root);
        stage.setScene(watchLaterScene);
    }
    public void setSceneToWatched() throws IOException {
        watchedScene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;

        loader.setLocation(getClass().getResource("Watched.fxml"));

        root = loader.load();

        WatchedController controller = loader.getController();
        controller.init(viewModelFactory, stage);
        watchedScene = new Scene(root);
        stage.setScene(watchedScene);
    }
    public void setSceneToHomepage() throws IOException {
        homepageScene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;

        loader.setLocation(getClass().getResource("Homepage.fxml"));

        root = loader.load();

        HomepageController controller = loader.getController();
        controller.init(viewModelFactory, stage);
        homepageScene = new Scene(root);
        stage.setScene(homepageScene);
    }


}
