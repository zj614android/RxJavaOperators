package zj.com.creating;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class From {

    private static String TAG = "From";

    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        for (int i = 0; i < 7; i++) {
            list.add("星期" + i);
        }

        Observable.fromIterable(list).subscribe(new Observer<String>() {
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
