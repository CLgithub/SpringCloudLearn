import com.cl.springcloud.entities.Payment;
import org.junit.jupiter.api.Test;

/**
 * @Author l
 * @Date 2020/4/14 00:03
 */
public class Test1 {

    @Test
    void test1(){
        Payment payment = new Payment();
        payment.setSerial("abc");
        System.out.println(payment);
    }
}
