package com.currentbp.net.bio;


import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author baopan
 * @createTime 20210306
 */
public class SimpleServer {
    public static void main(String[] args) {
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(10);

            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("服务器启动了。。。");
            while (true) {
                System.out.println("currentTread: id:" + Thread.currentThread().getId() +
                        " name:" + Thread.currentThread().getName());
                Socket accept = serverSocket.accept();
                System.out.println("连接到一个客户端。。。");
                executorService.execute(() -> {
                    System.out.println("currentTread: id:" + Thread.currentThread().getId() +
                            " name:" + Thread.currentThread().getName());
                    handleSocket(accept);
                });
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void handleSocket(Socket socket) {
        try {
            byte[] bytes = new byte[1024];
            System.out.println("socket阻塞中。。");
            InputStream inputStream = socket.getInputStream();
            int read = 0;
            while (-1 != (read = inputStream.read(bytes))) {
                System.out.println("threadId:"+Thread.currentThread().getId()+" threadName:"+Thread.currentThread().getName()
                        +" value:"+new String(bytes, 0, read));
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
