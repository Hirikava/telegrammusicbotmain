package Common;
import Infrastructure.ISubscriptionManager;
import java.util.List;
import org.glassfish.grizzly.utils.Pair;
import org.sqlite.SQLiteDataSource;
import java.util.ArrayList;
import java.sql.*;

public class SubscriptionManager implements ISubscriptionManager {

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
    public void setSubscription(Long chatID, String subscriprion) {
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
    public List<Pair<Long, String>> getSubscriptions() {
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
