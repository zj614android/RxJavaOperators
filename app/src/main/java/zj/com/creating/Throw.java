package zj.com.creating;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Throw {

    public static String TAG = "Throw";

    public static void main(String[] args) {

        Observable.<String>error(new Callable<Throwable>() {
            @Override
            public Throwable call() throws Exception {
                return null;
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("RxJava " + TAG + "onSubscribe  __ ");
            }

            @Override
            public void onNext(String s) {
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

    }
}
