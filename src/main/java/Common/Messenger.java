package Common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Infrastructure.MessageInfo;
import org.glassfish.grizzly.utils.Pair;
import org.quartz.*;
import org.telegram.telegrambots.api.methods.send.SendMessage;

public class Messenger implements Job {

  private static Bot _bot;

  public static void Init(Bot bot) {
    _bot = bot;
  }

  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    List<Pair<Long, String>> subscriptions = SubscriptionManager.ourInstance.getSubscriptions();
    for (Pair<Long, String> note : subscriptions) {
      Link link = new Link();
      System.out.println(link.searchLink(note.getSecond()));
      snd(note.getFirst(), link.searchLink(note.getSecond()));
    }
  }

  private void snd(Long id, String text) {
    SendMessage sendMessage = new SendMessage();
    sendMessage.setChatId(id);
    sendMessage.setText(text);
    MessageInfo messageInfo = new MessageInfo("sndmsg", sendMessage);
    this._bot.send(messageInfo);
  }

}