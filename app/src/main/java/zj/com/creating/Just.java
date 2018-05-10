package zj.com.creating;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Just {

    private static String TAG = "Just";

    public static void main(String[] args) {

        Observable.just(TAG + " 操作符 ....  3",TAG + " 操作符 ....  2",TAG + " 操作符 ....  3").subscribe(new Observer<String>() {
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
