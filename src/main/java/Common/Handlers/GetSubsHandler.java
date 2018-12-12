package Common.Handlers;

import Common.SubscriptionManager;
import Infrastructure.IHandler;
import Infrastructure.RequestInfo;

import java.util.List;

public class GetSubsHandler implements IHandler {
    @Override
    public void handle(RequestInfo requestInfo) {
        List<String> subs = SubscriptionManager.ourInstance.selectSubscriptions(requestInfo.getMessage().getChatId());
        String request = "";
        for (String sub : subs)
        {
            request += sub+'\n';
        }
        new SimpleTextHandler("Your subscriptions:\n" + request).handle(requestInfo);
    }
}
