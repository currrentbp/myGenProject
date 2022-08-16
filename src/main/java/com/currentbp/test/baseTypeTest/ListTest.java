package com.currentbp.test.baseTypeTest;

import com.alibaba.fastjson.JSON;
import com.currentbp.common.model.Human;
import com.currentbp.common.model.Student;
import com.currentbp.common.model.Teacher;
import com.currentbp.util.all.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * 专门用于列表的测试
 *
 * @author current_bp
 * @createTime 20170309
 */
public class ListTest {
    private static Logger logger = LoggerFactory.getLogger(ListTest.class);

    @Test
    public void listSort(){
        List<Integer> list = Lists.newArrayList(10,1, 2, 3, 4, 5, 7, 15, 16, 17);
        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());

        StringUtil.printObject(collect);
    }

    @Test
    public void testShrink() {
        System.out.println(shrink(Lists.newArrayList(1, 2, 3, 4, 5, 7, 15, 16, 17)));
    }

    @Test
    public void parallel() {
        List<Integer> ids = Lists.newArrayList(1, 2, 3, 4, 5, 6);
        try {
            ids.stream().parallel().forEach(id -> {
                if (id == 3) {
                    throw new RuntimeException("id is three");
                } else {
                    try {
                        Thread.sleep(1);
                    } catch (Exception e1) {

                    }
                }
                System.out.println("id:" + id);
            });
            try {
                Thread.sleep(111);
            } catch (Exception e1) {

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //可以设置并行数量
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");
        System.out.println("parallel:"+System.getProperty("java.util.concurrent.ForkJoinPool.common.parallelism"));
    }


    @Test
    public void testExtend() {
        System.out.println(extend("1-5,7,15-17"));
    }

    public static List<Integer> extend(String ids) {
        if (org.springframework.util.StringUtils.isEmpty(ids)) {
            return Collections.emptyList();
        } else {
            List<Integer> result = new ArrayList();
            String[] intervals = ids.split(",");
            String[] var3 = intervals;
            int var4 = intervals.length;

            for (int var5 = 0; var5 < var4; ++var5) {
                String intervalStr = var3[var5];
                String[] interval = intervalStr.split("-");
                if (interval.length == 1) {
                    result.add(Integer.parseInt(interval[0]));
                } else {
                    if (interval.length != 2) {
                        throw new IllegalStateException("invalid interval, interval=" + interval);
                    }

                    int start = Integer.parseInt(interval[0]);
                    int end = Integer.parseInt(interval[1]);

                    for (int i = start; i <= end; ++i) {
                        result.add(i);
                    }
                }
            }

            return result;
        }
    }

    public static String shrink(List<Integer> idList) {
        if (CollectionUtils.isEmpty((Collection) idList)) {
            return null;
        } else {
            Set<Integer> set = new HashSet((Collection) idList);
            if (set.size() < ((List) idList).size()) {
                idList = new ArrayList(set);
            }

            Collections.sort((List) idList);
            int start = (Integer) ((List) idList).get(0);
            int end = start;
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 1; i < ((List) idList).size(); ++i) {
                int current = (Integer) ((List) idList).get(i);
                if (current != end + 1) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(",");
                    }

                    if (start == end) {
                        stringBuilder.append(start);
                    } else {
                        stringBuilder.append(start).append("-").append(end);
                    }

                    start = current;
                }

                end = current;
            }

            if (stringBuilder.length() > 0) {
                stringBuilder.append(",");
            }

            if (start == end) {
                stringBuilder.append(start);
            } else {
                stringBuilder.append(start).append("-").append(end);
            }

            return stringBuilder.toString();
        }
    }

    @Test
    public void listToString() {
        List<Long> tabIds = new ArrayList<>();
        tabIds.add(1L);
        System.out.println(tabIds.toString());
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "1"));
        System.out.println(students.toString());//[Student{id=1, name='1', hobbies=null, course=null, myCourses=null, teacher=null, teachers=null}]
    }

    @Test
    public void t11() {
        long myRemainMoney = 20;
        float rate = 0.5F;
        long drawMoney = (long) Math.floor(myRemainMoney * rate);
        System.out.println(drawMoney);
    }

    @Test
    public void ListToString() {
        List<Long> tabIds = new ArrayList<>();
        tabIds.add(1L);
        List<Long> tabIds2 = new LinkedList<>();
        tabIds2.add(2L);
        Set<Long> set = new HashSet<>();
        set.add(1L);
        Map<Long, Long> map = new HashMap();
        map.put(1L, 2L);
        String chooseTabIds = StringUtils.join(tabIds, ",");
        StringUtil.printObject("=====" + chooseTabIds + "+++++");

        ReentrantLock reentrantLock = new ReentrantLock();
    }

    @Test
    public void fanxing() {
        /**
         * 1、如果泛型是子类，add时必须是子类
         * 2、如果泛型是父类，add是可以是父类也可以是子类
         */
//        List<Teacher> students = new ArrayList<>();
//        Human human = new Teacher();
//        students.add(human);

        List<Human> humans = new ArrayList<>();
        Teacher teacher = new Teacher();
        teacher.setId(1);
        humans.add(teacher);
        Human teacher2 = new Teacher();
        teacher2.setType(0);
        humans.add(teacher2);
        StringUtil.printObject(humans);
    }


    @Test
    public void listRemove() {
        List<Integer> integers = Lists.newArrayList(1, 2, 3, 0);
        integers.remove(Integer.valueOf(0));
        integers.remove(0);
        System.out.println(integers.toString());
    }

    @Test
    public void testGetSize() {
        List<Integer> source = new ArrayList<>(100000000);
        for (int i = 0; i < 50000000; i++) {
            source.add(i + 1);
        }
//        for (int j = 0; j < 20; j++) {
//
//            long start1 = System.currentTimeMillis();
//            for (int i = 0; i < source.size(); i++) {
//                Integer k = source.get(i);
//            }
//            long end1 = System.currentTimeMillis();
//
//            long start2 = System.currentTimeMillis();
//            int size = source.size();
//            for (int i = 0; i < size; i++) {
//                Integer k = source.get(i);
//            }
//            long end2 = System.currentTimeMillis();
//
//            System.out.println("time:" + (j + 1) + " used time1:" + (end1 - start1) + " time2:" + (end2 - start2));
//        }

        for (int j = 0; j < 20; j++) {

            long start1 = System.currentTimeMillis();
            int temp = 0;
            for (int i = 0; i < source.size(); i++) {
                temp = source.get(i);
            }
            long end1 = System.currentTimeMillis();

            long start2 = System.currentTimeMillis();
            int size = source.size();
            for (int i = 0; i < size; i++) {
                temp = source.get(i);
            }
            long end2 = System.currentTimeMillis();

            System.out.println("time:" + (j + 1) + " used time1:" + (end1 - start1) + " time2:" + (end2 - start2));
        }

    }


    @Test
    public void t1() {


        //测试一个对象放入list中，在list中修改该对象的字段，看能否修改成功
//        listTest.object2ListAndChangeSome();

        //测试list的foreach的功能
//        listTest.listForMethod();
        listForMethod2();
    }

    @Test
    public void anyWhereAdd() {
//        List<String> list = new ArrayList<String>();
//        //由于初始化时没有设定数组大小，故会报错
//        list.add(10,"10");//报错：java.lang.IndexOutOfBoundsException: Index: 10, Size: 0
//        logger.info("10:"+list.get(10));


        List<String> list2 = new ArrayList<String>(22);
        //虽然设定了初始化数组的长度是22，但是，arraylist中的size没有改变，在add时，会判断size
        list2.add(10, "10");//java.lang.IndexOutOfBoundsException: Index: 10, Size: 0
        logger.info("10:" + list2.get(10));
    }

    @Test
    public void list2Set() {
        List<String> list = new ArrayList<String>();
        list.add("baopan");
        list.add("currentbp");
        list.add("baopan");
        list.add("bp1");
        logger.info("===>list:" + JSON.toJSONString(list));
        Set<String> set = new HashSet<String>(list);
        logger.info("===>set:" + JSON.toJSONString(set));
    }


    //==================  测试主要方法  =======================================================================//

    public void listRemoveOneGetSize() {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        System.out.println("===>befor: size:" + list.size() + " list:" + JSON.toJSONString(list));
        list.remove(2);
        System.out.println("===>after: size:" + list.size() + " list:" + JSON.toJSONString(list));
    }


    /**
     * 如果没有分隔符，则还是一个数组，只不过长度为1，
     * 如果后面是光秃秃的分隔符，则忽略这些分隔符
     */
    public void stringSplitToArray() {
        String s = "1,,";
        String[] array = s.split(",");
        System.out.println("array:" + JSON.toJSONString(array));
    }


    /**
     * 测试list的foreach的功能
     */
    public void listForMethod() {
        List<String> list = null;

        for (String s : list) {
            System.out.println("s:" + s);
        }
    }

    /**
     * 测试list的foreach的功能
     */
    public void listForMethod2() {
        List<String> list = new ArrayList<String>();

        for (String s : list) {
            System.out.println("s:" + s);
        }
    }


    /**
     * 测试一个对象放入list中，在list中修改该对象的字段，看能否修改成功
     */
    public void object2ListAndChangeSome() {
        TestListObject testListObject = new TestListObject();
        testListObject.setX(10);
        testListObject.setY(20);

        List<TestListObject> testListObjects = new ArrayList<TestListObject>();
        testListObjects.add(testListObject);

        testListObjects.get(0).setY(100);
        testListObjects.get(0).setX(222);

        System.out.println(JSON.toJSONString(testListObjects));
        System.out.println(JSON.toJSONString(testListObject));


    }


}

class TestListObject {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
