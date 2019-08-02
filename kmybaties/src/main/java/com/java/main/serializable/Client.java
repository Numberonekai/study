package com.java.main.serializable;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @Auther: kai2.wang
 * @Date: 2019/7/31 16:55
 * @Description:
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("localhost",8080);
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
        User user=new User();
        user.setId(1);
        user.setName("test");
        objectOutputStream.writeObject(user);
    }
}
