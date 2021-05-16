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


    //public String validLogin() throws RemoteException {
    //    if (model.getType().equals("SimpleUser")){
    //        for (int i = 0; i < model.allSimpleUsers().size(); i++) {
    //            if (model.allSimpleUsers().get(i).getUsername().equals(username.getValue()) && model.allSimpleUsers().get(i).getPassword().equals(password.getValue())){
    //                return "true";
    //            }else if (model.allSimpleUsers().get(i).getUsername().equals(username.getValue()) && !model.allSimpleUsers().get(i).getPassword().equals(password.getValue())){
    //                return "invalid password";
    //            }
    //            else if (!model.allSimpleUsers().get(i).getUsername().equals(username.getValue()) && model.allSimpleUsers().get(i).getPassword().equals(password.getValue())){
    //                return "invalid username";
    //            }
    //            else if (!model.allSimpleUsers().get(i).getUsername().equals(username.getValue()) && !model.allSimpleUsers().get(i).getPassword().equals(password.getValue())){
    //                return "invalid username or password";
    //            }
    //        }
    //        return "error";
    //    }
    //    else if (model.getType().equals("Moderator")){
    //        for (int i = 0; i < model.allModerators().size(); i++) {
    //            if (model.allModerators().get(i).getUsername().equals(username.getValue()) && model.allModerators().get(i).getPassword().equals(password.getValue())){
    //                return "true";
    //            }else if (model.allModerators().get(i).getUsername().equals(username.getValue()) && !model.allModerators().get(i).getPassword().equals(password.getValue())){
    //                return "invalid password";
    //            }
    //            else if (!model.allModerators().get(i).getUsername().equals(username.getValue()) && model.allModerators().get(i).getPassword().equals(password.getValue())){
    //                return "invalid username";
    //            }
    //            else if (!model.allModerators().get(i).getUsername().equals(username.getValue()) && !model.allModerators().get(i).getPassword().equals(password.getValue())){
    //                return "invalid username or password";
    //            }
    //        }
    //        return "error";
    //    }
    //    return ""
//
    //}


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
