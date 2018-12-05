import Common.SubscriptionManager;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SubscriptionManagerTest {
    private SubscriptionManager subscriptionManager;

    @Test
    public void initilizing_test()
    {
        subscriptionManager = SubscriptionManager.ourInstance;
    }

    @Test
    public void InsertingTest()
    {
        SubscriptionManager.ourInstance.setSubscruption(23123L,"music");
        SubscriptionManager.ourInstance.setSubscruption(2312233L,"sport");
    }

    @Test
    public void SelectTest()
    {
        SubscriptionManager.ourInstance.setSubscruption(23123L,"music");
        SubscriptionManager.ourInstance.setSubscruption(2312233L,"sport");
        List<Pair<Long, String>> res = SubscriptionManager.ourInstance.getSubscribtions();
        Assert.assertEquals(res.size(),2);
    }
    @Test
    public void DoubleSubscriptionDoesnotWORK()
    {
        SubscriptionManager.ourInstance.setSubscruption(23123L,"music");
        SubscriptionManager.ourInstance.setSubscruption(2312233L,"sport");
        List<Pair<Long, String>> res = SubscriptionManager.ourInstance.getSubscribtions();
        Assert.assertEquals(res.size(),2);
        SubscriptionManager.ourInstance.setSubscruption(23123L,"music");
        SubscriptionManager.ourInstance.setSubscruption(2312233L,"sport");
        List<Pair<Long, String>> res2 = SubscriptionManager.ourInstance.getSubscribtions();
        Assert.assertEquals(res2.size(),2);
    }

}
