package Client.ViewModel;

import Client.Model.*;
public class ViewModelFactory {
    private CreateAccountViewModel createAccountViewModel;
    private LoginViewModel loginViewModel;
    private MovieViewModel movieViewModel;

    public ViewModelFactory(ModelFactory modelFactory)
    {
        createAccountViewModel=new CreateAccountViewModel(modelFactory.getUser());
        loginViewModel=new LoginViewModel(modelFactory.getDataModel());
        movieViewModel = new MovieViewModel(modelFactory.getMovieDataModel());
    }

    public CreateAccountViewModel getCreateAccountViewModel() {
        return createAccountViewModel;
    }

    public LoginViewModel getLoginViewModel() {
        return loginViewModel;
    }

    public MovieViewModel getMovieViewModel() {
        return movieViewModel;
    }
}
