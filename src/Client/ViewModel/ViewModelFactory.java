package Client.ViewModel;

import Client.Model.*;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ViewModelFactory {
    private CreateAccountViewModel createAccountViewModel;
    private LoginViewModel loginViewModel;
    private HomepageViewModel homepageViewModel;

    public ViewModelFactory(ModelFactory modelFactory)
        throws RemoteException, NotBoundException, InterruptedException
    {
        homepageViewModel=new HomepageViewModel(modelFactory.getDataModel());
        createAccountViewModel=new CreateAccountViewModel(modelFactory.getUser());
        loginViewModel=new LoginViewModel(modelFactory.getDataModel());
    }

    public CreateAccountViewModel getCreateAccountViewModel() {
        return createAccountViewModel;
    }

    public LoginViewModel getLoginViewModel() {
        return loginViewModel;
    }

    public HomepageViewModel getHomepageViewModel(){
        return homepageViewModel;
    }
}
