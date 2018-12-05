package Common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Link {
  public String searchLink(String str) {
    String youtubeLinkForSearching = "https://www.youtube.com/results?search_query=";
    String youtubeSearchingResultLink = youtubeLinkForSearching + str.replaceAll(" ", "+");
    String result = getVideoLinks(youtubeSearchingResultLink,"<li><div class=",  1)[0];
    return result;
  }

  public static String[] getVideoLinks(String link, String key, int count) {
    String[] links = new String[count];
    int currentIndex = 0;
    String youtubeLink = "https://www.youtube.com";
    try {
      URL site = new URL(link);
      BufferedReader reader = new BufferedReader(new InputStreamReader(site.openStream()));
      String line;
      while ((line = reader.readLine()) != null && currentIndex < count) {
        if (line.startsWith(key)) {
          String[] wordArr = line.split(" ");
          for (String word : wordArr) {
            if (word.startsWith("href=")) {
              int begin = word.indexOf('"') + 1;
              int end = word.lastIndexOf('"');
              links[currentIndex] = youtubeLink + word.substring(begin, end);
              currentIndex++;
              break;
            }
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return links;
  }
}