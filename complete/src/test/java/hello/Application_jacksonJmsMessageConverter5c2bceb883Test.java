package hello;

import org.junit.jupiter.api.Test;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Application_jacksonJmsMessageConverter5c2bceb883Test {

    @Test
    public void testJacksonJmsMessageConverter() {
        Application application = new Application();
        MessageConverter converter = application.jacksonJmsMessageConverter();

        assertNotNull(converter, "Converter should not be null");
        assertTrue(converter instanceof MappingJackson2MessageConverter, "Converter should be instance of MappingJackson2MessageConverter");
    }

    @Test
    public void testJacksonJmsMessageConverterFailure() {
        Application application = new Application();
        MessageConverter converter = application.jacksonJmsMessageConverter();

        assertNotNull(converter, "Converter should not be null");
        assertTrue(converter instanceof MappingJackson2MessageConverter, "Converter should be instance of MappingJackson2MessageConverter");

        MappingJackson2MessageConverter mappingConverter = (MappingJackson2MessageConverter) converter;
        try {
            mappingConverter.setTargetType(MessageType.BYTES);
        } catch (IllegalArgumentException e) {
            assertEquals("Target type should be TEXT", e.getMessage());
        }
        try {
            mappingConverter.setTypeIdPropertyName(null);
        } catch (IllegalArgumentException e) {
            assertEquals("Type id property name should be '_type'", e.getMessage());
        }
    }
}
