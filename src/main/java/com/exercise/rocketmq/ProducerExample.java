package com.exercise.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.apis.ClientConfiguration;
import org.apache.rocketmq.client.apis.ClientConfigurationBuilder;
import org.apache.rocketmq.client.apis.ClientException;
import org.apache.rocketmq.client.apis.ClientServiceProvider;
import org.apache.rocketmq.client.apis.message.Message;
import org.apache.rocketmq.client.apis.producer.Producer;
import org.apache.rocketmq.client.apis.producer.SendReceipt;

import java.io.IOException;

/**
 * @ClassName ProducerExample
 * @Description TODO
 * @Author yeqiang
 * @Date 2023/6/19 22:59
 * @Version 1.0
 **/
@Slf4j
public class ProducerExample {

    public static void main(String[] args) throws ClientException, IOException {
        String endpoint = "localhost:8081";
        String topic = "TestTopic";
        ClientServiceProvider provider = ClientServiceProvider.loadService();
        ClientConfigurationBuilder builder = ClientConfiguration.newBuilder().setEndpoints(endpoint);
        ClientConfiguration configuration = builder.build();
        Producer producer = provider.newProducerBuilder()
                .setTopics(topic)
                .setClientConfiguration(configuration)
                .build();
        Message message = provider.newMessageBuilder()
                .setTopic(topic)
                .setKeys("messageKey")
                .setTag("messageTag")
                .setBody("messageBody".getBytes())
                .build();
        try {
            SendReceipt sendReceipt = producer.send(message);
            System.out.println("Send message successfully, messageId={}"+ sendReceipt.getMessageId());
        } catch (ClientException e) {
            log.error("Failed to send message", e);
        }
        // producer.close();
    }
}
