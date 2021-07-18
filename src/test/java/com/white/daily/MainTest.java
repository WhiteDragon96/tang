package com.white.daily;

import com.white.daily.mock.entity.User;
import org.junit.jupiter.api.Test;

import javax.management.timer.Timer;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * @author tcs
 * @date Created in 2021-04-28
 */
public class MainTest {

    @Test
    public void testLocalDate() {
        LocalDate now = LocalDate.now().minus(1, ChronoUnit.DAYS);
        boolean leapYear = now.isLeapYear();
        System.out.println(now);
    }

    @Test
    public void testLocalTime() {
        LocalTime now = LocalTime.now();
        System.out.println(now);
    }

    @Test
    public void testZonedDateTime() {
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(allZoneIds);
    }

    @Test
    public void testPeriod() {
        LocalDate start = LocalDate.parse("2015-10-08");
        LocalDate end = LocalDate.parse("2019-06-27");
        int between = Period.between(start, end).getDays();
        System.out.println(between);

        long between1 = ChronoUnit.DAYS.between(start, end);
        long year = ChronoUnit.YEARS.between(start, end);
        System.out.println(year);
        System.out.println(between1);
    }

    @Test
    public void testDuration(){
        LocalTime start = LocalTime.parse("17:18:18");
        LocalTime end = LocalTime.parse("07:18:18");
        long minutes = ChronoUnit.MINUTES.between(end, start);
        long hours = ChronoUnit.HOURS.between(end, start);
        System.out.println(minutes);
        System.out.println(hours);
    }

    /**
     * 利用Set 去重List
     */
    @Test
    public void testMapToSet(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i+"");
        }
        list.add("1");
        list.add("2");
        list.add("4");
        list.add("5");
        list.add("1");
        list.add("3");

        long setStart = System.currentTimeMillis();
        List<String> setList = new ArrayList<>(new TreeSet<>(list));
        long setEnd = System.currentTimeMillis();

        long streamStart = System.currentTimeMillis();
        List<String> collect = list.stream().distinct().collect(Collectors.toList());
        long streamEnd = System.currentTimeMillis();

        System.out.println(setList);
        System.out.println(setEnd - setStart);
        System.out.println("==============");
        System.out.println(collect);
        System.out.println(streamEnd - streamStart);
    }

    @Test
    public void testList(){
        User user = new User(1, "迪丽热巴", 18, new Date());
        List<User> userList = new ArrayList<User>();
        userList.add(user);
        System.out.println(userList); // [User(id=1, username=迪丽热巴, ...)]
        user.setUsername("德玛西亚");
        System.out.println(userList); // [User(id=1, username=德玛西亚, ...)]
    }

    @Test
    public void testLinkedList(){

        List<Integer> arrayList = new ArrayList<>();
        long arrayListStart = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            arrayList.add(i);
        }
        long arrayListEnd = System.currentTimeMillis();
        System.out.println(arrayListEnd - arrayListStart);
        System.out.println(arrayList.get(11));


        LinkedList<Integer> linkedList = new LinkedList<>();
        long linkedStart = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            linkedList.addFirst(i);
        }
        long linkedEnd = System.currentTimeMillis();
        System.out.println(linkedEnd - linkedStart);
        System.out.println(linkedList.get(999988));
    }

    @Test
    public void testInstant(){
        Instant instant =  Instant.now();
        System.out.println(instant);
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        Lock lock = new ReentrantLock();
        lock.lock();
    }

    @Test
    public void testSwitch(){
        /// 恢复
        String param = "null3";
        switch (param) {
            // 肯定不是进入这里
            case "sth":
                System.out.println("it's sth");
                break;
            // 也不是进入这里
            case "null":
                System.out.println("it's null");
                break;
            // 也不是进入这里
            default:
                System.out.println("default");
        }
    }

    @Test
    public void testHashMap(){

        Map<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1,"hello");
        System.out.println(hashMap.size());

    }
}
