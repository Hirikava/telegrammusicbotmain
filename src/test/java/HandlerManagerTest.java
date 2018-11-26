import org.telegram.telegrambots.api.objects.Message;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class HandlerManagerTest {
  private Message mes = spy(Message.class);
  private PreParser pars = new PreParser();
  @Test
  public void commandPlayTest() {
    when(mes.getText()).thenReturn("/play Some_text");
    RequestInfo requestInfo = pars.parse(mes);
    IHandler handler = HandlerManager.getInstance().getHandler(requestInfo);
    assert handler instanceof YouTubeAudioLoadHandler;
  }

  @Test
  public void simpleTest() {
    when(mes.getText()).thenReturn("some text");
    RequestInfo requestInfo = pars.parse(mes);
    IHandler handler = HandlerManager.getInstance().getHandler(requestInfo);
    assert handler instanceof SimpleTextHandler;
  }

  @Test
  public void emptyMessageTest() {
    when(mes.getText()).thenReturn("");
    RequestInfo requestInfo = pars.parse(mes);
    IHandler handler = HandlerManager.getInstance().getHandler(requestInfo);
    assert handler instanceof SimpleTextHandler;
  }
}
