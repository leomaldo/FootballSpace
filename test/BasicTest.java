import net.sf.oval.guard.Post;
import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void aVeryImportantThingToTest() {
        assertEquals(2, 1 + 1);
    }

    @Before
    public void setup() {
        Fixtures.deleteDatabase();
    }

    @Test
    public void createPost() {

    }
}
