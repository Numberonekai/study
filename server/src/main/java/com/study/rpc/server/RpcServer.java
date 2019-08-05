package com.study.rpc.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther: kai2.wang
 * @date: 2019/8/5 14:33
 * @description:
 * @version: 1.0
 */
public class RpcServer {

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public RpcServer(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                executorService.execute(new ProcessHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
