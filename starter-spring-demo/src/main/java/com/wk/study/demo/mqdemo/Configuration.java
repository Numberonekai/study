package com.wk.study.demo.mqdemo;

import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;

/**
 * @auther: kai2.wang
 * @date: 2019/11/22 16:02
 * @description:
 * @version: 1.0
 */
public class Configuration {

    private static PulsarClient pulsarClient;

    public static final String TOP_DEMO="topic-demo";

    public static final String Subscription="demo-subscription";


    private static final String SERVER_URL="pulsar://192.168.2.22:6650";

    public static PulsarClient getInstance(){
        try {
            pulsarClient=PulsarClient.builder().serviceUrl(SERVER_URL).build();
        } catch (PulsarClientException e) {
            e.printStackTrace();
        }
        return pulsarClient;
    }
}
