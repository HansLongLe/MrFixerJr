package Client.ViewModel;

import Client.Model.*;
import javafx.beans.property.SimpleStringProperty;

public class CreateAccountViewModel {
    private User user;
    private SimpleStringProperty username;
    private SimpleStringProperty password;
    private SimpleStringProperty repeatPassword;
    private SimpleStringProperty email;
    public CreateAccountViewModel(User user){
        this.user = user;
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        repeatPassword = new SimpleStringProperty();
        email = new SimpleStringProperty();
    }
}
