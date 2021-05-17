package Client.ViewModel;

import Client.Model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class LoginViewModel {
    private DataModel model;
    private User user;
    private SimpleStringProperty username;
    private SimpleStringProperty password;



    public LoginViewModel(User user){
        this.user=user;
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
    }

    public String logIn() throws RemoteException
    {
        for(int i=0; i<user.logIn().size(); i++){
            if(username.getValue().equals(user.logIn().get(i).getUserName()) && password.getValue().equals(user.logIn().get(i).getPassword())){
                return "true";
            }
            else if(username.getValue().equals(user.logIn().get(i).getUserName()) && !(password.getValue().equals(user.logIn().get(i).getPassword()))){
                return "Wrong password";
            }
            else if(!(username.getValue().equals(user.logIn().get(i).getUserName())) && password.getValue().equals(user.logIn().get(i).getPassword())){
                return "Wrong username";
            }

        }
        return "false";
    }



    public StringProperty getUsername(){
        return username;
    }
    public StringProperty getPassword(){
        return password;
    }







}
