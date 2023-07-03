package hello;

import jakarta.jms.ConnectionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class Application_myFactory5ca980a72aTest {

    @InjectMocks
    private Application application = new Application();

    @Mock
    private ConnectionFactory connectionFactory;

    @Mock
    private DefaultJmsListenerContainerFactoryConfigurer configurer;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMyFactory() {
        JmsListenerContainerFactory<?> factory = application.myFactory(connectionFactory, configurer);
        verify(configurer).configure(any(DefaultJmsListenerContainerFactory.class), any(ConnectionFactory.class));
    }

    @Test
    public void testMyFactoryWithNullConfigurer() {
        DefaultJmsListenerContainerFactoryConfigurer configurer2 = mock(DefaultJmsListenerContainerFactoryConfigurer.class);
        JmsListenerContainerFactory<?> factory = application.myFactory(connectionFactory, configurer2);
        verify(configurer2, never()).configure(any(DefaultJmsListenerContainerFactory.class), any(ConnectionFactory.class));
    }
}
