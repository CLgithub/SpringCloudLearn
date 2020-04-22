import com.netflix.loadbalancer.RandomRule;
import org.junit.jupiter.api.Test;

/**
 * @Author l
 * @Date 2020/4/21 11:36
 */
public class Test1{

    private static Integer a=0;

    @Test
    public static void test1(){
        Test1 test1 = new Test1();
        Thread[] threads=new Thread[5];
        for(int i=0;i<5; i++){
            threads[i] = new Thread(() ->{
                for(int j=0; j<10; j++){
                    System.out.println(a++);
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });


            threads[i].start();
        }
    }

//    public static void main(String[] args) {
//        Test1 test1 = new Test1();
//        Thread thread1 = new Thread(test1);
//        Thread thread2 = new Thread(test1);
//        Thread thread3 = new Thread(test1);
//        Thread thread4 = new Thread(test1);
//        Thread thread5 = new Thread(test1);
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();
//    }
//
//    @Override
//    public void run() {
//        synchronized (this){
////            for(int j=0; j<10; j++){
////                System.out.println(a++);
////                try {
////                    Thread.sleep(5);
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
////            }
//        }
//    }


}
