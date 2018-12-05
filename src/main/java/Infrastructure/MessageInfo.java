package Infrastructure;

public class MessageInfo {

  private String messageType;
  private Object sendObj;

  public MessageInfo(String messageType, Object sendObj) {
    this.messageType = messageType;
    this.sendObj = sendObj;
  }

  public Object getSendObj() {
    return sendObj;
  }

  public String getMessageType() {
    return messageType;
  }
}
