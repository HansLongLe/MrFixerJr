package Server.Network;

import Client.Model.Movie;
import Client.Model.SimpleUser;
import Client.Model.User;
import Client.Network.ClientInterface;
import Server.Database.DatabaseConnection;
import javafx.scene.image.Image;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ServerRMI implements ServerInterface{

    private ArrayList<ClientInterface> connectedUsers;
    private DatabaseConnection databaseConnection;


    public ServerRMI(String databasePassword) throws RemoteException
    {
        UnicastRemoteObject.exportObject( this, 0);
        connectedUsers = new ArrayList<>();
        databaseConnection = new DatabaseConnection(databasePassword);
    }
    @Override
    public void addBroadcast(ClientInterface clientReceiver) {
        connectedUsers.add(clientReceiver);
    }

    @Override
    public void newUser(User user) throws RemoteException{
       databaseConnection.addUser(user);
        System.out.println("new user in server");
    }

    @Override public void start() throws RemoteException, AlreadyBoundException
    {
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("Server", this);
        System.out.println("Server started!");

    }

    @Override public ArrayList<User> logIn()
        throws RemoteException
    {      ResultSet rs = null;
            ArrayList<User> simpleUsers = new ArrayList<>();

        rs=databaseConnection.logIn() ;
        try{
                    while(rs.next()){
                        String username1 = rs.getString("username");
                        String password1 = rs.getString("password");

                        User temp = new SimpleUser();
                        temp.set(username1, password1, "");
                        simpleUsers.add( temp);
                    }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

        return simpleUsers;
    }

    public ArrayList<Movie> loadFavouriteList(String username){
        ResultSet rs = null;
        ResultSet rsGenres = null;
        ResultSet rsActors = null;
        String[] actors = null;
        ArrayList<Object> genres = new ArrayList<Object>();
        ArrayList<Movie> favouriteListOfMovies = new ArrayList<Movie>();
        rs = databaseConnection.loadFavouriteMovies(username);
        try{
            while(rs.next()){
                String imageurl = rs.getString("imageurl");
                String title = rs.getString("title");
                String year = rs.getString("year");
                double averagerating = rs.getDouble("averagerating");
                String description = rs.getString("description");

                int id = rs.getInt("movieid");

                rsActors = databaseConnection.getAcotrsForMovie(id);
                while(rsActors.next()){
                    int i=0;
                    String actor = rs.getString("actor");
                    actors[i] = actor;
                }
                rsGenres = databaseConnection.getGenresForMovie(id);
                    while(rsGenres.next()){
                        String genre = rsGenres.getString("genre");
                        genres.add(genre);
                    }


                Movie movie = new Movie(imageurl, title, year, genres, description, actors);
                    favouriteListOfMovies.add(movie);
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        catch(NullPointerException e){
            e.printStackTrace();
        }
        return favouriteListOfMovies;

    }

    @Override public String getRole(String username) throws RemoteException
    {
        ResultSet rs= null;
        rs = databaseConnection.getRole(username);
        String role = "";
        try
        {
            while(rs.next())
            {
                role = rs.getString("role");
                System.out.println(role);

            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return role;


    }

    @Override public void removeGenre(String genreName) throws RemoteException
    {
        databaseConnection.removeGenre(genreName);
    }

    @Override public void chooseThreeGenresForUser(String username, String firstGenre, String secondGenre, String thirdGenre)
    {
        databaseConnection.chooseThreeGenresForUser(username, firstGenre, secondGenre, thirdGenre);
    }

    @Override
    public ArrayList<Movie> getMovies() throws RemoteException {
        ResultSet movieTable = databaseConnection.getMoviesFromDatabase();
        ResultSet actorTable = databaseConnection.getActorsFromDatabase();
        ResultSet genreRelationshipTable = databaseConnection.getGenresFromGenresRelationship();
        ArrayList<String> actorsTemp = new ArrayList<>();
        ArrayList<Object> genres = new ArrayList<>();
        ArrayList<Movie> movies = new ArrayList<>();

        try {
            while (movieTable.next())
            {
                while (actorTable.next())
                {
                    if (movieTable.getString("movieID").equals(actorTable.getString("movieID")))
                    actorsTemp.add(actorTable.getString("actor"));
                }
                while (genreRelationshipTable.next())
                {
                    if (movieTable.getString("movieID").equals(genreRelationshipTable.getString("movieID")))
                    {
                        genres.add(genreRelationshipTable.getString("genre"));
                    }
                }
                String[] actors = actorsTemp.toArray(new String[0]);
                Movie movie = new Movie(movieTable.getString("imageURL"), movieTable.getString("title"), movieTable.getString("year"),
                      genres,movieTable.getString("description"), actors);
                movies.add(movie);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
        }
return movies;
    }

    @Override public ArrayList<Movie> loadMoviesByChosenGenre(String username)
    {
        ResultSet movieTable = databaseConnection.loadMoviesByChosenGenre(username);
        ResultSet actorTable = databaseConnection.getActorsFromDatabase();
        ResultSet genreRelationshipTable = databaseConnection.getGenresFromGenresRelationship();
        ArrayList<String> actorsTemp = new ArrayList<>();
        ArrayList<Object> genres = new ArrayList<>();
        ArrayList<Movie> movies = new ArrayList<>();

        try {
            while (movieTable.next())
            {
                while (actorTable.next())
                {
                    if (movieTable.getString("movieID").equals(actorTable.getString("movieID")))
                        actorsTemp.add(actorTable.getString("actor"));
                }
                while (genreRelationshipTable.next())
                {
                    if (movieTable.getString("movieID").equals(genreRelationshipTable.getString("movieID")))
                    {
                        genres.add(genreRelationshipTable.getString("genre"));
                    }
                }
                String[] actors = actorsTemp.toArray(new String[0]);
                Movie movie = new Movie(movieTable.getString("imageURL"), movieTable.getString("title"), movieTable.getString("year"),
                    genres,movieTable.getString("description"), actors);
                movies.add(movie);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
        }
        return movies;
    }

    @Override
    public void addMovieToDatabase(Movie movie) throws RemoteException, SQLException {
        databaseConnection.addMovies(movie);
    }

    @Override
    public void addGenre(String genre) throws RemoteException {
        databaseConnection.addGenre(genre);
    }

    @Override
    public ArrayList<String> getGenresFromDatabase() throws RemoteException {
        ResultSet rs = null;
        rs = databaseConnection.getGenresFromDatabase();
                ArrayList<String> genres = new ArrayList<>();
        try
        {
            while(rs.next())
            {
                String genre = rs.getString("genre");
                genres.add(genre);

            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return genres;

    }

}
