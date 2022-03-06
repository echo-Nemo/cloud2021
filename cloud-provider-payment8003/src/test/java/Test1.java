import org.junit.Test;

import java.time.ZonedDateTime;

public class Test1 {
    @Test
    public void test() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }
}
