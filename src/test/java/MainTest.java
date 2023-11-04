import org.example.Main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void testCount() {
        assertEquals(2, Main.count("OGOAGA".toCharArray(), 0));
    }

    @Test
    public void testReplaceOGOandAGA() {
        assertArrayEquals("**BC".toCharArray(), Main.replaceOGOandAGA("OGOBC".toCharArray(), 0));
    }
}
