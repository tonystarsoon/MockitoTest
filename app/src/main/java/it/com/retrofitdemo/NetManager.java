package it.com.retrofitdemo;

/**
 * Created by tony on 2017/5/19.
 */
public class NetManager {
    public static TestService getTService(){
        return RetrofitClientManager.getClient().create(TestService.class);
    }
}



