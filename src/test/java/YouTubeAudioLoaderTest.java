import Common.YouTubeAudioLoader;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class YouTubeAudioLoaderTest {
    @Test
    public void youTubeAudioLoaderWorksCorrectly() {
        YouTubeAudioLoader audioLoader = new YouTubeAudioLoader("src/main/resources/audioFiles/test/");
        File file = audioLoader.download("https://www.youtube.com/watch?v=FBnAZnfNB6U");
        Assert.assertEquals("LITTLE BIG - LollyBomb [Official Music Video] - (tomp3.pro) 320kbps.mp3",file.getName());
    }
    @Test
    public void youTubeAudioLoaderCreateFolderIfItNotExist() {
        YouTubeAudioLoader audioLoader = new YouTubeAudioLoader("src/main/resources/audioFiles/testOnly/");
        File file = new File("C:/Users/TheDAX/Desktop/TelegramBot/MusicBot/src/main/resources/audioFiles/testOnly/");
        Assert.assertEquals(true,file.exists());
        file.delete();
    }
}
