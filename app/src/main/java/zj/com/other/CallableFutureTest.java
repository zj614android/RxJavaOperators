package zj.com.other;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableFutureTest {

    private static String TAG = "CallableFutureTest";

    public static void main(String[] args) {

        //定义callable
        Callable<String> callable = new Callable<String>() {

            //这个call就相当于runnable的run方法，注意还能抛异常哦
            public String call() throws Exception {

                System.out.println(TAG + "____do something in background");

                Thread.sleep(2000);// 线程处理一些事物

                return TAG + "____" + new Random().nextInt(100);

            }
        };

        //callable和FutureTask相互关联
        FutureTask<String> future = new FutureTask<String>(callable);

        //启动线程，传入一个FutureTask
        new Thread(future).start();

        //future.get
        try {

            Thread.sleep(5000);// 可能做一些事情

            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
