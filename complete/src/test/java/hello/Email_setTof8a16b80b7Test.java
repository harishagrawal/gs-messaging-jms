package hello;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Email_setTof8a16b80b7Test {

    private Email email;

    @Before
    public void setUp() {
        email = new Email();
    }

    @Test
    public void testSetTo_ValidEmail() {
        String to = "test@example.com";
        email.setTo(to);
        assertEquals("Expected email to be the same as set", to, email.getTo());
    }

    @Test
    public void testSetTo_EmptyString() {
        String to = "";
        email.setTo(to);
        assertEquals("Expected email to be the same as set", to, email.getTo());
    }

    @Test(expected = NullPointerException.class)
    public void testSetTo_Null() {
        String to = null;
        email.setTo(to);
    }
}
