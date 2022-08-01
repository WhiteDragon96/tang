package com.tang.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Optional;

/**
 * @author tcs
 * @CreateTime: 2022-07-21  11:21
 */
@Component
public class KafkaConsumer {
    private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    //不指定group，默认取spring boot配置文件里面的
    @KafkaListener(topics = {"test"})
    public void onMessage1(ConsumerRecord<?, ?> consumerRecord) {
        Optional<?> optional = Optional.ofNullable(consumerRecord.value());
        if (optional.isPresent()) {
            Object msg = optional.get();
            logger.info("message:{}", msg);
        }
    }
}
