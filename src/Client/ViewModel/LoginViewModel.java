package Client.ViewModel;

import Client.Model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class LoginViewModel {
    private User user;
    private StringProperty username;
    private StringProperty password;



    public LoginViewModel(User user){
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        this.user=user;
    }
    public String getRole(String username)
        throws RemoteException, NotBoundException
    {
        return user.getRole(username);
    }


    public String logIn() throws RemoteException
    {
        for(int i=0; i<user.logIn().size(); i++){
            if(user.logIn().get(i).getUserName().equals(username.getValue()) && user.logIn().get(i).getPassword().equals(password.getValue())){
                return "true";

            }
            else if(user.logIn().get(i).getUserName().equals(username.getValue()) && !(user.logIn().get(i).getPassword().equals(password.getValue()))){
                return "Wrong password";
            }
            else if(!(user.logIn().get(i).getUserName().equals(username.getValue())) && user.logIn().get(i).getPassword().equals(password.getValue())){
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
