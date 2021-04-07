package Client.ViewModel;

import Client.Model.*;
public class ViewModelFactory {
    private CreateAccountViewModel createAccountViewModel;
    private LoginViewModel loginViewModel;

    public ViewModelFactory(ModelFactory modelFactory){
        createAccountViewModel=new CreateAccountViewModel(modelFactory.getDataModel());
        loginViewModel=new LoginViewModel(modelFactory.getDataModel());
    }

    public CreateAccountViewModel getCreateAccountViewModel() {
        return createAccountViewModel;
    }

    public LoginViewModel getLoginViewModel() {
        return loginViewModel;
    }
}
