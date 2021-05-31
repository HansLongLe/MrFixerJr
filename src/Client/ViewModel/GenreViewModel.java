package Client.ViewModel;

import Client.Model.GenreDataModel;
import Client.Model.ModelFactory;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;


/**
 * A class used for connecting Genre View part with Model part
 */

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

    public void deleteGenreFromDataBase(String genreName) throws RemoteException
    {
        genreDataModel.removeGenre(genreName);
    }
}
