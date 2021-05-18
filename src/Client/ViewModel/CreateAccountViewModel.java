package Client.ViewModel;

import Client.Model.*;
import javafx.beans.property.SimpleStringProperty;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

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

    public void createAccount(String username, String password, String email)
        throws RemoteException, NotBoundException
    {
        user.createAccount(username, password, email);
    }
}
