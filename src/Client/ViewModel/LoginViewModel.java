package Client.ViewModel;

import Client.Model.*;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.crypto.dsig.SignatureProperty;
import java.nio.channels.spi.SelectorProvider;
import java.rmi.RemoteException;

public class LoginViewModel {
    private DataModel model;
    private StringProperty email;
    private StringProperty username;
    private StringProperty password;

    public LoginViewModel(DataModel model){
        this.model=model;
        email=new SimpleStringProperty("email");
        username=new SimpleStringProperty("username");
        password=new SimpleStringProperty("password");
    }

    public void clearFields() {
        email.setValue("");
        username.setValue("");
        password.setValue("");
    }



    public StringProperty getEmail(){
        return email;
    }

    public StringProperty getUsername(){
        return username;
    }

    public StringProperty getPassword(){
        return password;
    }






}
