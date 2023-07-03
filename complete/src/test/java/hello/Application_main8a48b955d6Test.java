package hello;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
public class Application_main8a48b955d6Test {

    @Autowired
    private JmsTemplate jmsTemplate;

    @SpyBean
    private ConfigurableApplicationContext context;

    @Test
    public void testMain_success() {
        String[] args = {};
        doReturn(jmsTemplate).when(context).getBean(JmsTemplate.class);
        Application.main(args);
        verify(jmsTemplate, times(1)).convertAndSend("mailbox", new Email("info@example.com", "Hello"));
    }

    @Test
    public void testMain_failure() {
        String[] args = {};
        doThrow(new RuntimeException()).when(context).getBean(JmsTemplate.class);
        try {
            Application.main(args);
        } catch (Exception e) {
            assertTrue(e instanceof RuntimeException);
        }
    }
}
