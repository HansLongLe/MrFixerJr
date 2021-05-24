package Client.View;

import Client.ViewModel.LoginViewModel;
import Client.ViewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


import java.awt.*;
import java.io.IOException;
import java.rmi.NotBoundException;

public class HomepageController {

    private ViewModelFactory viewModelFactory;
    private Scene watchLaterScene;
    private Scene watchedScene;
    private Scene favoriteScene;
    private ViewHandler viewHandler;

   @FXML private ImageView manageImage;

    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler)
        throws IOException, NotBoundException
    {
        this.viewModelFactory = viewModelFactory;
        this.viewHandler = viewHandler;

      LoginViewModel loginViewModel = viewModelFactory.getLoginViewModel();
      String role = loginViewModel.getRole(loginViewModel.getUsername().getValue());
      switch(loginViewModel.logIn()){
        case "true":
          if(role.equals("Admin") || role.equals("Moderator")){
            manageImage.setVisible(true);
          }
          else if(role.equals("SimpleUser")){
            manageImage.setVisible(false);
          }
          break;
      }

    }
    public ImageView getManageImage(){
        return manageImage;
    }

    public void openManageWindow() throws IOException {
        viewHandler.openMovieManager();
    }


    public void setSceneToWatchLater() throws IOException {
        viewHandler.openWatchLater();
    }
    public void setSceneToWatched() throws IOException {
        viewHandler.openWatched();
    }
    public void setSceneToFavorite() throws IOException {
       viewHandler.openFavorite();
    }

    public void logOut() throws IOException
    {
      viewHandler.start();
    }
}
