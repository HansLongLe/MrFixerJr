package Client.ViewModel;

import Client.Model.*;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ViewModelFactory {
    private CreateAccountViewModel createAccountViewModel;
    private LoginViewModel loginViewModel;

    public ViewModelFactory(ModelFactory modelFactory)
        throws RemoteException, NotBoundException, InterruptedException
    {
        createAccountViewModel=new CreateAccountViewModel(modelFactory.getUser());
        loginViewModel=new LoginViewModel(modelFactory.getUser());
    }

    public CreateAccountViewModel getCreateAccountViewModel() {
        return createAccountViewModel;
    }

    public LoginViewModel getLoginViewModel() {
        return loginViewModel;
    }
}
