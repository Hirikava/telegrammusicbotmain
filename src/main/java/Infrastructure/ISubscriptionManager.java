package Infrastructure;

import java.util.List;
import org.glassfish.grizzly.utils.Pair;

public interface ISubscriptionManager {
    public void setSubscription(Long cjat_id, String subscriprion);
    public List<Pair<Long,String>> getSubscriptions();
}
