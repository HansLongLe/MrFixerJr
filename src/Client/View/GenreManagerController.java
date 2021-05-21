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
import java.rmi.NotBoundException;
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
    private ViewHandler viewHandler;
    private boolean genreExists = false;

    public void init(ViewModelFactory viewModelFactory,ViewHandler viewHandler) throws IOException {

        this.viewModelFactory = viewModelFactory;
        genreViewModel = viewModelFactory.getGenreViewModel();
        this.viewHandler = viewHandler;
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
        if(!(genreViewModel.getGenre().contains(genreName.getText()))){
            try
            {
                genreViewModel.createGenre(genreName.getText());
                newRow.getChildren().clear();
                            Label savedGenre = new Label("Genre name: " + genreName.getText());
                            newRow.getChildren().addAll(savedGenre, delete);
            }
            catch (RemoteException e)
            {
                e.printStackTrace();
            }
            catch (NotBoundException e)
            {
                e.printStackTrace();
            }
        }


    }
    public void deleteGenre()
    {
        newRow.getChildren().clear();
        genreList.getChildren().remove(newRow);
    }

    public void setSceneToUser() throws IOException {
        viewHandler.openUserManager();
    }
    public void setSceneToMovie() throws IOException {
        viewHandler.openMovieManager();
    }


}
