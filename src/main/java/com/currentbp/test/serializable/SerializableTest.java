package com.currentbp.test.serializable;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.io.*;
import java.util.List;

/**
 * @author baopan
 * @createTime 2020/6/23 19:01
 */
public class SerializableTest {

    @Test
    public void useSerializable() throws Exception{
        MyDemo myDemo = new MyDemo();
        myDemo.setId(1);
        myDemo.setName("111111");
        myDemo.setInteresting("kkkkkkkk");
        myDemo.setIds(Lists.newArrayList(1,2,3,4,5));
        ObjectOutputStream out  = new ObjectOutputStream(new FileOutputStream("xuliehua"));
        out.writeObject(myDemo);
        System.out.println("序列化完毕..");
        out.close();


        ObjectInputStream in = new ObjectInputStream(new FileInputStream("xuliehua"));
        MyDemo beanResult = (MyDemo) in.readObject();
        System.out.println("反序列化完毕..");
        System.out.println(beanResult);
    }
    @Test
    public void notUseSerializable() throws Exception{
        //由于bean没有序列化会在导出流的序列化过程中报错：NotSerializableException
        MyDemo2 myDemo = new MyDemo2();
        myDemo.setId(1);
        myDemo.setName("111111");
        ObjectOutputStream out  = new ObjectOutputStream(new FileOutputStream("xuliehua2"));
        out.writeObject(myDemo);
        System.out.println("序列化完毕..");
        out.close();


        ObjectInputStream in = new ObjectInputStream(new FileInputStream("xuliehua2"));
        MyDemo2 beanResult = (MyDemo2) in.readObject();
        System.out.println("反序列化完毕..");
        System.out.println(beanResult);
    }


}

class MyDemo implements Serializable{
    private Integer id;
    private String name;
    private transient String interesting;

    private transient List<Integer> ids;//如果对一个列表做transient，那么表明默认的序列化不会对他做任何事情
    //而ArrayList中的数组也是transient的，但是writeObject和readObject都做重写了

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInteresting() {
        return interesting;
    }

    public void setInteresting(String interesting) {
        this.interesting = interesting;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "MyDemo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", interesting='" + interesting + '\'' +
                ", ids=" + ids +
                '}';
    }
}
class MyDemo2{
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyDemo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}