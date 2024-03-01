package org.example.aggregation;

import javax.enterprise.context.ApplicationScoped;
import com.kumuluz.ee.streaming.common.annotations.StreamListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class ConsumerRawData {

    private static final Logger log = Logger.getLogger(ConsumerRawData.class.getName());
    private List<String> messages = new ArrayList<>();

    @StreamListener(topics = {"prometheus_raw_data"})
    public void onMessage(ConsumerRecord<String, String> record) {

        log.info(String.format("Consumed message: offset = %d, key = %s, value = %s%n", record.offset(), record.key()
                , record.value()));

        messages.add(record.value());
    }

    @StreamListener(topics = {"test-kumuluzee"})
    public void onMessageTest(ConsumerRecord<String, String> record) {

        log.info(String.format("Consumed message: offset = %d, key = %s, value = %s%n", record.offset(), record.key()
                , record.value()));

        messages.add(record.value());
    }

    public List<String> getLastFiveMessages() {
        if (messages.size() < 5)
            return messages;
        return messages.subList(messages.size() - 5, messages.size());
    }
}
