package Client.View;

import Client.ViewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.controlsfx.control.CheckComboBox;


import java.io.File;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class CreateMovieController {
    @FXML
    private ImageView movieImage;
    @FXML
    private TextField title;
    @FXML
    private TextField year;
    @FXML
    private CheckComboBox genre;
    @FXML
    private TextArea description;
    @FXML
    private TextArea actors;


    private ViewModelFactory viewModelFactory;
    private ViewHandler viewHandler;

    public void init (ViewModelFactory viewModelFactory, ViewHandler viewHandler) throws NotBoundException, RemoteException {
        this.viewModelFactory = viewModelFactory;
        this.viewHandler = viewHandler;
        for (int i = 0; i < viewModelFactory.getMovieViewModel().getGenres().size(); i++) {
            genre.getItems().add(viewModelFactory.getMovieViewModel().getGenres().get(i));
        }
    }

    public void uploadImage() {
        FileChooser fileChooser = new FileChooser();
        File tmp = fileChooser.showOpenDialog(new Stage());
        Image image =  new Image("file:\\" + tmp.getAbsolutePath());
        movieImage.setImage(image);

    }

    public void createMovie() throws NotBoundException, RemoteException {
        ArrayList<Object> chosenGenres = new ArrayList<>();
        for (int i = 0; i < genre.getItems().size(); i++) {
            if (genre.getCheckModel().isChecked(i))
            {
                chosenGenres.add(genre.getItems().get(i));
            }
        }
        viewModelFactory.getMovieViewModel().createMovie(movieImage.getImage(), title.getText(), year.getText(), chosenGenres, description.getText(), actors.getText());
    }
}
