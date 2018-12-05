import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import org.quartz.*;
import  org.telegram.telegrambots.api.methods.send.SendMessage;

public class Messenger implements Job {

  private String newsLink = "PL3ZQ5CpNulQkRwPTcR7hYosBYLhjLQk9h";
  private String musicLink = "PLFgquLnL59anbRi80QEZdeALImKQzNnOl";
  private String sportLink = "PL4Yp_5ExVAU3ielii5p56JYladaORKMmk";
  private String commonLink = "https://www.youtube.com/playlist?list=";
  private static Map<String, String> chanels;
  private Map<String, String> themes;
  private String dataFile = "file_name";


  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    System.out.println("Time for mailing");
    updateLinks();
    for (String chanel: chanels.keySet()) {
      System.out.println(chanels.get(chanel));
    }
    //sendFresh();
  }

  public Messenger() {
    themes.put("news", newsLink);
    themes.put("music", musicLink);
    themes.put("sport", sportLink);
  }

  private void updateLinks() {
    for (String theme: themes.keySet()) {
      chanels.put(theme, Link.getVideoLinks(commonLink+newsLink, 1)[0]);

    }
    chanels.put("music", Link.getVideoLinks(commonLink+musicLink, 1)[0]);
    chanels.put("sport", Link.getVideoLinks(commonLink+sportLink, 1)[0]);
  }

  private void sendFresh() {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(dataFile));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] arr = line.split(" ");
        String chatId = arr[0];
        for (int i = 1; i < arr.length; i++) {
          SendMessage sender = new SendMessage();
          sender.setChatId(chatId);
          String text = chanels.get(arr[i]);
          sender.setText(text);
          System.out.println("It's work!");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
