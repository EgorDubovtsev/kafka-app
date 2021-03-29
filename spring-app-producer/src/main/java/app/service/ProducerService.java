package app.service;

import app.entity.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ProducerService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private Random random;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerService.class);

    @Scheduled(fixedRate = 1000)
    public void sendMessage() throws JsonProcessingException {
        Order order = createOrder();
        LOGGER.info("SEND {}", order);
        kafkaTemplate.send("orders", objectMapper.writeValueAsString(order));
    }


    private Order createOrder() {
        Order order = new Order();
        order.setId(random.nextInt(1000));
        order.setText("HELLO");
        return order;
    }

}
