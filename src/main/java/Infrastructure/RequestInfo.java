package Infrastructure;

import Common.Bot;
import org.telegram.telegrambots.api.objects.Message;

import java.util.Dictionary;
import java.util.Hashtable;

public class RequestInfo {

  private String command;
  private Dictionary<String, String> namedArgs;
  private String unnamedArg;
  private Message message;
  private Bot bot;

  public RequestInfo(Message message) {
    this.message = message;
    namedArgs = new Hashtable<>();
    unnamedArg = null;
    command = null;
  }

  public void addNamedArg(String key, String value) {
    namedArgs.put(key, value);
  }

  public String getNamedArg(String key) {
    try {
      return namedArgs.get(key);
    } catch (Exception ex) {
      System.out.println(ex);
    }
    return null;
  }

  public void setUnnamedArg(String value) {
    unnamedArg = value;
  }

  public String getUnnamedArg() {
    return unnamedArg;
  }

  public void setCommand(String value) {
    command = value;
  }

  public String getCommand() {
    return command;
  }

  public Message getMessage() {
    return message;
  }

  public Bot getBot() {
    return bot;
  }

  public void setBot(Bot bot) {
    if (bot != null) {
      this.bot = bot;
    }
  }
}
