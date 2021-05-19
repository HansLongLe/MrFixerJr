package Client.View;

import Client.ViewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

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
    private ViewHandler viewHandler;

    public void init (ViewModelFactory viewModelFactory, ViewHandler viewHandler)
    {
        this.viewModelFactory = viewModelFactory;
        this.viewHandler = viewHandler;
    }

    public void createMovie(){
        viewModelFactory.getMovieViewModel().createMovie(title.getText(), year.getText(), new ArrayList<>(), description.getText(), actors.getText());
    }
}
