package Client.Model;

import java.util.ArrayList;

public class Movie {
    private String title;
    private String year;
    private ArrayList<String> genres;
    private String description;
    private String actors;

    public Movie(String title, String year, ArrayList<String> genres){
        this.title = title;
        this.year = year;
        for (int i = 0; i < genres.size(); i++) {
            this.genres.add(genres.get(i));
        }
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

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
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
}
