package Common;

import Common.Handlers.HandlerManager;
import Infrastructure.IHandler;
import Infrastructure.MessageInfo;
import Infrastructure.RequestInfo;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendAudio;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;



public class Bot extends TelegramLongPollingBot {
  public static void main(String[] args) {
    ApiContextInitializer.init();

    Planner planner = new Planner();
    Thread plannerThread = new Thread(() -> planner.task());
    TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
    try {
      Bot requesterBot = new Bot();
      Messenger.Init(requesterBot);
      telegramBotsApi.registerBot(new Bot());
    } catch (TelegramApiException e) {
      e.printStackTrace();
    }
    plannerThread.start();
  }


  public void send(MessageInfo messageInfo) {
    try {
      switch (messageInfo.getMessageType()) {
        case "sndmsg":
          sendMessage((SendMessage) messageInfo.getSendObj());
          break;
        case "sndaudio":
          sendAudio((SendAudio) messageInfo.getSendObj());
          break;
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  @Override
  public void onUpdateReceived(Update update) {
    Message message = update.getMessage();
    PreParser parser = new PreParser();
    RequestInfo requestInfo = parser.parse(message);
    requestInfo.setBot(this);
    IHandler handler = HandlerManager.getInstance().getHandler(requestInfo);
    handler.handle(requestInfo);
  }

  public String getBotUsername() {
    return "SonaMusicBot";
  }

  public String getBotToken() {
    return "779766656:AAFf6t0tm9FhK6KaKfBn1QYR6o5OVJuhblY";
  }
}

