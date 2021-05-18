package Client.View;

import Client.ViewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;


import java.awt.*;
import java.util.ArrayList;

public class CreateMovieController {
    @FXML
    private TextField title;
    @FXML
    private TextField year;
    @FXML
    private ComboBox genre;
    @FXML
    private TextArea description;
    @FXML
    private TextArea actors;

    private ViewModelFactory viewModelFactory;

    public void init (ViewModelFactory viewModelFactory)
    {
        this.viewModelFactory = viewModelFactory;

    }

    public void createMovie(){
        viewModelFactory.getMovieViewModel().createMovie(title.getText(), year.getText(), new ArrayList<>(), description.getText(), actors.getText());
    }
}
