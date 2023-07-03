package hello;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmailTest {
    private Email email;

    @Before
    public void setUp() {
        email = new Email();
    }

    @Test
    public void testSetAndGetBody() {
        String body = "Hello, World!";
        email.setBody(body);
        assertEquals(body, email.getBody());
    }
}
