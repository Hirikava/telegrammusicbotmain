import org.aopalliance.reflect.Class;

public class HandlerFactory {

  public IHandler createHandler(String type) {
    if(type == null)
      return new SimpleTextHandler("Command not found :(");
    switch (type) {
        case "YouTubeAudioLoadHandler":
            return new YouTubeAudioLoadHandler();
        default:
            return new SimpleTextHandler("Command not found :(");
    }

  }
}
