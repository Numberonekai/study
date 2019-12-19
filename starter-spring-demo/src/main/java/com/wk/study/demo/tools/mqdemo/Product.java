package com.wk.study.demo.tools.mqdemo;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.Schema;

import java.util.concurrent.TimeUnit;

/**
 * @auther: kai2.wang
 * @date: 2019/11/22 16:02
 * @description:
 * @version: 1.0
 */
public class Product {


    public static void main(String[] args) {
            int sendTimes = 0;
            try {
                PulsarClient client = Configuration.getInstance();
                Producer<String> producer = client.newProducer(Schema.STRING)
                        .topic(Configuration.TOP_DEMO)
                        .batchingMaxPublishDelay(10, TimeUnit.MILLISECONDS)
                        .sendTimeout(10, TimeUnit.SECONDS)
                        .blockIfQueueFull(true).create();
                while (true) {
//                    producer.sendAsync()
                    String message = String.format("Wk-Product-message-%s", ++sendTimes);
                    System.out.println("send message: " + message);
                    producer.send(message);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
