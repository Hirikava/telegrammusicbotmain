package Common.Handlers;
import Common.SubscriptionManager;
import  Infrastructure.IHandler;
import Infrastructure.RequestInfo;

public class UnsubHandler implements IHandler{
    @Override
    public void handle(RequestInfo requestInfo) {
        String request = requestInfo.getMessage().getText().split(" ")[1];
        SubscriptionManager.ourInstance.resolveSubsription(requestInfo.getMessage().getChatId(),request);
        new SimpleTextHandler("You successfull unsubed from:" + request).handle(requestInfo);
    }
}
