import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class YouTubeAudioLoader implements IAudioLoader {

  public YouTubeAudioLoader(String directory) {
    directoryToLoad = new File(directory);
    directoryPath = directory;
    directoryToLoad.mkdir();
  }

  public File download(String link) {
    WebDriver driver = browserSetup();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    String downloadPage = "https://tomp3.pro/" + link.replaceAll("(:/+|\\.|/|\\?|=)", "-");
    driver.get(downloadPage);
    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    WebElement searchButton = driver.findElement((By.cssSelector("span.fa.fa-search")));
    searchButton.click();
    WebElement button = driver.findElement(By.cssSelector("li.v-dl-mp3"));
    button.click();
    WebElement dynamicElement = (new WebDriverWait(driver, 30))
        .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class$='ready']")));
    WebElement downloadButton = driver.findElement(By.cssSelector("li.media-parent"));
    downloadButton.click();
    waitForDownload();
    driver.quit();
    return this.getLastModifiedFile();
  }

  private void waitForDownload() {
    try { // FIX FIX FIX
      TimeUnit.SECONDS.sleep(30);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  private File directoryToLoad;
  private String directoryPath;

  private WebDriver browserSetup() {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
    HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
    chromePrefs.put("profile.default_content_settings.popups", 0);
    chromePrefs.put("download.prompt_for_download", false);
    chromePrefs.put("download.directory_upgrade", true);
    chromePrefs.put("download.default_directory", directoryPath);
    ChromeOptions options = new ChromeOptions();
    options.setExperimentalOption("prefs", chromePrefs);
    return new ChromeDriver(options);
  }

  private File getLastModifiedFile() {
    File[] audioFiles = directoryToLoad.listFiles();
    Arrays.sort(audioFiles, (o1, o2) -> {

      if (o1.lastModified() > o2.lastModified()) {
        return -1;
      } else if (o1.lastModified() < o2.lastModified()) {
        return +1;
      } else {
        return 0;
      }
    });
    return audioFiles[0];
  }

}