package app;

import app.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Scheduled(fixedRate = 1000)
    public void sendMessage() {
        System.out.println("SEND");
        kafkaTemplate.send("orders", "test message");
    }


    private Order createDto() {
        return new Order("order 1");
    }

}
