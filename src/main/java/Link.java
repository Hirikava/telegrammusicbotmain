import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Link {

  public String searchLink(String str) {
    String youtubeLinkForSearching = "https://www.youtube.com/results?search_query=";
    String youtubeSearchingResultLink = youtubeLinkForSearching + str.replaceAll(" ", "+");
    String youtubeLink = "https://www.youtube.com";
    String result = youtubeLink + getVideoId(youtubeSearchingResultLink);
    return result;
  }

  public static String getVideoId(String link) {
    try {
      URL site = new URL(link);
      BufferedReader reader = new BufferedReader(new InputStreamReader(site.openStream()));
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.startsWith("<li><div class=")) {
          String[] wordArr = line.split(" ");
          for (String word : wordArr) {
            if (word.startsWith("href=")) {
              int begin = word.indexOf('"') + 1;
              int end = word.lastIndexOf('"');
              return word.substring(begin, end);
            }
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}