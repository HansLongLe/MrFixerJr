package Client.View;

import Client.ViewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;

public class WatchedController {

    @FXML private HBox home;

    @FXML private HBox watchLater;

    @FXML private HBox watched;

    @FXML private HBox favorite;

    private ViewModelFactory viewModelFactory;

    public void init (ViewModelFactory viewModelFactory)
    {
        this.viewModelFactory = viewModelFactory;
    }
}
