package Client.View;

import Client.ViewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class UserManagerController {

    @FXML private HBox addMovie;

    @FXML private HBox movies;

    @FXML private HBox users;

    @FXML private HBox genre;

    private ViewModelFactory viewModelFactory;

    public void init(ViewModelFactory viewModelFactory, Stage stage)
    {
        this.viewModelFactory = viewModelFactory;
    }
}
