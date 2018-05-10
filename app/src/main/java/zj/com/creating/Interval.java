package zj.com.creating;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Interval {

    private static String TAG = "Interval";

    public static void main(String[] args) {
        Observable.interval(1,TimeUnit.SECONDS).subscribe(new Observer<Long>() {

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
