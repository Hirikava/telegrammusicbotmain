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
        case  "Common.Handlers.UnsubHandler":{
            return new UnsubHandler();
        }
        case  "Common.Handlers.GetSubsHandler":{
            return new GetSubsHandler();
        }
        default:
            return new SimpleTextHandler("Command not found :(");
    }

  }
}
