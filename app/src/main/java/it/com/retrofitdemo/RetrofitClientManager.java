package it.com.retrofitdemo;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tony on 2017/5/19.
 */

public class RetrofitClientManager {
    private static final String BASE_URL = "http://192.168.2.110:8080/ygw/";
    private static Retrofit instance;

    public static Retrofit getClient() {
        if (instance == null) {
            OkHttpClient okHttpClient = new OkHttpClient();
            instance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)      //1.url地址
                    .client(okHttpClient)   //2.okhttpclient
                    .addConverterFactory(GsonConverterFactory.create())//3.将返回值类型转换为我们想要的bean对象.
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//4.引入RxJava支持接口返回值类型,替换掉Call.
                    .build();
        }
        return instance;
    }
}

/**
 * 前面用到了Retrofit.Builder 中的baseUrl、client、addConverterFactory、addCallAdapterFactory、build方法，
 *
 * 还有
 * callbackExecutor :指定Call.enqueue时使用的Executor，所以该设置只对返回值为Call的方法有效
 * callFactory      :设置一个自定义的okhttp3.Call.Factory，那什么是Factory呢?OkHttpClient就实现了okhttp3.Call.Factory接口;
 *                   下面的client(OkHttpClient)最终也是调用了该方法，也就是说两者不能共用
 * validateEagerly  :是否在调用create(Class)时检测接口定义是否正确，而不是在调用方法才检测，适合在开发、测试时使用
 */


