import Common.SubscriptionManager;
import org.glassfish.grizzly.utils.Pair;
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
        SubscriptionManager.ourInstance.setSubscription(23123L,"music");
        SubscriptionManager.ourInstance.setSubscription(2312233L,"sport");
    }

    @Test
    public void SelectTest()
    {
        SubscriptionManager.ourInstance.setSubscription(23123L,"music");
        SubscriptionManager.ourInstance.setSubscription(2312233L,"sport");
        List<Pair<Long, String>> res = SubscriptionManager.ourInstance.getSubscriptions();
        Assert.assertEquals(res.size(),2);
    }
    @Test
    public void DoubleSubscriptionDoesnotWORK()
    {
        SubscriptionManager.ourInstance.setSubscription(23123L,"music");
        SubscriptionManager.ourInstance.setSubscription(2312233L,"sport");
        List<Pair<Long, String>> res = SubscriptionManager.ourInstance.getSubscriptions();
        Assert.assertEquals(res.size(),2);
        SubscriptionManager.ourInstance.setSubscription(23123L,"music");
        SubscriptionManager.ourInstance.setSubscription(2312233L,"sport");
        List<Pair<Long, String>> res2 = SubscriptionManager.ourInstance.getSubscriptions();
        Assert.assertEquals(res2.size(),2);
    }

}
