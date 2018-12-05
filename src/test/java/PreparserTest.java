import Common.PreParser;
import Infrastructure.RequestInfo;
import org.junit.Test;
import org.telegram.telegrambots.api.objects.Message;

import static org.mockito.Mockito.*;


public class PreparserTest {
  @Test
  public void SimpleTest() {
    Message mes = spy(Message.class);
    PreParser pars = new PreParser();
    when(mes.getText()).thenReturn("/play Some_text");
    RequestInfo requestInfo = pars.parse(mes);
    assert requestInfo.getCommand().equals("/play");
  }
}
