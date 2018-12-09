package Common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Link {
  public String searchLink(String str) {
    String youtubeLinkForSearching = "https://www.youtube.com/results?search_query=";
    String youtubeSearchingResultLink = youtubeLinkForSearching + str.replaceAll(" ", "+");
    String result = "https://www.youtube.com" + getVideoLinks(youtubeSearchingResultLink,"<li><div class=",  1)[0];
    return result;
  }

  public static String[] getVideoLinks(String link, String key, int count) {
    String[] links = new String[count];
    int currentIndex = 0;
    try {
      URL site = new URL(link);
      BufferedReader reader = new BufferedReader(new InputStreamReader(site.openStream()));
      String line;
      while ((line = reader.readLine()) != null && currentIndex < count) {
        if (line.contains(key)) {
          String[] wordArr = line.split(" ");
          for (String word : wordArr) {
            if (word.startsWith("href=\"/w")) {
              int begin = word.indexOf('"') + 1;
              int end = word.lastIndexOf('"');
              links[currentIndex] = word.substring(begin, end);
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