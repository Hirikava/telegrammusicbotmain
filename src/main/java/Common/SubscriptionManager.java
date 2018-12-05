package Common;
import Infrastructure.ISubscribtionManager;
import javafx.util.Pair;
import org.sqlite.SQLiteDataSource;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class SubscriptionManager implements ISubscribtionManager {

    private String url;
    public static SubscriptionManager ourInstance = new SubscriptionManager();

    public SubscriptionManager()
    {
        url = "jdbc:sqlite:"+"src/main/resources/dataBases/subscription.db";
        try {
            SQLiteDataSource sqLiteDataSource = new SQLiteDataSource();
            sqLiteDataSource.setUrl(url);
            Connection connection = sqLiteDataSource.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE 'SUBSCRIPTIONS'  (CHATID BIGINT , SUB varchar(40));");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void setSubscruption(Long chatID, String subscriprion) {
        try {
            SQLiteDataSource sqLiteDataSource = new SQLiteDataSource();
            sqLiteDataSource.setUrl(url);
            Connection connection = sqLiteDataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM SUBSCRIPTIONS WHERE CHATID=" + chatID + " AND SUB=" + "\'" + subscriprion + "\'" );
            if(!res.next())
                statement.execute("INSERT INTO SUBSCRIPTIONS " + " VALUES" + "(" + chatID + "," + "\'" + subscriprion + "\'" + ");");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pair<Long, String>> getSubscribtions() {
        List<Pair<Long,String>> retList = new ArrayList<>();
        try {
            SQLiteDataSource sqLiteDataSource = new SQLiteDataSource();
            sqLiteDataSource.setUrl(url);
            Connection connection = sqLiteDataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM SUBSCRIPTIONS;");
            while(resultSet.next())
            {
                retList.add(new Pair<>(resultSet.getLong("CHATID"),resultSet.getString("SUB")));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return retList;
    }
}
