package Client.ViewModel;

import Client.Model.GenreDataModel;
import Client.Model.ModelFactory;

import java.rmi.RemoteException;

public class GenreViewModel {
    private GenreDataModel genreDataModel;
    public GenreViewModel(GenreDataModel genreDataModel)
    {
        this.genreDataModel = genreDataModel;
    }
    public void createGenre(String genreName) throws RemoteException {
        genreDataModel.addGenre(genreName);
    }
}
