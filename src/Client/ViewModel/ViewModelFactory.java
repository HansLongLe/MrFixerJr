package Client.ViewModel;

import Client.Model.*;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class ViewModelFactory {
    private CreateAccountViewModel createAccountViewModel;
    private LoginViewModel loginViewModel;
    private MovieViewModel movieViewModel;
    private GenreViewModel genreViewModel;

    public ViewModelFactory(ModelFactory modelFactory)
        throws RemoteException, NotBoundException, InterruptedException
    {
        createAccountViewModel=new CreateAccountViewModel(modelFactory.getUser());
        loginViewModel=new LoginViewModel(modelFactory.getUser());
        movieViewModel = new MovieViewModel(modelFactory.getMovieDataModel());
        genreViewModel = new GenreViewModel(modelFactory.getGenreDataModel());
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

    public GenreViewModel getGenreViewModel() {
        return genreViewModel;
    }

}
