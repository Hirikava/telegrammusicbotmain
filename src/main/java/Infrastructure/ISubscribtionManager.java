package Infrastructure;
import javafx.util.Pair;

import java.util.List;

public interface ISubscribtionManager {
    public void setSubscruption(Long cjat_id, String subscriprion);
    public List<Pair<Long,String>> getSubscribtions();
}
