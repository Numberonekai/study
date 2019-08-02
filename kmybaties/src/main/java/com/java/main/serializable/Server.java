package com.java.main.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: kai2.wang
 * @Date: 2019/7/31 16:55
 * @Description:
 */
public class Server{

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket=new ServerSocket(8080);

            Socket socket=serverSocket.accept();

            ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());

            User user=(User)objectInputStream.readObject();
            System.out.println("--->>user<<----"+user);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
