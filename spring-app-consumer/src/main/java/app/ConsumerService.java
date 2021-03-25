package app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerService.class);
    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "orders", groupId = "1")
    public void listenGroupFoo(String message) throws JsonProcessingException {
        LOGGER.info("Received Message: {}", objectMapper.readValue(message, Order.class));
    }
}
