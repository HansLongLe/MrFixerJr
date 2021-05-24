package Client.Model;

import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {
    private String title;
    private String year;
    private ArrayList<Object> genres = new ArrayList<>();
    private String description;
    private String[] actors;
    private int movieID;
    private String imageURL;

    public Movie(String imageURL, String title, String year, ArrayList<Object> genres, String description, String[] actors){

        this.title = title;
        this.year = year;
        for (int i = 0; i < genres.size(); i++) {
            this.genres.add(genres.get(i));
        }
        this.description = description;
        this.actors = actors;
        movieID = 0;
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ArrayList<Object> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Object> genres) {
        this.genres = genres;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getActors() {
        return actors;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }


    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public int getMovieID() {
        return movieID;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
