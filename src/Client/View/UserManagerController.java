package Client.View;

import Client.ViewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class UserManagerController {

    private ViewModelFactory viewModelFactory;
    private Stage stage;
    private Scene movieScene;
    private Scene genreScene;

    public void init(ViewModelFactory viewModelFactory, Stage stage) throws IOException {
        this.viewModelFactory = viewModelFactory;
        this.stage = stage;
        movieScene();
        genreScene();
    }

    private void movieScene() throws IOException {
        movieScene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;

        loader.setLocation(getClass().getResource("MovieManager.fxml"));

        root = loader.load();

        UserManagerController controller = loader.getController();
        controller.init(viewModelFactory, stage);
        movieScene = new Scene(root);
    }

    private void genreScene() throws IOException {
        genreScene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;

        loader.setLocation(getClass().getResource("GenreManager.fxml"));

        root = loader.load();
        GenreManagerController controller = loader.getController();
        controller.init(viewModelFactory, stage);
        genreScene = new Scene(root);
    }

    public void setSceneToMovie()
    {
        stage.setScene(movieScene);
    }
    public void setSceneToGenre()
    {
        stage.setScene(genreScene);
    }
}
