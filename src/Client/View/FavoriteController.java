package Client.View;

import Client.ViewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;

public class FavoriteController {

    @FXML private ScrollPane favoriteList;

    private ViewModelFactory viewModelFactory;

    public void init (ViewModelFactory viewModelFactory)
    {
        this.viewModelFactory = viewModelFactory;
    }
}
