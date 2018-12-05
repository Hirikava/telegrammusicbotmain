package Common.Handlers;
import Common.SubscriptionManager;
import  Infrastructure.IHandler;
import Infrastructure.RequestInfo;

public class SubscriveHandler implements IHandler{
    @Override
    public void handle(RequestInfo requestInfo) {
        String request = requestInfo.getMessage().getText().split(" ")[1];
        SubscriptionManager.ourInstance.setSubscruption(requestInfo.getMessage().getChatId(),request);
        new SimpleTextHandler("You sucsessfule subscibed on:" + request).handle(requestInfo);
    }
}
