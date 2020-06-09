import java.time.ZonedDateTime;

/**
 * @Author l
 * @Date 2020/6/9 11:01
 */
public class T1 {

    /**
     * 获取gateway 匹配时间字符串方法，java8新特效
     * @param args
     */
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime=ZonedDateTime.now();

        System.out.println(zonedDateTime);
    }
}
