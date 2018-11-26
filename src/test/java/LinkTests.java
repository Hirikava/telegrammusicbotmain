import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class LinkTests {

    private Link link;
    @Before
    public void setUp(){
        link = new Link();
    }
    @Test
    public void linkGoesWithEanglishRequest() {
        Assert.assertEquals("https://www.youtube.com/watch?v=Cwkej79U3ek",link.searchLink("a thousand miles"));
    }
    @Test
    public void linkGoesWithRussianRequest() {
        Assert.assertEquals("https://www.youtube.com/watch?v=QiFBgtgUtfw", link.searchLink("три полоски"));
    }
    @Test
    public void linkGoesWithWierdChinesSymbolsWTF(){
        Assert.assertEquals("https://www.youtube.com/watch?v=_ytjjhOYgOU", link.searchLink("Mermaid girl-秋葉工房 MIX"));
    }
}
