package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.kafka.support.Acknowledgment;
//import org.springframework.kafka.support.KafkaHeaders;
//import org.springframework.messaging.handler.annotation.Header;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Service;
//
//@Service
//public class Consumer {
//    private Logger logger = LoggerFactory.getLogger(Consumer.class);
//
//    public void consume(final @Payload String message,
//                        final @Header(KafkaHeaders.OFFSET) Integer offset,
//                        final @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
//                        final @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
//                        final @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
//                        final @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts,
//                        final Acknowledgment acknowledgment
//    ) {
//        logger.info("consumed message ?",message);
//        acknowledgment.acknowledge();
//    }
//}
