package com.wk.study.demo.mqdemo;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.Schema;

/**
 * @auther: kai2.wang
 * @date: 2019/11/22 17:45
 * @description:
 * @version: 1.0
 */
public class ReceiveTest {

    public static void main(String[] args) {
        try {
            PulsarClient client = Configuration.getInstance();
            Consumer consumer = client.newConsumer(Schema.STRING)
                    .topic(Configuration.TOP_DEMO)
                    .subscriptionName(Configuration.Subscription).subscribe();
            while (true) {
                Message message = consumer.receive();
                System.out.println("receive message------------: " + message.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
