import org.telegram.telegrambots.api.methods.send.SendMessage;

public class SimpleTextHandler implements IHandler {

  private String answer;

  public SimpleTextHandler(String answer) {
    this.answer = answer;
  }

  public void handle(RequestInfo requestInfo) {
    SendMessage sendMessage = new SendMessage();
    sendMessage.setText(answer);
    sendMessage.setChatId(requestInfo.getMessage().getChatId());
    MessageInfo messageInfo = new MessageInfo("sndmsg", sendMessage);
    requestInfo.getBot().getSender().send(messageInfo);
  }

}
