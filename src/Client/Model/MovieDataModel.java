package Client.Model;

import java.util.ArrayList;

public interface MovieDataModel {

    void addMovie(String title, String year, ArrayList<String> genres, String description, String actors);
}
