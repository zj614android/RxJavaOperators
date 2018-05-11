package zj.com.transforming;

import android.annotation.SuppressLint;

import java.util.List;
import java.util.Observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Buffer {

    private static String TAG = "Buffer";

    private static String[] sendItems = {TAG + "1", TAG + "2", TAG + "3", TAG + "4", TAG + "5", TAG + "6", TAG + "7", TAG + "8"};


    @SuppressLint("CheckResult")
    public static void main(String[] args) {

        io.reactivex.Observable<String> justObservable = io.reactivex.Observable.just(sendItems[0], sendItems[1], sendItems[2], sendItems[3], sendItems[4], sendItems[5], sendItems[6], sendItems[7]);

        /**
         * 参数以int为主的
         */
//        io.reactivex.Observable<List<String>> buffer = justObservable.buffer(3);

        io.reactivex.Observable<List<String>> buffer = justObservable.buffer(3,4);
        buffer.subscribe(new Observer<List<String>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<String> strings) {

                System.out.println(strings.size() + "< ===  strings.size");

                for (int i = 0; i < strings.size(); i++) {
                    System.out.println("RxJava " + TAG + "onNext  __ " + strings.get(i));
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });



        /**
         * 参数以long为主的
         */


        /**
         * 参数以ObservableSource为主的
         */

    }
}
