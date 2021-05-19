package Client.View;

import Client.ViewModel.GenreViewModel;
import Client.ViewModel.MovieViewModel;
import Client.ViewModel.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.rmi.RemoteException;


public class GenreManagerController {

    @FXML
    private VBox genreList;

    private Button delete;
    private Button save;
    private HBox newRow;
    private Label introduceName;
    private TextField genreName;


    private ViewModelFactory viewModelFactory;
    private GenreViewModel genreViewModel;
    private Stage stage;
    private Scene userScene;
    private Scene movieScene;

    private boolean genreExists = false;

    public void init(ViewModelFactory viewModelFactory, Stage stage) throws IOException {
        this.viewModelFactory = viewModelFactory;
        genreViewModel = viewModelFactory.getGenreViewModel();
        this.stage = stage;
    }

    public void addGenre()
    {
        newRow = new HBox();

        introduceName = new Label("Genre name: ");

        genreName = new TextField();

        save = new Button("Save");
        delete = new Button("Delete");

        save.setOnAction(actionEvent -> saveGenre());

        delete.setOnAction(actionEvent -> deleteGenre());

        newRow.getChildren().addAll(introduceName, genreName, save, delete);
        newRow.setSpacing(10);
        genreList.getChildren().add(newRow);
    }
    public void saveGenre()
    {

        try {
                genreViewModel.createGenre(genreName.getText(), genreExists);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        if (!genreExists)
        {
            newRow.getChildren().clear();
            Label savedGenre = new Label("Genre name: " + genreName.getText());
            newRow.getChildren().addAll(savedGenre, delete);
        }

    }
    public void deleteGenre()
    {
        newRow.getChildren().clear();
        genreList.getChildren().remove(newRow);
    }

    public void setSceneToUser() throws IOException {
        userScene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;

        loader.setLocation(getClass().getResource("UserManager.fxml"));

        root = loader.load();

        UserManagerController controller = loader.getController();
        controller.init(viewModelFactory, stage);
        userScene = new Scene(root);
        stage.setScene(userScene);
    }
    public void setSceneToMovie() throws IOException {
        movieScene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;

        loader.setLocation(getClass().getResource("MovieManager.fxml"));

        root = loader.load();
        MovieManagerController controller = loader.getController();
        controller.init(viewModelFactory, stage);
        movieScene = new Scene(root);
        stage.setScene(movieScene);
    }


}
