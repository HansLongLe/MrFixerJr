package Client.View;

import Client.ViewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;



public class GenreManagerController {

    @FXML
    private ScrollPane genreList;

    private ViewModelFactory viewModelFactory;

    public void init(ViewModelFactory viewModelFactory, Stage stage)
    {
        this.viewModelFactory = viewModelFactory;
    }
    public void addGenre()
    {
        HBox newRow = new HBox();
        Label introduceName = new Label("Genre name: ");
        TextField genreName = new TextField();
        Button save = new Button("Save");
        Button delete = new Button("Delete");
        newRow.getChildren().addAll(introduceName, genreName, save, delete);
        newRow.setSpacing(10);
        genreList.setContent(newRow);
    }
}
