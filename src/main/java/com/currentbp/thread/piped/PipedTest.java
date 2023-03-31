package com.currentbp.thread.piped;

import java.io.*;
import java.math.BigInteger;

/**
 * @author baopan
 * @createTime 2023/3/27 21:40
 */
public class PipedTest {


    public static void main(String[] args) throws IOException, InterruptedException {
        BigInteger one = BigInteger.ONE;
        PipedWriter pipedWriter = new PipedWriter();
        PipedReader pipedReader = new PipedReader();
        pipedWriter.connect(pipedReader);
        // 注意：
        // 对于Piped类型的流，必须先要进行绑定，也就是调用connect()方法，
        // 如果没有将输入/输出流绑定起来，对于该流的访问将会抛出异常。
        new Thread(new ReaderThread(pipedReader)).start();
        Thread.sleep(10);
        new Thread(new WriterThread(pipedWriter)).start();
    }

    static class ReaderThread implements Runnable {
        private PipedReader in;
        public ReaderThread(PipedReader in){
            this.in = in;
        }
        @Override
        public void run() {
            System.out.println("This is a Reader");
            int receice = 0;
            try {
                while ((receice=in.read()) != -1){
                    System.out.println("read " + (char)receice);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    static class WriterThread implements Runnable {
        private PipedWriter out;

        public WriterThread(PipedWriter out) {
            this.out = out;
        }

        @Override
        public void run() {
            System.out.println("This is a Writer");
            try {
                out.write("write A");
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
