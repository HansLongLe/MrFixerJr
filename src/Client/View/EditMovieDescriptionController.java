package Client.View;

import Client.ViewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.Scene;

import java.awt.*;
import java.io.IOException;
import java.rmi.NotBoundException;

public class EditMovieDescriptionController {

    private ViewModelFactory viewModelFactory;
    private ViewHandler viewHandler;

    @FXML private TextField name;
    @FXML private TextField year;
    @FXML private TextField genres;
    @FXML private TextArea description;
    @FXML private TextArea actors;

    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler) throws IOException, NotBoundException {
        this.viewModelFactory = viewModelFactory;
        this.viewHandler = viewHandler;
    }

    public void setSceneToUser() throws IOException {
        viewHandler.openUserManager();
    }
    public void setSceneToGenre() throws IOException, NotBoundException
    {
        viewHandler.openGenreManager();
    }

    public void setSceneToMovie() throws IOException, NotBoundException
    {
        viewHandler.openMovieManager();
    }


    public void saveButton()
    {

    }


    public void logOut() throws IOException
    {
        viewHandler.start();
    }

}
