
package Server.Database;

import Client.Model.Movie;
import Client.Model.SimpleUser;
import Client.Model.User;

import javax.swing.plaf.nimbus.State;
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
        String sql = "select distinct imageurl, title, year, movie.movieid, movie.movieid, averagerating, description\n"
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
    public ResultSet loadWatchLater(String username){
        String sql = "select distinct imageurl, title, year, movie.movieid, movie.movieid, averagerating, description\n"
            + "from MyFlixerJr.movie, MyFlixerJr.WatchLaterList\n"
            + "where movie.movieid in (select watchlaterlist.movieid from MyFlixerJr.WatchLaterList) and watchlaterlist.username = '" + username + "';";
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
            + "from MyFlixerJr.genrerelationship\n" + "where movieid = "+ id +";";
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

    public ResultSet getActorsForMovie(int id){
        String sql = "select actor\n" + "from MyFlixerJr.actors\n"
            + "where movieid = "+id+";";
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement= connection.prepareStatement(sql);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        try{
            System.out.println("Got actors from database!!!!!!!");
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
      String sql0 = "delete\n" + "from MyFlixerJr.genrerelationship cascade\n"
          + "where genre = '"+ genreName + "';";
      String sql = "DELETE from MyFlixerJr.Genre cascade where genre = '" + genreName+ "';";
      String sql2 = "DELETE from MyFlixerJr.SelectedGenres cascade where genre =  '" + genreName+ "';";
      Statement statement = null;
      Statement statement0 = null;
      Statement statement2 = null;
      try
      {
          statement2 = connection.createStatement();
          statement0 = connection.createStatement();
          statement = connection.createStatement();
      }
      catch (SQLException throwables)
      {
          throwables.printStackTrace();
      }
      try
      {
          statement2.execute(sql2);
          statement0.execute(sql0);
          statement.execute(sql);
          System.out.println("Genre deleted " + genreName);
      }
      catch (SQLException throwables)
      {
          throwables.printStackTrace();
      }
  }

  public void chooseThreeGenresForUser(String username, String firstGenre, String secondGenre, String thirdGenre)
  {
      ArrayList<String> selectedGenres = new ArrayList<>();
      selectedGenres.add(firstGenre);
      selectedGenres.add(secondGenre);
      selectedGenres.add(thirdGenre);
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
      String sql = "SELECT * FROM MyFlixerJr.movie;";
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

    public ResultSet loadMoviesByChosenGenre(String username)
    {
        String sql = "select distinct movie.movieid, movie.imageurl, movie.title, movie.year, movie.description\n"
            + "from MyFlixerJr.movie, MyFlixerJr.selectedgenres, MyFlixerJr.genrerelationship\n"
            + "where (MyFlixerJr.SelectedGenres.genre = MyFlixerJr.GenreRelationship.genre ) and (MyFlixerJr.GenreRelationship.movieid = MyFlixerJr.movie.movieid) and (MyFlixerJr.SelectedGenres.username = '" +username+ "')";
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement= connection.prepareStatement(sql);
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

    public ResultSet getSortedMoviesByGenres(ArrayList<String> chosenGenres)
    {
        String temp = "";
        for (int i = 0; i < chosenGenres.size(); i++) {
            temp += "MyFlixerJr.GenreRelationship.genre = '" + chosenGenres.get(i) + "'";
            if (!(i == chosenGenres.size()-1))
            {
                temp += " OR ";
            }
        }

        String sql = "SELECT distinct MyFlixerJr.movie.title, MyFlixerJr.movie.imageurl, MyFlixerJr.movie.movieid, MyFlixerJr.movie.year,MyFlixerJr.movie.averagerating, MyFlixerJr.movie.description\n" +
                "from MyFlixerJr.movie, MyFlixerJr.genrerelationship where ("+ temp +") and (MyFlixerJr.Movie.movieid = MyFlixerJr.GenreRelationship.movieid);\n";
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement= connection.prepareStatement(sql);
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
    public void addToWatched(String title, String description, String username)
    {
        String sql =
            "INSERT INTO MyFlixerJr.AlreadyWatchedList(movieid, username)\n" + "VALUES ((select movieId from MyFlixerJr.movie where description = '"
                + description + "' and title = '" + title + "'),'" + username + "' );";

        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
            System.out.println("Added to Watched list))))))))");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void addToFavorite(int id, String username)
    {
        String sql = "insert into MyFlixerJr.FavoriteList(movieid, username)\n"
            + "values("+id+", '"+username+"');";

        Statement statement = null;
        try{
            statement = connection.createStatement();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        try{
            System.out.println("added to the fav list in database");

            statement.execute(sql);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    public ResultSet getMovieId(String title, String description)
        throws SQLException
    {
        String sql = "select movieid\n" + "from MyFlixerJr.movie\n"
            + "where title='"+title+"' and description='"+description+"';";

        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(sql);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return preparedStatement.executeQuery();
    }

    public void addToWatchLater(int id, String username)
    {
        String sql = "insert into MyFlixerJr.WatchLaterList(movieid, username)\n"
            + "values("+id+", '"+username+"');";

        Statement statement = null;
        try{
            statement = connection.createStatement();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        try{
            System.out.println("added to the watch later list in database");

            statement.execute(sql);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    public ResultSet loadAlreadyWatchedMovies(String username)
    {
        String sql = "select distinct imageurl, title, year, movie.movieid, movie.movieid, averagerating, description\n"
            + "from MyFlixerJr.movie, MyFlixerJr.AlreadyWatchedList\n"
            + "where movie.movieid in (select alreadywatchedlist.movieid from MyFlixerJr.AlreadyWatchedList) and alreadywatchedlist.username = '" + username + "';";
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
    public ResultSet SearchMovieByName(String searchText){
        String temp = "";
        char[] textLenght = searchText.toCharArray();
        System.out.println(textLenght.length);
        String temp2 = "";
        for (int i = 0; i < textLenght.length; i++) {
            temp2+= textLenght[i];
            temp += "title like '%" + temp2 + "%'";
            if (i != textLenght.length-1)
            {
                temp += " OR ";
            }
        }

        System.out.println(temp);
        String sql = "SELECT * from MyFlixerJr.Movie WHERE ("+ temp +");";
        System.out.println(sql);
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
        }
        catch (SQLException throwables){
            throwables.printStackTrace();
        }
        try {
            return preparedStatement.executeQuery();
        }
        catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return null;
    }

}