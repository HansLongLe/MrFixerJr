package Client.ViewModel;

import Client.Model.GenreDataModel;
import Client.Model.ModelFactory;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class GenreViewModel {
    private GenreDataModel genreDataModel;
    public GenreViewModel(GenreDataModel genreDataModel)
    {
        this.genreDataModel = genreDataModel;
    }
    public void createGenre(String genreName)
        throws RemoteException, NotBoundException
    {
        genreDataModel.addGenre(genreName);
    }

    public ArrayList<String> getGenre(){
        return genreDataModel.getGenre();
    }
}
