package zj.com.creating;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Timer {


//创建一个Observable，它在一个给定的延迟后发射一个值,需要注意，它只发射一次，所以有别于之前用的TimerTask。timer()只是用来创建一个Observable，并延迟发送一次的操作符，并不会按周期执行。

    public static String TAG = "Timer";

    public static void main(String[] args) {

        Observable.<String>timer(5, TimeUnit.SECONDS).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println(TAG + "_________" +"onSubscribe");
            }

            @Override
            public void onNext(Long aLong) {
                System.out.println(TAG + "_____onNext____" +aLong);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(TAG + "_________" +"onError");
            }

            @Override
            public void onComplete() {
                System.out.println(TAG + "_________" +"onComplete");
            }
        });


        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
