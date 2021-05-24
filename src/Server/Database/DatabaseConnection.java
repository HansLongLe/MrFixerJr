
package Server.Database;

import Client.Model.Movie;
import Client.Model.SimpleUser;
import Client.Model.User;

import java.rmi.RemoteException;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {
    private Connection connection;

    public DatabaseConnection(String password)
    {
        String driver = "org.postgresql.Driver";

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";

        connection = null;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }

    public void addUser(User user) throws RemoteException
    {
        System.out.println("Data got to the last class" + user);
        System.out.println(user.getUserName()+ user.getPassword());
        String sql = "INSERT INTO MyFlixerJr.GeneralUser(username, email, password,role)  VALUES( " + "'" + user.getUserName() + "','" +  user.getEmail() + "','" +  user.getPassword() + "','SimpleUser');";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
            System.out.println("New user in database!!!!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public ResultSet logIn(){

        String sql = "SELECT username, password, role FROM MyFlixerJr.GeneralUser";
        PreparedStatement preparedStatement = null;
        try
        {
            preparedStatement = connection.prepareStatement(sql);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

        try
        {
            return preparedStatement.executeQuery();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    public ResultSet getRole(String username) throws RemoteException
    {
        String sql = "SELECT role FROM MyFlixerJr.GeneralUser WHERE username = '"+ username+ "';";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(sql);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        try{
            return  preparedStatement.executeQuery();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }
    public void addGenre(String genre)
    {
        String sql = "INSERT INTO MyFlixerJr.Genre(genre) VALUES(" + "'" + genre +"');";

        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public ResultSet getGenresFromDatabase()
    {
        String sql = "SELECT genre from MyFlixerJr.Genre";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(sql);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        try{
            return preparedStatement.executeQuery();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

        return null;
    }
    public void addMovies(Movie movie) throws SQLException {

        String sql0 = "INSERT INTO MyFlixerJr.Movie(imageURL, title, year, description) VALUES (" +"'" + movie.getImageURL() +"','"+movie.getTitle() + "','" + movie.getYear() + "','" + movie.getDescription() +"');";

        try {
            Statement statement = connection.createStatement();
            statement.execute(sql0);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        String sql1 = "SELECT movieID from MyFlixerJr.Movie";
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Integer> movieIDs = new ArrayList<>();
        try{
            preparedStatement = connection.prepareStatement(sql1);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        try{
            resultSet = preparedStatement.executeQuery();

        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        while (resultSet.next())
        {
            movieIDs.add(resultSet.getInt("movieid"));
        }

        movie.setMovieID(movieIDs.size());
        for (int i = 0; i < movie.getGenres().size(); i++) {
            String sql2 = "INSERT INTO MyFlixerJr.GenreRelationship(movieID, genre) VALUES (" + "'"  + movie.getMovieID() + "','" + movie.getGenres().get(i) + "');";
            try {
                Statement statement = connection.createStatement();
                statement.execute(sql2);
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        for (int i = 0; i < movie.getActors().length; i++) {
            String sql3 = "INSERT INTO MyFlixerJr.Actors(movieID, actor) VALUES (" + "'" + movie.getMovieID() + "','" + movie.getActors()[i] + "');";
            try {
                Statement statement = connection.createStatement();
                statement.execute(sql3);
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }

    }

    public ResultSet loadFavouriteMovies(String username){
        String sql = "select distinct title, description, movie.movieid, actor\n"
            + "from MyFlixerJr.movie, MyFlixerJr.favoritelist\n"
            + "where movie.movieid in (select favoritelist.movieid from MyFlixerJr.FavoriteList) and favoritelist.username = '" + username + "';";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(sql);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        try{
            return preparedStatement.executeQuery();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

        return null;
    }

    public ResultSet getGenresForMovie(int id){
        String sql = "select distinct genre\n"
            + "from MyFlixerJr.genrerelationship, MyFlixerJr.movie\n"
            + "    where genrerelationship.movieid in (select movie.movieid  where movie.movieid = "+ id+");";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(sql);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        try{
            return preparedStatement.executeQuery();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }



  public void removeGenre(String genreName)
  {
      String sql = "DELETE from MyFlixerJr.Genre where genre = '" + genreName+ "';";
      Statement statement = null;
      try
      {
          statement = connection.createStatement();
      }
      catch (SQLException throwables)
      {
          throwables.printStackTrace();
      }
      try
      {
          statement.execute(sql);
          System.out.println("Genre deleted " + genreName);
      }
      catch (SQLException throwables)
      {
          throwables.printStackTrace();
      }
  }

  public void chooseThreeGenresForUser(String username, String firstGnere, String secondGnere, String thirdGnere)
  {
      ArrayList<String> selectedGenres = new ArrayList<>();
      selectedGenres.add(firstGnere);
      selectedGenres.add(secondGnere);
      selectedGenres.add(thirdGnere);
      for (int i = 0; i < selectedGenres.size(); i++)
      {
          String sql = "Insert into MyFlixerJr.SelectedGenres (username, genre) values('" + username + "','" + selectedGenres.get(i) + "');";
          Statement statement = null;
          try
          {
              statement = connection.createStatement();
          }
          catch (SQLException throwables)
          {
              throwables.printStackTrace();
          }
          try
          {
              statement.execute(sql);
          }
          catch (SQLException throwables)
          {
              throwables.printStackTrace();
          }
      }
  }
  public ResultSet getMoviesFromDatabase()
  {
      String sql = "SELECT * FROM MyFlixerJr.Movie";
      ResultSet resultSet = null;
      PreparedStatement preparedStatement = null;
      try{
          preparedStatement = connection.prepareStatement(sql);
      }
      catch (SQLException throwables)
      {
          throwables.printStackTrace();
      }
      try{
          resultSet = preparedStatement.executeQuery();
          return resultSet;

      }
      catch (SQLException throwables)
      {
          throwables.printStackTrace();
      }
      return null;
  }
  public ResultSet getActorsFromDatabase()
  {
      String sql = "SELECT * FROM MyFlixerJr.Actors";
      ResultSet resultSet = null;
      PreparedStatement preparedStatement = null;
      try{
          preparedStatement = connection.prepareStatement(sql);
      }
      catch (SQLException throwables)
      {
          throwables.printStackTrace();
      }
      try{
          resultSet = preparedStatement.executeQuery();
          return resultSet;

      }
      catch (SQLException throwables)
      {
          throwables.printStackTrace();
      }
      return null;
  }
  public ResultSet getGenresFromGenresRelationship()
  {
      String sql = "SELECT * FROM MyFlixerJr.GenreRelationship";
      ResultSet resultSet = null;
      PreparedStatement preparedStatement = null;
      try{
          preparedStatement = connection.prepareStatement(sql);
      }
      catch (SQLException throwables)
      {
          throwables.printStackTrace();
      }
      try{
          resultSet = preparedStatement.executeQuery();
          return resultSet;

      }
      catch (SQLException throwables)
      {
          throwables.printStackTrace();
      }
      return null;
  }
}