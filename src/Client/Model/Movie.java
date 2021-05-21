package Client.Model;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Movie {
    private Image image;
    private String title;
    private String year;
    private ArrayList<Object> genres;
    private String description;
    private String actors;

    public Movie(Image image, String title, String year, ArrayList<Object> genres, String description, String actors){
        this.image = image;
        this.title = title;
        this.year = year;
        for (int i = 0; i < genres.size(); i++) {
            this.genres.add(genres.get(i));
        }
        this.description = description;
        this.actors = actors;
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

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
