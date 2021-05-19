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


public class GenreManagerController {

    @FXML
    private VBox genreList;



    private ViewModelFactory viewModelFactory;
    private GenreViewModel genreViewModel;
    private Scene userScene;
    private Scene movieScene;
    private ViewHandler viewHandler;

    public void init(ViewModelFactory viewModelFactory,ViewHandler viewHandler) throws IOException {
        this.viewModelFactory = viewModelFactory;
        genreViewModel = viewModelFactory.getGenreViewModel();
        this.viewHandler = viewHandler;
    }

    public void addGenre()
    {
        HBox newRow = new HBox();

        Label introduceName = new Label("Genre name: ");

        TextField genreName = new TextField();

        Button save = new Button("Save");
        Button delete = new Button("Delete");
        Button change = new Button("Change");


        save.setOnAction(actionEvent -> {
            genreViewModel.createGenre(genreName.getText());
            newRow.getChildren().clear();
            Label savedGenre = new Label("Genre name: " + genreName.getText());
            newRow.getChildren().addAll(savedGenre,change, delete);
        });

        change.setOnAction(actionEvent -> {
            newRow.getChildren().clear();
            newRow.getChildren().addAll(introduceName, genreName, save, delete);
        });

        delete.setOnAction(actionEvent -> {
            newRow.getChildren().clear();
            genreList.getChildren().remove(newRow);
        });


        newRow.getChildren().addAll(introduceName, genreName, save, delete);
        newRow.setSpacing(10);
        genreList.getChildren().add(newRow);
    }

    public void setSceneToUser() throws IOException {
        viewHandler.openUserManager();
    }
    public void setSceneToMovie() throws IOException {
        viewHandler.openMovieManager();
    }


}
