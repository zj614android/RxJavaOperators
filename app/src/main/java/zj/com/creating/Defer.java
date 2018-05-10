package zj.com.creating;


import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Defer {

    private static String TAG = "Defer";

    private static String valueStr = "1111111111111";

    private static Observable<String> deferObservable = null;

    public static void main(String[] args) {

        deferObservable = Observable.defer(new Callable<ObservableSource<String>>() {

            @Override
            public ObservableSource<String> call() throws Exception {

                return Observable.just(valueStr);

            }

        });

//        deferObservable = Observable.just(valueStr);

        valueStr = "22222222222";

        deferObservable.subscribe(new Observer<String>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {

                System.out.println(TAG + "________" + s);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }

        });

    }
}
