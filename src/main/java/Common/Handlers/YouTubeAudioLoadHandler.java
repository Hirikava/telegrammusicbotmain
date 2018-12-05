package Common.Handlers;

import Common.Link;
import Common.YouTubeAudioLoader;
import Infrastructure.IHandler;
import Infrastructure.MessageInfo;
import Infrastructure.RequestInfo;
import org.telegram.telegrambots.api.methods.send.SendAudio;
import java.io.File;


public class YouTubeAudioLoadHandler implements IHandler {

  public void handle(RequestInfo requestInfo) {
    String loadLink = new Link().searchLink(requestInfo.getMessage().getText().split("\"")[1]);
    YouTubeAudioLoader loader = new YouTubeAudioLoader(
        System.getProperty("user.dir") + File.pathSeparator + String.join(File.pathSeparator,"src","main","resources"
                ,"audioFiles")
                + File.pathSeparator + requestInfo.getMessage().getChatId());
    SendAudio sendAudio = new SendAudio();
    sendAudio.setNewAudio(loader.download(loadLink));

    sendAudio.setChatId(requestInfo.getMessage().getChatId());
    MessageInfo messageInfo = new MessageInfo("sndaudio", sendAudio);
    requestInfo.getBot().send(messageInfo);
  }
}
