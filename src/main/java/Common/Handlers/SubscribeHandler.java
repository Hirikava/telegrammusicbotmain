package Common.Handlers;
import Common.SubscriptionManager;
import  Infrastructure.IHandler;
import Infrastructure.RequestInfo;

public class SubscribeHandler implements IHandler{
    @Override
    public void handle(RequestInfo requestInfo) {
        String request = requestInfo.getMessage().getText().split(" ")[1];
        SubscriptionManager.ourInstance.setSubscription(requestInfo.getMessage().getChatId(),request);
        new SimpleTextHandler("You successfull subscribed on:" + request).handle(requestInfo);
    }
}
