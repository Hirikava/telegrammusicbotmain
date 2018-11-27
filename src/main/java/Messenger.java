import java.util.HashMap;
import java.util.Map;
import org.quartz.*;

public class Messenger implements Job {

  private static int maxLinks = 5;
  private static Map<String, String[]> chanels;
  private static String[] news = new String[maxLinks];
  private static String[] music = new String[maxLinks];
  private static String[] sport = new String[maxLinks];

  private String newsLink = "PL3ZQ5CpNulQkRwPTcR7hYosBYLhjLQk9h";
  private String musicLink = "PLFgquLnL59anbRi80QEZdeALImKQzNnOl";
  private String sportLink = "PL4Yp_5ExVAU3ielii5p56JYladaORKMmk";
  private String commonLink = "https://www.youtube.com/playlist?list=";

  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    updateLinks();
    sendFresh();
  }

  private void updateLinks() {
    String[] freshNews = Link.getVideoLinks(commonLink+newsLink, maxLinks);
    String[] freshMusic = Link.getVideoLinks(commonLink+musicLink, maxLinks);
    String[] freshSport = Link.getVideoLinks(commonLink+sportLink, maxLinks);
  }

  private void sendFresh() {

  }

  private boolean isFresh(String link) {
    return true;
  }
}
