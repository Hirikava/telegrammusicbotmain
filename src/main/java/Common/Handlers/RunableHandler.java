package Common.Handlers;

import Infrastructure.IHandler;
import Infrastructure.RequestInfo;

abstract public class RunableHandler implements Runnable, IHandler {

  public void handle(RequestInfo requestInfo) {
    if (thread == null) {
      this.requestInfo = requestInfo;
      thread = new Thread(this,
          requestInfo.getMessage().getText() + requestInfo.getMessage().getChatId());
      thread.run();
    }
    // иначе кинуть экспешн
  }

  public abstract void run();

  protected RequestInfo requestInfo;
  private Thread thread;

}
