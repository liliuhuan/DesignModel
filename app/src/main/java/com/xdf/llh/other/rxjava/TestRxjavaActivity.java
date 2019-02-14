package com.xdf.llh.other.rxjava;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.xdf.llh.designdemo.R;
import com.xdf.llh.other.dagger2.TestDaggerActivity;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class TestRxjavaActivity extends AppCompatActivity {

    private String tag = TestDaggerActivity.class.getSimpleName() + "---";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_rxjava);
        /**
         * 同线程
         */
        testData();
        /**
         * Scheduler  异步线程
         */
        testAsyData();

        /**
         * Api(); map flatMap lift compose  doOnSubscribe
         */

        testApiData();
    }


    private void testData() {
        /**
         * 观察者
         */
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        };

        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        };
        /**
         * 被观察者
         */
        Observable observable = Observable.unsafeCreate(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello");
                subscriber.onNext("Hi");
                subscriber.onNext("Aloha");
                subscriber.onCompleted();
            }
        });
        Observable observable1 = Observable.just("Hello", "Hi", "Aloha");
        String[] words = {"Hello", "Hi", "Aloha"};
        Observable observable2 = Observable.from(words);

        observable.subscribe(observer);
        // 或者：
        observable2.subscribe(subscriber);

        /**
         * 接口加载的事件
         */
        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {

            }
        };

        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

            }
        };

        Action0 action0 = new Action0() {
            @Override
            public void call() {
                Log.d("22", "completed");
            }
        };

        observable.subscribe(onNextAction);
        observable.subscribe(onNextAction, onErrorAction);
        observable.subscribe(onNextAction, onErrorAction, action0);

        /**
         * 依次发射加载的数据
         */
        String[] names = {"1", "2", "2"};
        Observable.from(names).subscribe(new Action1<String>() {
            @Override
            public void call(String name) {
                Log.d(tag, name);
            }
        });

        /**
         * 获取图片根据id
         */
        getDrawableById();
    }

    /**
     * 获取图片根据id
     */
    @SuppressLint({"NewApi", "LocalSuppress"})
    private void getDrawableById() {
        final int drawableRes = R.drawable.ic_launcher_background;
        final ImageView imageView = new ImageView(this);
        Observable.unsafeCreate(new Observable.OnSubscribe<Drawable>() {
            @Override
            public void call(Subscriber<? super Drawable> subscriber) {
                Drawable drawable = getTheme().getDrawable(drawableRes);
                subscriber.onNext(drawable);
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Drawable>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(TestRxjavaActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(Drawable drawable) {
                        imageView.setImageDrawable(drawable);
                    }
                });
    }

    /**
     * 测试线程切换
     */
    private void testAsyData() {
        Observable.just(1, 2, 3, 4)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer number) {
                        Log.d(tag, "number:" + number);
                    }
                });

        getDrawableById();
    }

    /**
     * 测试Api
     */
    private void testApiData() {
        /**
         * map
         */
        Observable.just("images/logo.png")
                .map(new Func1<String, Bitmap>() {
                    @Override
                    public Bitmap call(String url) {
                        return downloadUrlToBitmap(url);
                    }
                }).subscribe(new Action1<Bitmap>() {
            @Override
            public void call(Bitmap bitmap) {

            }
        });

        /**
         * flatMap
         */

        com.xdf.llh.other.rxjava.TestFlatMapBean[] datas = {};
        Observable.from(datas).flatMap(new Func1<com.xdf.llh.other.rxjava.TestFlatMapBean, Observable<com.xdf.llh.other.rxjava.TestFlatMapBean.Course>>() {
            @Override
            public Observable<com.xdf.llh.other.rxjava.TestFlatMapBean.Course> call(com.xdf.llh.other.rxjava.TestFlatMapBean testData) {
                return Observable.from(testData.getCourses());
            }
        })
//                .map(new Func1<TestFlatMapBean.Course, String>() {
//            @Override
//            public String call(TestFlatMapBean.Course course) {
//                return null;
//            }
//        })
                .subscribe(new Action1<com.xdf.llh.other.rxjava.TestFlatMapBean.Course>() {
                    @Override
                    public void call(com.xdf.llh.other.rxjava.TestFlatMapBean.Course course) {
                        Log.e(tag, course.getName());
                    }
                });
        /**
         * lift()  针对事件序列的处理和再发送
         */

        Observable.just(1, 2, 3, 4).lift(new Observable.Operator<String, Integer>() {
            @Override
            public Subscriber<? super Integer> call(final Subscriber<? super String> subscriber) {
                return new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        subscriber.onNext(integer + "--");
                    }
                };
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.e(tag, s);
                /** 输出结果
                 * 1--
                 * 2--
                 * 3--
                 * 4--
                 */
            }
        });

        /**
         * compose    lift() 是针对事件项和事件序列的，而 compose() 是针对 Observable 自身进行变换。
         */
        Observable.just(1, 2, 3, 4).map(new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return integer + "--";
            }
        }).compose(this.<String>applySchedulers())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.e(tag, s);
                        /** 输出结果
                         * 1--
                         * 2--
                         * 3--
                         * 4--
                         */
                    }
                });

        /**
         *
         * doOnSubscribe
         */
        Observable.unsafeCreate(new Observable.OnSubscribe<Bitmap>() {
            @Override
            public void call(Subscriber<? super Bitmap> subscriber) {
                // TODO: 2019/2/14  下载的耗时操作在子线程，更新进度在主线程用doOnSubscribe 切换更新操作，更新完成后再主线程现实下载的图片
                //  subscriber.onNext("url");
                subscriber.onCompleted();
            }
        })
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        // progressBar.setVisibility(View.VISIBLE); // 需要在主线程执行
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread()) // 指定主线程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Bitmap>() {
                    @Override
                    public void call(Bitmap bitmap) {

                    }
                });
    }

    /**
     * 转换器1
     */
    public class CustomTransformer implements Observable.Transformer<String, String> {
        @Override
        public Observable<String> call(Observable<String> stringObservable) {
            return stringObservable
                    .subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    }

    /**
     * 转换器2
     */
    <T> Observable.Transformer<T, T> applySchedulers() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 转换器3
     */
    Observable.Transformer schedulersTransformer() {
        return new Observable.Transformer() {
            @Override
            public Object call(Object observable) {
                return ((Observable) observable).subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 下载图片操作
     *
     * @param s
     * @return
     */
    private Bitmap downloadUrlToBitmap(String s) {
        return BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background);
    }
}
