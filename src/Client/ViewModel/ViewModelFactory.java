package Client.ViewModel;

import Client.Model.*;
public class ViewModelFactory {
    private CreateAccountViewModel createAccountViewModel;
    private LoginViewModel loginViewModel;
    private HomepageViewModel homepageViewModel;

    public ViewModelFactory(ModelFactory modelFactory)
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
