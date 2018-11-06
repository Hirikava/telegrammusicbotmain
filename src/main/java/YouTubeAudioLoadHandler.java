
import org.telegram.telegrambots.api.methods.send.SendAudio;


public class YouTubeAudioLoadHandler extends RunableHandler {

  public void run() {
    String loadLink = new Link().searchLink(requestInfo.getMessage().getText().split("\"")[1]);
    YouTubeAudioLoader loader = new YouTubeAudioLoader(
        "src/main/resources/audioFiles/" + requestInfo.getMessage().getChatId());
    SendAudio sendAudio = new SendAudio();
    sendAudio.setNewAudio(loader.download(loadLink));

    sendAudio.setChatId(requestInfo.getMessage().getChatId());
    MessageInfo messageInfo = new MessageInfo("sndaudio", sendAudio);
    requestInfo.getBot().getSender().send(
            messageInfo);
  }
}
