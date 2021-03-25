package app;

import app.entity.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl {
    @Autowired
    private KafkaTemplate<Long, Order> kafkaTemplate;
//    @Autowired
    private ObjectMapper objectMapper = new ObjectMapper();

    public OrderServiceImpl(KafkaTemplate<Long, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
//        this.objectMapper = objectMapper;
    }

    public void send(Order dto) {
        kafkaTemplate.send("server.starship", dto);
    }

    @KafkaListener(id = "order", topics = {"orders"}, containerFactory = "singleFactory")
    public void consume(Order dto) {
        System.out.println("CONSUMED " + dto.toString());
    }

    @Scheduled(fixedRateString = "100")
    public void produce() {
        Order order = createDto();
        System.out.println("send " + order.toString());
        kafkaTemplate.send("orders", order);
    }

    private Order createDto() {
        return new Order("order 1");
    }

    private String writeValueAsString(Order dto) {
        try {
            return objectMapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Writing value to JSON failed: " + dto.toString());
        }
    }

}
