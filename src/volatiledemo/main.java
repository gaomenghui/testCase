package volatiledemo;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class main {

    public static void main(String args[]) {
        int num = lengthOfLongestSubstring("pwwkew");
        System.out.println(num);
        //for (int i = 0; i < 10; i++) {
            VolatileTest volatileTest = new VolatileTest(1);
        for (int i = 0; i < 1; i++) {
        /*new Thread(() -> volatileTest.read()).start();
            new Thread(() -> volatileTest.write()).start();
        new Thread(() -> volatileTest.write()).start();
        new Thread(() -> volatileTest.write()).start();
            new Thread(() -> volatileTest.read()).start();*/
            new Thread(() -> volatileTest.increase()).start();
            new Thread(() -> volatileTest.increase()).start();
            new Thread(() -> volatileTest.increase()).start();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String str = "acb";
        char[] chars = str.toCharArray();
    }

    public static int lengthOfLongestSubstring(String s) {
        List<String> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i ++) {
            if (!list.contains(chars[i] + "")) {
                list.add(chars[i] + "");
            }
        }
        Iterator<String> ite =  list.iterator();
        StringBuilder temp = new StringBuilder();
        while(ite.hasNext()) {
            temp.append(ite.next());
        }
        while(!s.contains(temp.toString())) {
            String str = temp.toString();
            temp = new StringBuilder(str.substring(1, str.length()));
        }
        return temp.length();
    }
}
