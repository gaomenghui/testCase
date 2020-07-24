package volatiledemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class VolatileTest {

    private int i;
    volatile boolean flag = true;
     int j = 0;

   public VolatileTest(int i) {
       this.i = i;
   }

    void write() {
        if (flag) {
            System.out.println(i + "写入成功");
            flag = false;
        } else {
            System.out.println("写入失败");
        }
    }

    void read() {
        if (!flag) {
            System.out.println(i + "读取成功");
        } else {
            System.out.println(i + "读取失败");
        }
    }

    void increase() {
       for (int a = 0; a < 100; a ++) {
           j += a;
       }
        System.out.println("结果"+j);

       Map map = new HashMap<>();
        Iterator<Map.Entry<String, String>> ite =  map.entrySet().iterator();
       map.values();
    }
}
