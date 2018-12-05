package Common.Handlers;

import Infrastructure.IHandler;

public class HandlerFactory {

  public IHandler createHandler(String type) {
    if(type == null)
      return new SimpleTextHandler("Command not found :(");
    switch (type) {
        case "Common.Handlers.YouTubeAudioLoadHandler": {
            return new YouTubeAudioLoadHandler();
        }
        case  "Common.Handlers.SubscribeHandler":{
            return new SubscribeHandler();
        }
        default:
            return new SimpleTextHandler("Command not found :(");
    }

  }
}
