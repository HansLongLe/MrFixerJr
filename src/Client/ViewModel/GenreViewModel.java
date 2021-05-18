package Client.ViewModel;

import Client.Model.GenreDataModel;
import Client.Model.ModelFactory;

public class GenreViewModel {
    private GenreDataModel genreDataModel;
    public GenreViewModel(GenreDataModel genreDataModel)
    {
        this.genreDataModel = genreDataModel;
    }
    public void createGenre(String genreName)
    {
        genreDataModel.addGenre(genreName);
    }
}
