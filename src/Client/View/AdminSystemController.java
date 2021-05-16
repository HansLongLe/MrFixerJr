package Client.View;

import Client.ViewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;

public class AdminSystemController {

    @FXML private HBox addMovie;

    private ViewModelFactory viewModelFactory;

    public void init (ViewModelFactory viewModelFactory)
    {
        this.viewModelFactory = viewModelFactory;
    }

    public void addMovie()
    {

    }
}
