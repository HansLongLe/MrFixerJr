package Client.ViewModel;

import Client.Model.*;
public class ViewModelFactory {
    private CreateAccountViewModel createAccountViewModel;
    private LoginViewModel loginViewModel;

    public ViewModelFactory(ModelFactory modelFactory)
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
