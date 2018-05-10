package zj.com.creating;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class Range {
    private static String TAG = "Range";

    public static void main(String[] args) {

        //基本
//        Observable.range(1, 10).subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                System.out.println("RxJava " + TAG + "onSubscribe  __ ");
//            }
//
//            @Override
//            public void onNext(Integer s) {
//                System.out.println("RxJava " + TAG + "onNext  __ " + s);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                System.out.println("RxJava " + TAG + "onError  __ ");
//            }
//
//            @Override
//            public void onComplete() {
//                System.out.println("RxJava " + TAG + "onComplete  __ ");
//            }
//        });


        //从1开始输出10个数据，延迟0秒执行，每隔1秒执行一次：
        Observable.intervalRange(0, 11, 0, 1, TimeUnit.SECONDS/*,Schedulers.newThread()*/).subscribe(new Observer<Long>() {

            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("RxJava " + TAG + "onSubscribe  __ ");
            }

            @Override
            public void onNext(Long s) {
                System.out.println("RxJava " + TAG + "onNext  __ " + s);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("RxJava " + TAG + "onError  __ ");
            }

            @Override
            public void onComplete() {
                System.out.println("RxJava " + TAG + "onComplete  __ ");
            }

        });


        try {
            Thread.sleep(20000); // if this is missing then the JVM exits immediately and the new thread is stopped.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
