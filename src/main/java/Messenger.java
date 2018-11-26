import org.quartz.*;

public class Messenger implements Job {

  private String[] news = new String[5];
  private String[] music = new String[5];
  private String[] sport = new String[5];

  private String newsLink = "PL3ZQ5CpNulQkRwPTcR7hYosBYLhjLQk9h";
  private String musicLink = "PLFgquLnL59anbRi80QEZdeALImKQzNnOl";
  private String sportLink = "PL4Yp_5ExVAU3ielii5p56JYladaORKMmk";
  private String commonLink = "https://www.youtube.com/playlist?list=";
  private String youtubeLink = "https://www.youtube.com";

  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    updateLinks();
    sendFresh();
  }

  private void updateLinks() {
    news[0] = youtubeLink + Link.getVideoId(commonLink+newsLink);
    music[0] = youtubeLink + Link.getVideoId(commonLink+musicLink);
    sport[0] = youtubeLink + Link.getVideoId(commonLink+sportLink);
  }

  private void sendFresh() {

  }
}
