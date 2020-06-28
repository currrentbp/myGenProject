package com.currentbp.spi;

import com.currentbp.spi.service.HelloService;
import com.currentbp.spi.service.impl.AHelloServiceImpl;
import org.junit.Test;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author baopan
 * @createTime 2020/6/28 10:58
 */
public class SpiTest {

//
//    public static void main(String[] args){
//        ServiceLoader<HelloService> services = ServiceLoader.load(HelloService.class);
//        Iterator<HelloService> iterator = services.iterator();
//
//        while(iterator.hasNext()){
//            HelloService next = iterator.next();
//            System.out.println(next.sayHello("hello world"));
//        }
//    }

    @Test
    public void t1(){
        ServiceLoader<HelloService> services = ServiceLoader.load(HelloService.class);
        Iterator<HelloService> iterator = services.iterator();

        while(iterator.hasNext()){
            HelloService next = iterator.next();
            Class<? extends HelloService> aClass = next.getClass();
            System.out.println(aClass.getName());
            if(AHelloServiceImpl.class.getName().equals(aClass.getName())) {
                System.out.println("A==>"+next.sayHello("hello world"));
            }else{
                System.out.println("B==>"+next.sayHello("hello world"));
            }
        }
    }
}
