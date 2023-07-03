package hello;

import org.junit.Assert;
import org.junit.Test;

public class Email_toStringd401c330fbTest {

    @Test
    public void testToStringWithValidEmail() {
        Email email = new Email();
        email.setTo("test@example.com");
        email.setBody("Hello, World!");

        String result = email.toString();

        Assert.assertEquals("Email{to=test@example.com, body=Hello, World!}", result);
    }

    @Test
    public void testToStringWithEmptyEmail() {
        Email email = new Email();
        email.setTo("");
        email.setBody("");

        String result = email.toString();

        Assert.assertEquals("Email{to=, body=}", result);
    }

    @Test(expected = NullPointerException.class)
    public void testToStringWithNullEmail() {
        Email email = new Email();
        email.setTo(null);
        email.setBody(null);

        String result = email.toString();
    }
}
