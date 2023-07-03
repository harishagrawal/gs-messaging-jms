package hello;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmailTest {

    private Email email;

    @Before
    public void init() {
        email = new Email();
    }

    @Test
    public void testSetBody_ValidInput() {
        String expectedBody = "Hello, this is a test email body.";
        email.setBody(expectedBody);
        assertEquals(expectedBody, email.getBody());
    }

    @Test
    public void testSetBody_NullInput() {
        String expectedBody = null;
        email.setBody(expectedBody);
        assertEquals(expectedBody, email.getBody());
    }

    @Test
    public void testSetBody_EmptyString() {
        String expectedBody = "";
        email.setBody(expectedBody);
        assertEquals(expectedBody, email.getBody());
    }
}
