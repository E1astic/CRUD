package DB;

import org.example.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils
{
    private static String INSERT_PLAYER="INSERT INTO players (name, position, goals, assists) VALUES (?,?,?,?)";
    private static String READ_PLAYERS="SELECT * FROM players";
    private static String UPDATE_PLAYER="UPDATE players SET goals=?, assists=? WHERE id=?";
    private static String DELETE_PLAYER="DELETE FROM players WHERE id=?";


    public static void insertPlayer(Player student)
    {
        try(Connection connection=DBUtils.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(INSERT_PLAYER))
        {
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getPosition());
            preparedStatement.setInt(3,student.getGoals());
            preparedStatement.setInt(4,student.getAssists());

            preparedStatement.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }


    public static List<Player> readPlayersData()
    {
        List<Player> players=new ArrayList<>();

        try(Connection connection=DBUtils.getConnection();
            Statement statement=connection.createStatement();)
        {
            ResultSet resultSet=statement.executeQuery(READ_PLAYERS);
            while(resultSet.next())
            {
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String position=resultSet.getString("position");
                int goals=resultSet.getInt("goals");
                int assists=resultSet.getInt("assists");

                players.add(new Player(id,name,position,goals,assists));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return players;
    }


    public static List<Player> readSpecialPlayersData(String query)
    {
        List<Player> players=new ArrayList<>();

        try(Connection connection=DBUtils.getConnection();
        Statement statement=connection.createStatement())
        {
            ResultSet resultSet=statement.executeQuery(query);

            while(resultSet.next())
            {
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String position=resultSet.getString("position");
                int goals=resultSet.getInt("goals");
                int assists=resultSet.getInt("assists");

                players.add(new Player(id,name,position,goals,assists));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return players;
    }


    public static void updatePlayer(int id, int newGoals, int newAssists)
    {
        try(Connection connection=DBUtils.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_PLAYER))
        {
            preparedStatement.setInt(1,newGoals);
            preparedStatement.setInt(2,newAssists);
            preparedStatement.setInt(3,id);

            preparedStatement.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }


    public static void deletePlayer(int id)
    {
        try(Connection connection=DBUtils.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(DELETE_PLAYER))
        {
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
