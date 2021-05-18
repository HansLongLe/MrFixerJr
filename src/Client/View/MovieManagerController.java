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
    private Stage stage;
    private Scene userScene;
    private Scene genreScene;

    public void init(ViewModelFactory viewModelFactory, Stage stage) throws IOException {
        this.viewModelFactory = viewModelFactory;
        this.stage = stage;
        userScene();
        genreScene();
    }

    public void addMovie() throws IOException {
        Stage stage = new Stage();
        Scene scene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;

        loader.setLocation(getClass().getResource("CreateMovie.fxml"));
        root = loader.load();
        CreateMovieController controller = loader.getController();

        stage.setTitle("Create Movie");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void userScene() throws IOException {
        userScene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;

        loader.setLocation(getClass().getResource("UserManager.fxml"));

        root = loader.load();

        UserManagerController controller = loader.getController();
        controller.init(viewModelFactory, stage);
        userScene = new Scene(root);
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

    public void setSceneToUser()
    {
        stage.setScene(userScene);
    }
    public void setSceneToGenre()
    {
        stage.setScene(genreScene);
    }


}
