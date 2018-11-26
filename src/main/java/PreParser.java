import org.telegram.telegrambots.api.objects.Message;

public class PreParser {

  public PreParser() {
  }

  public RequestInfo parse(Message message) {
    String msgText = message.getText();
    String[] tokens = msgText.split(" ");
    RequestInfo requestInfo = new RequestInfo(message);
    requestInfo.setCommand(tokens[0]);
    return requestInfo;
  }
}
