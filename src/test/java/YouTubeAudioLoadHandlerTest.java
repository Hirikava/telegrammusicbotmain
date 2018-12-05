import Common.Handlers.YouTubeAudioLoadHandler;
import Infrastructure.RequestInfo;
import org.junit.Test;
import org.telegram.telegrambots.api.objects.Message;

public class YouTubeAudioLoadHandlerTest {

    @Test
    public void youTubeAudioLoadHandlerRunsInTwoThreads()
    {
        YouTubeAudioLoadHandler handler = new YouTubeAudioLoadHandler();
        RequestInfo requestInfo = new RequestInfo(new Message());
        Thread thread = new Thread();


    }
}
